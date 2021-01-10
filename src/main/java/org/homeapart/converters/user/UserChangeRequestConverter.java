package org.homeapart.converters.user;

import org.homeapart.controller.request.UserChangeRequest;
import org.homeapart.domain.User;
import org.homeapart.service.UserService;
import org.springframework.stereotype.Component;
import javax.persistence.EntityNotFoundException;

@Component
public class UserChangeRequestConverter extends UserConvert<UserChangeRequest,User>{

    private UserService userService;

    public UserChangeRequestConverter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User convert(UserChangeRequest userChangeRequest) {
        User user= userService.findById(userChangeRequest.getId()).orElseThrow(()->new EntityNotFoundException("User with id "+ userChangeRequest.getId()+" not found" ));
        return doConvert(user,userChangeRequest);
    }
}
