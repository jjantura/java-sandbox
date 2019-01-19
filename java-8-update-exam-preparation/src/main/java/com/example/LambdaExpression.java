package com.example;

import static java.lang.System.out;

/*
 * Exam topics:
 * Describe and develop code that uses Java inner classes, including nested class, static class, local class, and anonymous classes
 * Describe and write functional interfaces
 * Describe a lambda expression; refactor the code that uses an anonymous inner class to use a lambda expression; describe type inference and target typing
 */

class Outer {
    private static final String field = "FIELD";

    private static void showField() {
        out.println(field);
    }

    // static nested class
    static class Inner {
        void showReference() {
            out.println(this);
            out.println(field);
            showField();
        }
    }
}

// static inner class features:
// no link to the outer class
// can access only static methods and fields of the outer class


public class LambdaExpression {

    private String field = "FIELD";


    class MemberInner {
        private String innerField = "inner field";

        public void accessOuter() {
            out.println(field);
        }
    }
    // member inner class features:
    // has access to all methods, fields, and the outer's this reference
    // has association to outer class instance
    // must be instantiated with an enclosing instance
    // is tied to outer class object at moment of creation


    void foo() {
        // method-local inner classes
        class MethodLocalInnerClass {
            public void showOuter() {
                out.println(field);
            }
        }

        MethodLocalInnerClass methodLocalInnerClass = new MethodLocalInnerClass();
        methodLocalInnerClass.showOuter();
    }
    // a local inner class has access to the members of its enclosing class
    // a local class has access to local variables. In Java SE <= 7 a local class can ONLY access local variables that are declared final
    // when a local class accesses a local variable or parameter of the enclosing block, it captures that variable or parameter
    // in Java >= 8, a local class can access local variables and parameters of the enclosing block that are final or effectively final
    // a variable or parameter whose value is never changed after it is initialized is effectively final
    public static void main(String... args) {
        // Outer outer = new Outer();
        // Outer.Inner inner =  outer.new Inner(); /* can't be done */
        Outer.Inner inner = new Outer.Inner();
        inner.showReference();

        new LambdaExpression().foo();
    }
}

