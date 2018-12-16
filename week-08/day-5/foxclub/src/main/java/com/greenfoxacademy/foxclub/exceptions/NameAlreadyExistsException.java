package com.greenfoxacademy.foxclub.exceptions;

import java.text.MessageFormat;

public class NameAlreadyExistsException extends Exception {
    public NameAlreadyExistsException(String name) {
        super(MessageFormat.format("{0} already exists.", name ));
    }
}
