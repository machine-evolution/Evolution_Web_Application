package evolution.java.lambda;

import org.junit.Test;

import java.util.function.Function;

public class Lambda {
    @Test
    public void function() {
        Function<Integer, Integer> function = x -> 2 * x;
        int result = function.apply(15);
        System.out.println(result);
    }
}
