package com.gmail.miv.from_json;

import java.util.List;

public class Person {

    private String name;
    private String surname;
    private List<String> phones;
    private List<String> sites;
    private Address address;

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phones=" + phones +
                ", sites=" + sites +
                ", address=" + address +
                '}';
    }

}
