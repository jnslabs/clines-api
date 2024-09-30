package com.jnsdev.clines_api.service;

import com.jnsdev.clines_api.domain.UserForm;
import com.jnsdev.clines_api.domain.UserView;
import com.jnsdev.clines_api.domain.mapper.users.UserFormMapper;
import com.jnsdev.clines_api.domain.mapper.users.UserViewMapper;
import com.jnsdev.clines_api.repository.Entity.User;
import com.jnsdev.clines_api.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

/**
 * @Autor Jairo Nascimento
 * @Created 29/09/2024 - 15:48
 */
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserFormMapper formMapper;

    @Mock
    private UserViewMapper viewMapper;

    @Test
    void sholdCreateUserReturnLong() {
        var user = new User(1L, "fulano", "fulano@email.com", "123456");
        var userForm = new UserForm("fulano", "fulano@emai.com", "123456");
        var userView = new UserView(1l,"fulano", "fulano@emai.com");
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(formMapper.map(any(UserForm.class))).thenReturn(user);
        when(viewMapper.map(any(User.class))).thenReturn(userView);

        var userBy = userService.createUserBy(userForm);

        assertEquals(user.getId(), userBy.id());
        then(userRepository).should().save(any(User.class));
    }

    @Test
    void createUserWhithEmailExistentReturnTrowsException() {
        var userForm = new UserForm("fulano", "fulano@emai.com", "123456");
        when(userRepository.existsByEmail(anyString())).thenThrow(IllegalAccessError.class);

        assertThrows(IllegalAccessError.class, () -> userService.createUserBy(userForm));

        then(viewMapper).shouldHaveNoInteractions();
        then(formMapper).shouldHaveNoInteractions();
    }

}