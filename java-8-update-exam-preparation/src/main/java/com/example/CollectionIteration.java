package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class CollectionIteration {

    private static List<String> names = new ArrayList<>();
    private static Map<Long, String> namesWithIds = new HashMap<>();


    public static void main(String... args) {

        names.add("John");
        names.add("Eva");


        namesWithIds.put(1L, "John");
        namesWithIds.put(2L, "Eva");

        for (String name: names) {
            out.println(name);
        }
        names.forEach(System.out::println);
        names.forEach(name -> System.out.println(name.toUpperCase()));
        namesWithIds.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
