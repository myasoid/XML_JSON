package com.gmail.miv.from_json;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

// Распарсить следующую структуру данных

public class Main {

    public static void main(String[] args) {


        Gson gson = new GsonBuilder().create();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/" + Main.class.getPackage().getName().replace(".", "/") + "/json.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Person person = (Person) gson.fromJson(br, Person.class);

        System.out.println(person);
        //Person{name='Vsevolod', surname='Ievgiienko', phones=[044-256-78-90, 066-123-45-67], sites=[http://site1.com, http://site2.com], address=Address{country='UA', city='Kyiv', street='abcd'}}

    }


}
