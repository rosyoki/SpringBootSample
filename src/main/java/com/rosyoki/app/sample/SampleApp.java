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
                .filter(e -> e.length() > 5)
                .forEach(
                        (e) -> System.out.println(e)
                );

        System.out.println(">>>>>>>>>");

        strs.stream().forEach(System.out::println);

    }

}
