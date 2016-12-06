package streams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by srapolu on 9/7/16.
 */
public class TestStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(Arrays.asList("n1","n2","n3","n4","n5","n6"));
        list.forEach(x -> System.out.println(x));
       // int sum = list.stream().filter(l -> list.startsWith("n"));
    }
}
