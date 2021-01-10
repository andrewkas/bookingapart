package org.homeapart.controller.request;

import lombok.Data;
import org.homeapart.domain.enums.City;
import org.homeapart.domain.enums.Country;

@Data
public class AddressCreateRequest {

    private Country country;

    private City city;

    private String location;

}
