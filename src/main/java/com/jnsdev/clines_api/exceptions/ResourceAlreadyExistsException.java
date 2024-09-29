package com.jnsdev.clines_api.exceptions;

import java.io.Serial;

/**
 * @Autor Jairo Nascimento
 * @Created 29/09/2024 - 12:13
 */
public class ResourceAlreadyExistsException extends IllegalArgumentException {
    @Serial
    private static final long serialVersionUID = 1L;
    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
}
