package com.gmail.miv.from_json;

public class Address {

    private String country;
    private String city;
    private String street;

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

}
