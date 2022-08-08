package org.fasttrackit;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Project {
    public static void main(String[] args) {

       List<Person> persons =List.of(
               new Person("Alex","Brinzas",37,"Oradea"),
               new Person("Mihai","Muresan",25,"Oradea"),
               new Person("Ana","Dumitrescu",30,"Cluj"),
               new Person("Mihaela","Ardelean",25,"Cluj"),
               new Person("George","Baciu",40,"Bucuresti")

       );
        System.out.println(persons);


        List<String> firstname =persons.stream()
                .map(Person::firstName)
                .sorted()
                .toList();
        System.out.println(firstname);



        List<String> lastname =persons.stream()
                .map(Person::lastName)
                .sorted()
                .toList();
        System.out.println(lastname);


        List<Integer> age =persons.stream()
                .map(Person::age)
                .sorted()
                .filter(i->i>18)
                .toList();
        System.out.println(age);


        persons.stream()
                .sorted(Comparator.comparing(Person::firstName))
                .map(Person::city)
                .forEach(System.out::println);


        List<String> personsfromOradea =persons.stream()
                .filter(x -> "Oradea".equals(x.city()))
                .map(Person::lastName)
                .sorted()
                .toList();
        System.out.println(personsfromOradea);


        // mam tot jucat cu optiunile de filtre dar nu am reusit sa fac Oradea Or Cluj


        List<String> personsfromOradeaOrCluj =persons.stream()
                .filter(x -> "Oradea".equals(x.city()))
                .filter(person -> person.equals("true"))
                .filter(x -> "Cluj".equals(x.city()))
                .filter(person -> person.equals("false"))
                .map(Person::lastName)
                .sorted()
                .toList();
        System.out.println(personsfromOradeaOrCluj);



         //firstName toUpperCase

        persons.stream()
                .map(Person::firstName)
                .map(String::toUpperCase)
                .forEach(System.out::println);


        //firstName firstletter from last name: Stefan B.

        persons.stream()
                //.filter(x->x.lastName().charAt(0) == '1')
                .map(person ->person.firstName()+ " " +person.lastName().charAt(0)+".")
                .forEach(System.out::println);

        //Nu miam dat seama cum sa il fac
        //- list all persons with 18 < age < 60

        //list all persons having first name starting with A
        List<Person> startswithA = persons.stream()
                .filter(person -> person.firstName().startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(startswithA);

        //sort the persons by first name

        List<String> sortedListOffirstName = persons.stream()
                .map(Person::firstName)
                .sorted()
                .toList();
        System.out.println(sortedListOffirstName);

        //sort the persons by last name

        List<String> sortedListOflastname = persons.stream()
                .map(Person::lastName)
                .sorted()
                .toList();
        System.out.println(sortedListOflastname);

        //list all first names UNIQUELY ->
        // - > nu am inteles ce face mai exact :)

        //sort the persons by first name, last name and then age

        //variata 1 ( nu functioneaza  :)) )

        List<String> sortedfirstlastage = persons.stream()
                .map(person -> person.firstName()+ " " + person.lastName() + " " + person.age())
                .sorted()
                .toList();
        System.out.println(sortedfirstlastage);

        //varianta 2
        List<Integer> sortedListOfage = persons.stream()
                .map(Person::age)
                .sorted()
                .toList();
        System.out.println(sortedListOfage);

        //am facut 3 metode firstName , lastName si age dupa care leam adunat mai jos pt->
        // -> sort the persons by first name, last name and then age

        System.out.println(sortedListOffirstName + " " + sortedListOflastname + "" +sortedListOfage);

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
