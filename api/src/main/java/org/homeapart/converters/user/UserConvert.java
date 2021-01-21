package org.homeapart.converters.user;

import lombok.AllArgsConstructor;
import org.homeapart.controller.request.UserCreateRequest;
import org.homeapart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;


public abstract class UserConvert<S, T> implements Converter<S,T> {


        protected User doConvert(User user, UserCreateRequest request) {

            user.setName(request.getName());
            user.setSurname(request.getSurname());
            user.setBirthDate(request.getBirthDate());
            user.setGender(request.getGender());
            user.setLogin(request.getLogin());
            user.setChanged(new Timestamp(System.currentTimeMillis()));
            user.setEmail(request.getEmail());

            return user;
        }
    }
