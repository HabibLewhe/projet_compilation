package support;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTools {

    public static <T> List<T> singleton(T t) {
        return new ArrayList<T>(Arrays.asList(t));
    }

    public static <T> List<T> mergeList(List<T> l1, List<T> l2) {
        List<T> merged = new ArrayList<>();
        merged.addAll(l1);
        merged.addAll(l2);
        return merged;
    }
}
