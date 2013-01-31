package org.test.shared;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("personService")
public interface PersonService extends RemoteService {

    public List<Person> getPersons();
}
