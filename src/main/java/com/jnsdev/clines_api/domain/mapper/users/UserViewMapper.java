package com.jnsdev.clines_api.domain.mapper.users;

import com.jnsdev.clines_api.domain.UserView;
import com.jnsdev.clines_api.domain.mapper.Mapper;
import com.jnsdev.clines_api.repository.Entity.User;
import org.springframework.stereotype.Component;

/**
 * @Autor Jairo Nascimento
 * @Created 29/09/2024 - 14:58
 */
@Component
public class UserViewMapper implements Mapper<User, UserView> {
    @Override
    public UserView map(User source) {
        return new UserView(source.getName(), source.getEmail());
    }
}
