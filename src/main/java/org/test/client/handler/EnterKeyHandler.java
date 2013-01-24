package org.test.client.handler;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;

public class EnterKeyHandler implements KeyPressHandler {

    private final HandlerAction action;

    public EnterKeyHandler(final HandlerAction action) {
        this.action = action;
    }

    public void onKeyPress(final KeyPressEvent event) {
        if (event.getCharCode() == KeyCodes.KEY_ENTER) {
            action.actionPerformed();
        }
    }
}
