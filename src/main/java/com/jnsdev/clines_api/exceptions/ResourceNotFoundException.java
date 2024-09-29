package com.jnsdev.clines_api.exceptions;

import java.io.Serial;

/**
 * @Autor Jairo Nascimento
 * @Created 29/09/2024 - 15:00
 */
public class ResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
