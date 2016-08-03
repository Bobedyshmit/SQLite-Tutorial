package com.github.bobedyshmit.sqlitetutorial;

public class Person {
    private final int    personId;
    private final String firstName;
    private final String lastName;
    private final int    age;

    public Person(final int personId, final String firstName, final String lastName, final int age) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getPersonId() {
        return personId;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
