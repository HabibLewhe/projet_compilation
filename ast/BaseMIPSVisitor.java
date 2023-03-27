package ast;

public class BaseMIPSVisitor<T> implements ast.Visitor<T> {


    @Override
    public T visit(ExpBin e) {
        e.getLeftExp().accept(this);
        return e.getRightExp().accept(this);
    }

    @Override
    public T visit(ExpCallMethod e) {
        return null;
    }

    @Override
    public T visit(ExpCons e) {
        return null;
    }

    @Override
    public T visit(ExpId e) {
        return null;
    }

    @Override
    public T visit(ExpInt e) {
        return null;
    }

    @Override
    public T visit(ExpUn e) {
        return null;
    }

    @Override
    public T visit(Formal f) {
        return null;
    }

    @Override
    public T visit(Id e) {
        return null;
    }

    @Override
    public T visit(MethodDecl m) {
        return null;
    }

    @Override
    public T visit(Program p) {
        return null;
    }

    @Override
    public T visit(StatAff a) {
        return null;
    }

    @Override
    public T visit(StatIf s) {
        return null;
    }

    @Override
    public T visit(StatList s) {
        return null;
    }

    @Override
    public T visit(StatPrint s) {
        return null;
    }

    @Override
    public T visit(StatWhile s) {
        return null;
    }

    @Override
    public T visit(StatFor s) {
        return null;
    }

    @Override
    public T visit(TypePrim t) {
        return null;
    }

    @Override
    public T visit(StatVarDecl t) {
        return null;
    }

    @Override
    public T visit(StatReturn t) {
        return null;
    }

    @Override
    public T visit(StatIncr t) {
        return null;
    }

    @Override
    public T visit(StatVarDeclAff s) {
        return null;
    }

    @Override
    public T visit(Block b) {
        return null;
    }
}
