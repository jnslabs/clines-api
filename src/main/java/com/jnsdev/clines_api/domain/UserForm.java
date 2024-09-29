package com.jnsdev.clines_api.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

/**
 * @Autor Jairo Nascimento
 * @Created 29/09/2024 - 12:15
 */
@Builder
public record UserForm(
        @NotBlank String name,
        @NotBlank @Email String email,
        @NotBlank String password
) {
}
