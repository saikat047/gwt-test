package org.test.client;

import org.test.client.handler.EnterKeyHandler;
import org.test.client.handler.HandlerAction;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class PersonSearchPanel {

    private HTMLPanel rootElement;

    @UiField
    TextBox searchBox;
    @UiField
    Grid searchResult;


    interface PersonSearchPanelUiBinder extends UiBinder<HTMLPanel, PersonSearchPanel> {

    }
    private static PersonSearchPanelUiBinder uiBinder = GWT.create(PersonSearchPanelUiBinder.class);

    public PersonSearchPanel() {
        rootElement = uiBinder.createAndBindUi(this);
        searchBox.setVisibleLength(40);
        searchBox.addKeyPressHandler(new EnterKeyHandler(new HandlerAction() {
            public void actionPerformed() {
                Window.alert("Hola, pressed Enter!");
            }
        }));

    }

    public Widget getElement() {
        return rootElement;
    }
}
