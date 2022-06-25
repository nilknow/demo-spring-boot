package tech.poorguy.simplemaven;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo {
    public void sayHi() {
        try {
            sayHiImpl(0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }

    public void sayHiImpl(int num) {
        int a = 4 / num;
    }

    public static void main(String[] args){
        IntStream.range(0,10).forEach(System.out::println);
        List<String> strings = Arrays.asList("1", "2");
        Stream<String> stream = strings.stream();
        Stream<Object> objectStream = stream.map(x ->x);
//        strings.parallelStream().dropWhile();
    }
}
