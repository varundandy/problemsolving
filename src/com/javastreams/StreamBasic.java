package com.javastreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamBasic {
    public static void main(String args[]) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Alex", 23, "USA"));
        list.add(new Employee("Dave", 34, "India"));
        list.add(new Employee("Carl", 21, "USA"));
        list.add(new Employee("Joe", 56, "Russia"));
        list.add(new Employee("Amit", 64, "China"));
        list.add(new Employee("Ryan", 19, "Brazil"));
        List<String> above50 = list.stream().filter(b -> b.age > 50).map(b -> b.name).collect(Collectors.toList());
        System.out.println(Arrays.toString(above50.toArray()));

        List<String> usa = list.stream().filter(b -> b.country=="USA").map(b -> b.name).collect(Collectors.toList());
        System.out.println(Arrays.toString(usa.toArray()));

        List<String> sortCountry = list.stream().sorted((o1, o2) -> o1.country.compareTo(o2.country)).map(o -> o.name).collect(Collectors.toList());
        System.out.println(Arrays.toString(sortCountry.toArray()));

        List<String> sortCountryDescName = list.stream().sorted(new CountryComparator().thenComparing(new NameComparator())).map(o -> o.name).collect(Collectors.toList());
        System.out.println(Arrays.toString(sortCountryDescName.toArray()));
    }

}

class CountryComparator implements Comparator<Employee>
{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.country.compareTo(o2.country);
    }
}

class NameComparator implements Comparator<Employee>
{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o2.name.compareTo(o1.name);
    }
}


class Employee {

    String name;
    int age;
    String country;

    public Employee(String name, int age, String country) {
        super();
        this.name = name;
        this.age = age;
        this.country = country;
    }

}


