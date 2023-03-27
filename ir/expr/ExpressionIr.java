package ir.expr;

import ir.Type;

abstract public class ExpressionIr {
    public abstract <T> T accept(Visitor<T> visitor);
    public abstract Type getType();
}
