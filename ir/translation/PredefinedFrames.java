package ir.translation;

import ir.Frame;
import ir.Register;
import ir.Type;
import ir.com.Label;
import support.ListTools;
import java.util.LinkedList;


public class PredefinedFrames{

    public static final Frame READ_INT =
            new Frame(Label.named("entryReadInt"),
                    Label.named("exitReadInt"),
                    new LinkedList<>(),
                    new LinkedList<>(),
                    new Register(Type.INT));

    public static final Frame PRINT_INT =
            new Frame(Label.named("entryPrintInt"),
                Label.named("exitPrintInt"),
                ListTools.singleton(new Register(Type.INT)),
                ListTools.singleton(false));

     public static final Frame PRINT_BOOL =
            new Frame(Label.named("entryPrintBool"),
                    Label.named("exitPrintBool"),
                    ListTools.singleton(new Register(Type.BYTE)),
                    ListTools.singleton(false));
}
