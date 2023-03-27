package ir.expr;


import ir.Type;

public class Unary extends ExpressionIr
{

    final private ExpressionIr exp;
    final private ast.UnOp op;

    @Override
    public Type getType() {
        return switch (op) {
            case NOT -> Type.BYTE;
            //ToDo: to check for LPL
            default -> Type.BYTE;
        };
    }

    public ExpressionIr getExp() {
        return exp;
    }

    public ast.UnOp getOp() {
        return op;
    }

    public Unary(ExpressionIr exp, ast.UnOp op) {
        this.exp = exp;
        this.op = op;
    }

    @Override
    public String toString() {
        return op + "(" + exp + ")";
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
