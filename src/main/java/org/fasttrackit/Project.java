package org.fasttrackit;

import java.util.ArrayList;
import java.util.List;



public class Project {
    public static void main(String[] args) {
        List<Person> person = new ArrayList<>();
        person.add(new Person("Alex","Brinzas",37,"Oradea"));
        person.add(new Person("Mihai","Muresan", 25,"Oradea"));
        person.add(new Person("Ana","Dumitrescu",30,"Cluj"));
        person.add(new Person("Mihaela","Ardelean",25,"Cluj"));
        person.add(new Person("George","Baciu",40,"Bucuresti"));
        System.out.println(person);
        PersonList personList1 = new PersonList(person);
        System.out.println(personList1.personName());


    }


}

record Person(String firstName, String lastName,int age,String city){
    Person {
    }

    @Override
    public String firstName() {
        return firstName;
    }

    @Override
    public String lastName() {
        return lastName;
    }

    @Override
    public int age() {
        return age;
    }

    @Override
    public String city() {
        return city;
    }


    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
