package com.aegerm.springsglbookstore.rest.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldMessage implements Serializable {

    private static final long serialVersionUID = -6145205625643484900L;

    private String fieldName;
    private String message;
}
