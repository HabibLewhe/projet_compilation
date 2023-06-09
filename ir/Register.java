package ir;

public class Register
{
    final private int id;
    final private Type type;
    static private int lastRegister;

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "reg" + id;
    }

    public Register(Type type) {
        this.type = type;
        this.id = lastRegister;
        lastRegister += 1;
    }
}
