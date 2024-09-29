package com.jnsdev.clines_api.domain.mapper.users;

import com.jnsdev.clines_api.domain.UserForm;
import com.jnsdev.clines_api.domain.mapper.Mapper;
import com.jnsdev.clines_api.repository.Entity.User;
import org.springframework.stereotype.Component;

/**
 * @Autor Jairo Nascimento
 * @Created 29/09/2024 - 12:21
 */
@Component
public class UserFormMapper implements Mapper<UserForm, User> {

    @Override
    public User map(UserForm source) {
        return new User(source.name(), source.email(), source.password());
    }
}
