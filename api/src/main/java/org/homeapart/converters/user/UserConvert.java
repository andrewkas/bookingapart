package org.homeapart.converters.user;

import org.homeapart.controller.request.UserCreateRequest;
import org.homeapart.domain.User;
import org.springframework.core.convert.converter.Converter;
import java.sql.Timestamp;


public abstract class UserConvert<S, T> implements Converter<S,T> {
        protected User doConvert(User user, UserCreateRequest request) {

            user.setName(request.getName());
            user.setSurname(request.getSurname());
            user.setBirthDate(request.getBirthDate());
            user.setGender(request.getGender());
            user.setLogin(request.getLogin());
            user.setPassword(request.getPassword());
            user.setChanged(new Timestamp(System.currentTimeMillis()));
            user.setEmail(request.getEmail());

            return user;
        }
    }
