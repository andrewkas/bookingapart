package org.homeapart.controller.request;

import org.homeapart.domain.enums.Gender;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class UserCreateRequest {

    private String name;

    private String surname;

    private String email;

    private Date birthDate;

    private Timestamp created;

    private Timestamp changed;

    private String login;

    private String password;

    private Gender gender=Gender.NOT_SELECTED;
}
