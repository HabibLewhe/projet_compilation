package ir.com;

import ir.Register;
import ir.expr.ExpressionIr;

public class WriteReg extends Command
{
    final private Register reg;
    final private ExpressionIr exp;

    public Register getReg() {
        return reg;
    }

    public ExpressionIr getExp() {
        return exp;
    }

    public WriteReg(Register reg, ExpressionIr exp) {
        this.reg = reg;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return reg + " := " + exp;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
