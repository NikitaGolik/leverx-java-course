package by.golik.tictactoe.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Nikita Golik
 */
public class Test {
    public static void main(String[] args) {

        Stream<String> numbers = Stream.of("one", "two", "three", "four");
        Stream<String> empty = Stream.empty();
        Stream<Double> randoms = Stream.generate(Math::random).limit(10);

        List<String> words = Arrays.asList("Hello" + " World" + " !");
        Stream<String> longWords = words.stream().filter(w -> w.length() > 3);
        Stream<String> lowerCase = words.stream().map(String::toLowerCase);
        Stream<Stream<Character>> streamOfStream = words.stream().map(Test::chars);


    }
    public static Stream<Character> chars(String str) {
        List<Character> result = new ArrayList<>();
        for(int i = 0; i < str.length(); i++) {
            result.add(str.charAt(i));
        }
        return result.stream();
    }
}
