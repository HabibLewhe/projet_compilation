package ir.com;

import ir.Register;
import ir.RegisterOffset;
import ir.Type;
import ir.expr.ExpressionIr;

public class WriteMem extends Command implements RegisterOffset
{
    final private Register register;
    final private ExpressionIr offset;
    final private ExpressionIr exp;
    final private Type type;

    public Register getRegister() {
        return register;
    }

    public ExpressionIr getOffset() {
        return offset;
    }

    public ExpressionIr getExp() {
        return exp;
    }

    public Type getType() {
        return type;
    }

    public WriteMem(Register register, ExpressionIr offset, ExpressionIr exp, Type type) {
        this.register = register;
        this.offset = offset;
        this.exp = exp;
        this.type = type;
    }

    @Override
    public String toString() {
        return register + "[" + offset + "]" + " : " + type + " := " + exp;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
