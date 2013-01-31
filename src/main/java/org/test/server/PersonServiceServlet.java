package org.test.server;

import java.util.Arrays;
import java.util.List;

import org.test.shared.Person;
import org.test.shared.PersonService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PersonServiceServlet extends RemoteServiceServlet implements PersonService {

    public List<Person> getPersons() {
        return Arrays.asList(createPerson("Kazi", "Saikat"),
                             createPerson("Kazi", "Shishir"),
                             createPerson("Kazi", "Iqbal"),
                             createPerson("Saleha", "Khatun"));
    }

    private Person createPerson(String firstName, String lastName) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        return person;
    }
}
