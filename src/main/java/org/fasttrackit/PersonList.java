package org.fasttrackit;

import java.util.ArrayList;
import java.util.List;

public class PersonList {
    private List<Person> personList;

    public PersonList(List<Person> personList) {
        this.personList = personList;
    }

    public List<String> personName() {
        List<String> nameList =new ArrayList<>();
        for(Person person :personList) {
            nameList.add(person.firstName() + " " + person.lastName());

        }
            return nameList;

    }
}
