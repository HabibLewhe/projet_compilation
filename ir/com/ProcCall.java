package ir.com;

import ir.Frame;
import ir.expr.ExpressionIr;

import java.util.List;

public class ProcCall extends Command
{
    final private Frame frame;
    final private List<ExpressionIr> arguments;

    public Frame getFrame() {
        return frame;
    }

    public List<ExpressionIr> getArguments() {
        return arguments;
    }

    public ProcCall(Frame frame, List<ExpressionIr> arguments) {
        this.frame = frame;
        this.arguments = arguments;
    }

    @Override
    public String toString() {
        return "Call " + frame.getEntryPoint() + " " + arguments;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
