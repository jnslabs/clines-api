package com.jnsdev.clines_api.service;

import com.jnsdev.clines_api.domain.UserForm;
import com.jnsdev.clines_api.domain.UserView;
import com.jnsdev.clines_api.domain.mapper.users.UserFormMapper;
import com.jnsdev.clines_api.domain.mapper.users.UserViewMapper;
import com.jnsdev.clines_api.exceptions.ResourceAlreadyExistsException;
import com.jnsdev.clines_api.exceptions.ResourceNotFoundException;
import com.jnsdev.clines_api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @Autor Jairo Nascimento
 * @Created 29/09/2024 - 12:08
 */
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserFormMapper formMapper;
    private final UserViewMapper viewMapper;

    @Transactional(readOnly = false)
    public Long createUserBy(UserForm form) {

        if(repository.existsByEmail(form.email())) {
            throw new ResourceAlreadyExistsException("User alread exist");
        }

        var user = formMapper.map(form);

        repository.save(user);

        return user.getId();
    }

    public UserView showUserBy(Long id) {
        return repository.findById(id)
                .map(viewMapper::map)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot find user"));
    }

    public List<UserView> findAll() {
        return repository.findAll()
                .stream().map(viewMapper::map).collect(toList());
    }
}
