package com.aegerm.springsglbookstore.rest.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends TypeError {

    private List<FieldMessage> messages = new ArrayList<>();

    public ValidationError(Long timestamp, Integer status, String error) {
        super(timestamp, status, error);
    }

    public List<FieldMessage> getMessages() {
        return messages;
    }

    public void addMessages(String fieldName, String message) {
        this.messages.add(new FieldMessage(fieldName, message));
    }
}
