package com.javastreams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {
        //Created a list of Person object.
        BiPredicate<Person, Integer> greaterThanPredicate = (x, y) -> x.getAge() > y;
        BiPredicate<Person, Integer> lessThanPredicate = (x, y) -> x.getAge()< y;

        List<Person> list = new ArrayList<>();
        list.add(new Person("Dave", 23));
        list.add(new Person("Joe", 18));
        list.add(new Person("Ryan", 54));
        list.add(new Person("Iyan", 5));
        list.add(new Person("Ray", 63));
        // We are filtering out those persons whose age is more than 18 and less than 60
        list.stream()
                .filter(p -> lessThanPredicate.test(p, 19))
                .forEach(System.out::println);

    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
