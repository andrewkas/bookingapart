package org.homeapart.controller.request;

import lombok.Data;


@Data
public class LandlordCreateRequest{

    private String name;

    private String surname;

    private String phone;

    private String email;

    private String login;

    private String password;


}
