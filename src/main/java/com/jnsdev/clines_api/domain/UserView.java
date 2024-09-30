package com.jnsdev.clines_api.domain;

import lombok.Builder;

/**
 * @Autor Jairo Nascimento
 * @Created 29/09/2024 - 14:56
 */
@Builder
public record UserView(
        Long id,
        String name,
        String email
) {}
