package ir.expr;
import ir.Type;

public class Binary extends ExpressionIr
{
    final private ExpressionIr left;
    final private ExpressionIr right;
    final private ast.BinOp op;

    public ExpressionIr getLeft() {
        return left;
    }

    public ExpressionIr getRight() {
        return right;
    }

    public ast.BinOp getOp() {
        return op;
    }

    public Binary(ExpressionIr left, ExpressionIr right, ast.BinOp op) {
        this.left = left;
        this.right = right;
        this.op = op;
    }

    @Override
    public Type getType() {
        return switch (op) {
            case ADD, MIN, EQ, LT -> Type.INT;
	    case AND -> Type.BYTE;
            default -> Type.BYTE;
        };
    }

    @Override
    public String toString() {
        return "(" + left + " " + op + " " + right + ")";
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
