package ir.com;

import ir.expr.ExpressionIr;

public class CJump extends Command
{
    final private ExpressionIr condition;
    final private Label trueLabel;
    final private Label falseLabel;

    public ExpressionIr getCondition() {
        return condition;
    }

    public Label getTrueLabel() {
        return trueLabel;
    }

    public Label getFalseLabel() {
        return falseLabel;
    }

    public CJump(ExpressionIr condition, Label trueLabel, Label falseLabel) {
        this.condition = condition;
        this.trueLabel = trueLabel;
        this.falseLabel = falseLabel;
    }

    @Override
    public String toString() {
        return "CJump (" + condition + ", "
                + trueLabel + ", " + falseLabel + ")";
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
