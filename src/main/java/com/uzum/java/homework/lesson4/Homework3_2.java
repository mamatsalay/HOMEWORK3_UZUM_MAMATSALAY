package com.uzum.java.homework.lesson4;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class Homework3_2 {

    public Map<Integer, List<Person>> groupByAge(List<Person> persons, int minimalAgeFilter, boolean removeDupes) {

        return persons.stream()
                .filter(person -> person.getAge() >= minimalAgeFilter) // Filter by age
                .distinct()                        // Remove duplicates (if needed)
                .collect(Collectors.groupingBy(Person::getAge));
    }
}