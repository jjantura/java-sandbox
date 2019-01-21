package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.*;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static java.util.Optional.ofNullable;

public class BultInLambdaTypes {
    static class User {
        private String name;
        public User(String name) { this.name = name;}
        public String getName() { return name; }
    }


    public static void main(String... args) {
        StringBuffer firstLetters = new StringBuffer();

        // Predicate test method implementation
        Predicate<User> p = (user) -> user.getName().equalsIgnoreCase("John");

        // Consumer accept method implementation (buggy, NPE or AIOB can occur)
        Consumer<User> c = (user) -> firstLetters.append(ofNullable(user.getName().substring(0, 1)).orElse(""));

        // Function apply implementation, (buggy, NPE can occur)
        Function<User, String> f = (user) -> user.getName().toUpperCase(Locale.getDefault());

        // get
        Supplier<String> s = () -> "";

        // applyAsDouble
        ToDoubleFunction<User> tdf = (user) -> user.getName().length();

        // apply(double d)
        DoubleFunction<String> df = (d) ->  new String();

        // test(T t, U u)
        BiPredicate<Integer, String> bp = (i, str) -> i > 0 && str.length() > 0;

        // T apply(T t)
        UnaryOperator<User> uo = u -> new User(u.getName().toLowerCase());

        List<User> users = new ArrayList<>();
        users.add(new User("Adam"));
        users.add(new User("Mark"));
        users.add(new User("Alexa"));
        users.add(new User("John"));

        out.println(users.stream().filter(p).map(User::getName).collect(Collectors.toList()));

        users.stream().forEach(c);

        out.println(firstLetters.toString());

        out.println(users.stream().map(f).collect(Collectors.toList()));

        out.println(users.stream().map(u -> tdf.applyAsDouble(u)).collect(Collectors.toList()));

        out.println(users.stream().map(uo).map(User::getName).collect(Collectors.toList()));

    }
}
