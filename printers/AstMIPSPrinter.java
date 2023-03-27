package printers;

import ast.*;

import java.util.HashMap;
import java.util.Map;

public class AstMIPSPrinter extends ast.BaseVisitor<String>{

    Map<String, String> varReg;
    int nbReg = 0;

    public AstMIPSPrinter() {
        super(null);
        this.varReg = new HashMap<>();
    }

    public String visit(ExpBin e){

        String str;

        Expression eg=e.getLeftExp();
        str = eg.accept(this) + "move $s0 $v0\n";

        Expression ed=e.getRightExp();
        str += ed.accept(this) + "move $s1 $v0\n";

        BinOp op=e.getOp();
        switch (op){
            case ADD -> str += "add $v0 $s0 $s1\n";
            case MULT -> str += "mul $v0 $s0 $s1\n";
            default -> {}
        }
        return str;
    }

    public String getReg(String s){

        String n = varReg.get(s);
        if(n != null) return n;
        else {
            String reg = varReg.put(s, "$t"+nbReg++);
            return reg;
        }
    }

    @Override
    public String visit(StatAff a) {

        String id = a.getId().getName();
        String reg;
        if(!varReg.containsKey(id)){
            if (varReg.size() != 10) {
                reg = getReg(id);
            }else{
                throw new RuntimeException("Plus de régistres disponibles");
            }
        }else{
            reg = getReg(id);
        }

        String exp = a.getExpression().accept(this);

        return exp + "move" + reg + "$v0";
    }
}
