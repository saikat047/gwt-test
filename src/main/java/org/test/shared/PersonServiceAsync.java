package org.test.shared;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;

public interface PersonServiceAsync {
    void getPersons(AsyncCallback<List<Person>> personsAsync);
}
