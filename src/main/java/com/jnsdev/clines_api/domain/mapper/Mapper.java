package com.jnsdev.clines_api.domain.mapper;

/**
 * @Autor Jairo Nascimento
 * @Created 29/09/2024 - 12:19
 */
public interface Mapper<S, T> {
    T map(S source);
}
