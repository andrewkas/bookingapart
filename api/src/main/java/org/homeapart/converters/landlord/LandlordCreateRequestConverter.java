package org.homeapart.converters.landlord;

import org.homeapart.controller.request.LandlordCreateRequest;
import org.homeapart.domain.Landlord;
import org.homeapart.domain.Role;
import org.homeapart.domain.enums.SystemRole;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class LandlordCreateRequestConverter extends LandlordConvert<LandlordCreateRequest, Landlord> {
    @Override
    public Landlord convert(LandlordCreateRequest landlordCreateRequest) {
        Landlord landlord=new Landlord();
        landlord.setCreated(new Timestamp(System.currentTimeMillis()));
        landlord.setLandlordRole(new Role(2l, SystemRole.ROLE_MODERATOR));

        return doConvert(landlord,landlordCreateRequest);
    }
}
