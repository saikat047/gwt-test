package org.test.client;

import java.util.List;

import org.test.client.handler.EnterKeyHandler;
import org.test.client.handler.HandlerAction;
import org.test.shared.Person;
import org.test.shared.PersonService;
import org.test.shared.PersonServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class PersonSearchPanel {

    private HTMLPanel rootElement;

    @UiField
    TextBox searchBox;
    @UiField
    HTMLPanel resultPanel;

    private Grid searchResult;


    interface PersonSearchPanelUiBinder extends UiBinder<HTMLPanel, PersonSearchPanel> {
    }

    private static PersonSearchPanelUiBinder uiBinder = GWT.create(PersonSearchPanelUiBinder.class);

    private PersonServiceAsync personServiceAsync = GWT.create(PersonService.class);

    public PersonSearchPanel() {
        rootElement = uiBinder.createAndBindUi(this);
        searchBox.setVisibleLength(40);
        searchBox.addKeyPressHandler(new EnterKeyHandler(new HandlerAction() {
            public void actionPerformed() {
                personServiceAsync.getPersons(new AsyncCallback<List<Person>>() {
                    public void onFailure(Throwable caught) {
                        Window.alert("What? An error has occured. Message: " + caught.getMessage());
                        caught.printStackTrace();
                    }

                    public void onSuccess(List<Person> result) {
                        populatePersonResult(result);
                        resultPanel.setVisible(true);
                    }
                });
            }
        }));
        resultPanel.setVisible(false);
        resultPanel.add(new Label("Search Result:"));
        searchResult = new Grid(0, 2);
        resultPanel.add(searchResult);
    }

    private void populatePersonResult(List<Person> persons) {
        searchResult.resizeRows(persons.size());
        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            searchResult.setHTML(i, 0, person.getFirstName());
            searchResult.setHTML(i, 1, person.getLastName());
        }
    }

    public Widget getElement() {
        return rootElement;
    }
}
