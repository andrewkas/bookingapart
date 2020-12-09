package org.homeapart.controller.request;

import lombok.Data;

@Data
public class LandlordCreateRequest extends UserDeleteRequest{

    private Long Id;

    private String phone;

}
