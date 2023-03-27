package ir.com;

import ir.Frame;
import ir.Register;
import ir.expr.ExpressionIr;

import java.util.List;

public class FunCall extends Command
{
    final private Register register;
    final private Frame frame;
    final private List<ExpressionIr> arguments;

    public Frame getFrame() {
        return frame;
    }

    public Register getRegister() {
        return register;
    }

    public List<ExpressionIr> getArguments() {
        return arguments;
    }

    public FunCall(Register register, Frame frame, List<ExpressionIr> arguments) {
        this.register = register;
        this.frame = frame;
        this.arguments = arguments;
    }

    @Override
    public String toString() {
        return register + " := call " + frame.getEntryPoint().toString().replace(":","") + arguments;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
