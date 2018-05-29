package com.rosyoki.app.sample;

import java.util.ArrayList;
import java.util.List;

public class SampleApp {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("aa");
        strs.add("bbb");
        strs.add("cccccc");

        strs.stream()
                .filter(e -> e.length() < 5)
                .forEach(System.out::println
                );

        String[] array = strs.toArray(new String[strs.size()]);

        System.out.println(join(array));

    }

    private static String join(String... words) {
        return io.vavr.collection.List.of(words)
                .intersperse(",")
                .foldLeft(new StringBuilder(), StringBuilder::append)
                .toString();
    }
}
