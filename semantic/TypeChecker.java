package semantic;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import ast.*;
import semantic.SymbolTable;
import java.util.Stack;

public class TypeChecker extends ast.BaseVisitor<Type>{
	private SymbolTable table;
	private String currentMethod;
	private Stack<Block> visitedBlocks;

	public Stack<Block> getVisitedBlocks(){
		return visitedBlocks;
	}


	//Dans un second temps :
	//- Vérifiez que dans le corps de chaque méthode, une valeur
	//	du bon type est retournée (dans chaque branche des
	//	conditionnelles, en particulier).
	//
	//- Vérifiez pour chaque nœud qu’il est atteignable,
	//    c’est-à-dire qu’il ne vient pas après un 'return'. Sinon,
	//    levez une erreur.
	
	private final static Type statType = new TypePrim(null, TypePrim.Prim.STAT);//pour les instructions
	private final static Type errType = new TypePrim(null, TypePrim.Prim.IND);//pour les erreurs

	public TypeChecker(SymbolTable t){
		//le TypeChecker dépend de la table des symboles qui a
		//été créée à l’étape précédente, et est initialisé
		//avec le constructeur de la super classe, avec
		//statType comme élément par défaut, car c’est le type
		//renvoyé par un programme.
		
		super(statType);
		visitedBlocks=new Stack<>();
		this.table=t;
	}

	public void check(){
		//S’il y a des erreurs, sortir du programme principal. Sinon, ne
		//rien faire.	
	}


	public Type visit(ExpId e){
		//retourner le type de l’identifiant correspondant, et
		//une erreur si non trouvé : la variable n’a pas été
		//déclarée auparavant (ou il y a un autre problème)

		Type t = table.variableLookup(e.getValue(), visitedBlocks);

		if(t == null)
			throw new IllegalStateException("La variable n'a pas été trouvé...");
		return t;
	}

	public Type visit(ExpInt e){
		//retourner le type int dans tous les cas
		return new TypePrim(e.getPosition(), TypePrim.Prim.INT);
	}
	public Type visit(ExpCons e){
		Type t = null;

		switch (e.getConstant()){
			case TRUE :
				t = new TypePrim(e.getPosition(), TypePrim.Prim.BOOL);
			case FALSE :
				t = new TypePrim(e.getPosition(), TypePrim.Prim.BOOL);
			default:
				break;
		}

		return t;
	}

	public Type visit (StatAff sa){

		//affectation : récupérer le type de l’identifiant, le
		//type de l’expression, et s’assurer que les deux sont
		//identiques. Sinon, lever une erreur précise
		//(impossible d’affecter l’exp de type… à la var. de
		//type … ).
		//
		//retourner un type Instruction s’il n’y a pas
		//d’erreur

		Type tVar = sa.getId().accept(this);
		if(tVar == null)
			return errType;
		Type tExp = sa.getExpression().accept(this);
		if(tExp == null)
			return errType;
		if(!tVar.equals(tExp))
			throw new IllegalStateException("Impossible d'affecter l'expression de type" +
					tExp + "à la variable de type" + tVar + ".");

		return statType;
	}

	
	public Type visit(MethodDecl md){
		//visiter le bloc du corps de la méthode. (les paramètres
		//auront été intégrés à la table locale dans le
		//tableBuilder, donc on n’aura pas en s’en occuper
		//précisément ici).



		return null;
	}

	public Type visit(ExpBin e){
		// récupérer les deux types retournés par les sous
		// expressions visitées, vérifier qu’ils sont
		// identiques.
		//
		// Puis selon l’opérateur, vérifier que ce sont bien
		// ceux attendus.

		Type tExp1 = e.getLeftExp().accept(this);
		if(tExp1 == null)
			return errType;
		Type tExp2 = e.getRightExp().accept(this);
		if(tExp2 == null)
			return errType;

		BinOp op = e.getOp();

		if(!tExp1.equals(tExp2))
			throw new IllegalStateException("Impossible d'évaluer une expression de type" +
					tExp1 + "et une expression de type" + tExp2 + ".");
		else {

		}

		return null;
	}
	
	public Type visit(ExpUn exp){
		return null;
	}

	public Type visit(ExpCallMethod ec){
		// plus compliqué : vérifier que le nombre de
		// paramètres est bien celui attendu, et qu’ils sont
		// tous du bon type. Commencer par récupérer la
		// signature de la méthode dans la table des symboles.
		// Si elle n’y est pas , c’est que la méthode n’a pas
		// été déclarée, ou qu’il y a un autre problème.

		return null;
	}

	public Type visit(StatReturn sr){
		//visiter l’expression retournée
		//
		//Si vous vérifiez qu’une méthode renvoie toujours
		//quelque chose, faites une mise à jour ici.
		return statType;
	}
	public Type visit(StatIf s){

		//pour le typage : visiter tous les blocs, et vérifier
		//que la condition est de type bool.
		//
		//pour vérifier qu’une méthode renvoie toujours
		//quelque chose : si les deux blocs retournent une
		//valeur, faire une mise à jour.

		return statType;
	}



	public Type visit(Block b){
		//utiliser la méthode de visite de la super classe,
		//mais ne pas oublier de noter dans la pile l’entrée
		//et la sortie du bloc !
		return null;
	}





}
	

