package com.saeed.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupPeopleByAge {

    public static Map<Integer, List<String>> groupByAge(List<Person> people) {
        return people.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getAge,
                                Collectors.mapping(Person::getName, Collectors.toList())
                        )
                );
    }

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Ali", 30),
                new Person("Sara", 25),
                new Person("Reza", 30)
        );
        System.out.println(groupByAge(people));
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
