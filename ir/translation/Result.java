package ir.translation;

import ir.com.Command;
import ir.expr.ExpressionIr;

import java.util.LinkedList;
import java.util.List;

public class Result
{
    private ExpressionIr expressionIr;
    private List<Command> code;

    public ExpressionIr getExp() {
        return expressionIr;
    }

    public List<Command> getCode() {
        return code;
    }

    public Result(ExpressionIr expressionIr, List<Command> code) {
        this.expressionIr = expressionIr;
        this.code = code;
    }

    public Result(ExpressionIr expressionIr) {
        this(expressionIr, new LinkedList<>());
    }

    public Result(List<Command> code) {
        this(null, code);
    }
}
