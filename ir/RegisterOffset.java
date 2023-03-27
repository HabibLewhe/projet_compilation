package ir;

import ir.expr.ExpressionIr;

public interface RegisterOffset
{
    Register getRegister();
    ExpressionIr getOffset();
    Type getType();
}
