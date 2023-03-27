package ir.translation;

import ast.*;
import ir.Frame;
import ir.Register;
import ir.com.*;
import ir.expr.*;
import ir.expr.ExpressionIr;
import semantic.*;
import support.*;

import java.util.*;

public class Translate {
    public static final Errors errors = new Errors();
    private static final TypeConverter typeConverter = new TypeConverter();

    //retourne la représentation intermédiaire du programme.
    public static Pair<Label, List<Pair<Frame, List<Command>>>>
    run(SymbolTable symbolTable, Program program) {
        TranslationVisitor translator = new TranslationVisitor(symbolTable);
        program.accept(translator);
        return new Pair<>(translator.mainLabel, translator.fragments);
    }

    //transforme un type de l’Ast en type de la repr. int.
    private static ir.Type ofType(Type type) {
        return type.accept(typeConverter);
    }

    private static class TypeConverter extends ast.BaseVisitor<ir.Type> {
        public TypeConverter() {
            super(null);
        }

        @Override
        public ir.Type visit(TypePrim type) {
            switch (type.getPrim()) {
                case INT:
                    return ir.Type.INT;
                case BOOL:
                    return ir.Type.BYTE;
            }
            throw new Error("Translate: Unknown primitive type, please report");
        }
    }

    private static class TranslationVisitor implements ast.Visitor<Result> {

        private final SymbolTable symbolTable;
        private final TypeChecker typeChecker;

        private final Map<String, Frame> frames;
        private final Map<Pair<Block, String>, Register> varToReg;
        //pour le lien entre noms de variables et registres.
        private final List<Pair<Frame, List<Command>>> fragments;
        //contiendra le code des fonctions, associé à leurs frames.
        private Frame currentFrame;
        private Label mainLabel;

        public TranslationVisitor(SymbolTable symbolTable) {
            this.symbolTable = symbolTable;
            this.varToReg = new HashMap<>();
            this.typeChecker = new TypeChecker(symbolTable);
            this.fragments = new LinkedList<>();
            this.frames = new HashMap<>();
            this.currentFrame = null;
            this.mainLabel = null;
        }

        private Pair<Block, String> inCurrentBlock(String variable) {
            return new Pair<>(typeChecker.getVisitedBlocks().peek(), variable);
        }


        @Override
        public Result visit(TypePrim tp) {
            assert false : "Translate: internal error. This node should not be visited, please report";
            return null;
        }

        @Override
        public Result visit(Id i) {
            assert false : "Translate: internal error. This node should not be visited, please report";
            return null;
        }

        @Override
        public Result visit(Formal tp) {//formal = paramètres de fonctions
            assert false : "Translate: internal error. This node should not be visited, please report";
            return null;
        }

        @Override
        public Result visit(StatVarDeclAff s) {//int x = 1. décomposé lors de l’analyse sémantique
            assert false : "Translate: internal error. This node should not be visited, please report";
            return null;
        }

        @Override
        public Result visit(StatIncr s) {//x++
            assert false : "Translate: internal error. This node should not be visited, please report";
            return null;
        }

        @Override
        public Result visit(StatFor stm) {//transformé en boucle while
            assert false : "Translate: internal error. This node should not be visited, please report";
            return null;
        }

        @Override
        public Result visit(StatPrint s) {
            //impressions d’entiers uniquement
            ast.Expression e = s.getExpression();
            List<ast.Expression> argList = new ArrayList<>();
            argList.add(e);
            Frame frame = PredefinedFrames.PRINT_INT;

            Pair<List<ExpressionIr>, List<Command>> translation =
                    translateExpressions(argList);

            List<Command> code = translation.getSnd();
            List<ExpressionIr> args = translation.getFst();
            //si on n’a pas de type void,
            //on laisse un int en retour par défaut
            Type type = new TypePrim(null, TypePrim.Prim.INT);
            Result result = makeFunCall(type, frame, args, code);


            return result;
        }

        @Override
        public Result visit(ExpCons exp) {
            //les booléens sont traités comme des entiers (0 ou 1), mais
            //traduit en octets pour minimiser leur taille en mémoire

            int res = 0;

            switch (exp.getConstant()) {
                case TRUE -> res = 1;
                case FALSE -> res = 0;
                default -> {
                }
            }
            return new Result(new ir.expr.Byte((byte) res));
        }

        @Override
        public Result visit(ExpInt exp) {
            return new Result(exp.accept(this).getExp());
        }


        private Register registerLookup(String name) {
            //retourne le registre associé au nom de variable 'name'
            //erreur si registre non trouvé
            //
            //Attention, comme pour l’analyse de type, la recherche
            //parcourt l’historique des blocs jusqu’à trouver un
            //résultat non nul dans l’association varToReg
            //..


        }

        @Override
        public Result visit(ExpId exp) {
            Register reg = registerLookup(exp.getValue());
            return new Result(new ReadReg(reg));
        }

        @Override
        public Result visit(ExpBin exp) {

            Result resultLeft = exp.getLeftExp().accept(this);
            Result resultRight = exp.getRightExp().accept(this);
            BinOp op = exp.getOp();
            ExpressionIr expIr = new Binary(resultLeft.getExp(), resultRight.getExp(), op);

            return new Result(expIr, ListTools.mergeList(resultLeft.getCode(), resultRight.getCode()));
        }

        @Override
        public Result visit(ExpUn exp) {
            //…
            Result result = exp.getExp().accept(this);
            UnOp op = exp.getOp();
            ExpressionIr expIr = new Unary(result.getExp(), op);

            return new Result(expIr, result.getCode());
        }


        @Override
        public Result visit(StatAff s) {

            Result resultExp = s.getExpression().accept(this);
            List<Command> code = new LinkedList<>(resultExp.getCode());
            String id = s.getId().getName();
            Register reg = registerLookup(id);
            assert reg != null : "Internal Error: no register associated with " + id;
            code.add(new WriteReg(reg, resultExp.getExp()));

            return new Result(code);
        }

        @Override
        public Result visit(StatReturn stm) {
            Result result = stm.getExpression().accept(this);
            Register returnReg = currentFrame.getResult().get();
            Command writeReturnReg = new WriteReg(returnReg, result.getExp());
            Command gotoExitPoint = new Jump(currentFrame.getExitPoint());
            List<Command> code = new LinkedList<>(result.getCode());
            code.add(writeReturnReg);
            code.add(gotoExitPoint);
            return new Result(code);
        }

        private Pair<List<ExpressionIr>, List<Command>>
        translateExpressions(List<ast.Expression> exps) {
            List<Command> code = new LinkedList<>();
            List<ExpressionIr> expressionIrs = new LinkedList<>();
            for (ast.Expression expression : exps) {
                Result result = expression.accept(this);
                expressionIrs.add(result.getExp());
                code.addAll(result.getCode());
            }
            return new Pair<>(expressionIrs, code);
        }

        private Result makeFunCall(Type type, Frame frame,
                                   List<ExpressionIr> arguments,
                                   List<Command> code) {
            Register reg = new Register(ofType(type));
            currentFrame.addLocal(reg);
            Command call = new FunCall(reg, frame, arguments);
            code.add(call);
            return new Result(new ReadReg(reg), code);
        }

        private List<Type> getArgumentTypes(List<ast.Expression> args) {
            List<Type> expType = new ArrayList<>();

            for (int i = 0; i <= args.size(); i++) {
                expType.add(args.get(i).accept(typeChecker));
            }
            return expType;
        }

        @Override
        public Result visit(ExpCallMethod exp) {
            String functionName = exp.getMethod().getName();

            Pair<List<ExpressionIr>, List<Command>> translation =
                    translateExpressions(exp.getArgs());
            List<Command> code = translation.getSnd();
            List<ExpressionIr> arguments = translation.getFst();
            MethodSig signature = symbolTable.methodLookup(functionName);
            assert !(signature == null) : "Internal Error: function name not in symbol table: " + functionName;

            List<Type> argumentTypes = getArgumentTypes(exp.getArgs());
            Type returnType = signature.getReturnType();

            Frame frame = frames.get(functionName);
            Result result = makeFunCall(returnType, frame, arguments, code);
            return result;
        }

        @Override
        public Result visit(StatIf stm) {
            //…
        }


        @Override
        public Result visit(StatWhile stm) {
            //…
        }


        @Override
        public Result visit(StatVarDecl stm) {
            //créer un nouveau registre du bon type et l’associer au nom
            //de la variable déclarée. Puis l’ajouter au Frame courant.
            //
            //…

        }

        @Override
        public Result visit(Block block) {
            //pousser le bloc sur la pile/historique
            //puis récupérer le code intermédiaire récursivement,
            //et le dépiler avant de retourner ce code.
            //
            //…
        }

        @Override
        public Result visit(StatList sl) {
            //…
        }

        @Override
        public Result visit(MethodDecl md) {
            String key = md.getId().getName();
            //on récupère le frame associé à la clef (erreur si non trouvé)
            //on met à jour le frame courant avec ce dernier
            //
            //on récupère le résultat 'result' issu de la visite du corps de la
            //fonction
            //
            fragments.add(new Pair<>(frame, result.getCode()));
            return null;
        }

        @Override
        public Result visit(Program program) {
            program.accept(typeChecker);
            FramesBuilder framesBuilder = new FramesBuilder();
            program.accept(framesBuilder);
            for (MethodDecl fun : program.getListMethodDecl())
                fun.accept(this);
            return null;
        }

        private class FramesBuilder extends ast.BaseVisitor<Void> {
            //on crée ici les frames nécessaires, pour toutes les
            //fonctions définies dans le programme.
            FramesBuilder() {
                super(null);
            }

            @Override
            public Void visit(MethodDecl function) {
                //ici, on remplit la map 'frames', sans rien retourner.
                //
                //On crée une liste de registre correspondant à la liste
                //des paramètres de la fonction
                List<Register> parameters = new LinkedList<>();
                for (Formal argument : function.getFormal()) {//parcours des paramètres
                    //créer un registre adapté et l’ajouter à la map
                    //'varToReg', ainsi qu’à la liste de registres
                    //initialisée plus haut, pour le frame.
                    //
                    //…
                }
                Frame frame;
                //on n’oublie pas, avant de créer le frame, de convertir le
                //type de l’AST en type de la rep. int.
                //…
                frame = new Frame(Label.fresh(),
                        Label.fresh(),
                        parameters,
                        new Register(irType));

                frames.put(function.getId().getName(), frame);
                if (function.getId().getName().equals("main"))
                    mainLabel = frame.getEntryPoint();
                return null;
            }

            @Override
            public Void visit(Program program) {

                //visiter toutes les méthodes du programme (cela remplira la
                //map 'frames'), et ajouter les fonctions prédéfinies dans
                //'PredefinedFrames' dans la map 'frames'.
                return null;
            }
        }
    }
}
