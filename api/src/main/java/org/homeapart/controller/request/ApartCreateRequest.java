package org.homeapart.controller.request;

import lombok.Data;
import org.homeapart.domain.Additionally;
import org.homeapart.domain.Address;
import org.homeapart.domain.Landlord;
import org.homeapart.domain.enums.ApartamentStatus;
import org.homeapart.domain.enums.ApartamentType;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Set;

@Data
public class ApartCreateRequest {


    private ApartamentType type;

    private String apartName;

    private Address address;

    private Integer guestNumber;

    private Double area;

    private Double costPerDay;

    private Long landlordId;

    private ApartamentStatus status;

    private Timestamp created;

    private Timestamp changed;

    private Set<Additionally> additionallySet;
}
