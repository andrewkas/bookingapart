package org.homeapart.converters.user;

import org.homeapart.controller.request.UserCreateRequest;
import org.homeapart.domain.Role;
import org.homeapart.domain.User;
import org.homeapart.domain.enums.SystemRole;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class UserCreateRequestConverter extends UserConvert<UserCreateRequest, User>{
    @Override
    public User convert(UserCreateRequest userCreateRequest) {
        User user =new User();
        user.setCreated(new Timestamp(System.currentTimeMillis()));
        user.setUserRole(new Role(1l, SystemRole.ROLE_USER));

        return doConvert(user,userCreateRequest);
    }
}
