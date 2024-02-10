package ru.gb;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            Person p1 = new Person("Michael", "Smith", 34);
            writeJson(p1);
            System.out.println(readJson());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeJson(Person person) throws IOException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        FileWriter fileWriter = new FileWriter("people.json");
        fileWriter.write(gson.toJson(person));
        fileWriter.close();
    }

    public static Person readJson() throws IOException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("people.json"));
        Person person = gson.fromJson(bufferedReader, Person.class);
        return person;
    }
}