package org.homeapart.converters.landlord;

import org.homeapart.controller.request.LandlordChangeRequest;
import org.homeapart.domain.Landlord;
import org.homeapart.service.LandlordService;
import org.springframework.stereotype.Component;
import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;

@Component
public class LandlordChangeRequestConvert extends LandlordConvert<LandlordChangeRequest, Landlord>{

    private LandlordService landlordService;

    public LandlordChangeRequestConvert(LandlordService landlordService) {
        this.landlordService = landlordService;
    }

    @Override
    public Landlord convert(LandlordChangeRequest landlordChangeRequest) {
        Landlord landlord= landlordService.findById(landlordChangeRequest.getId()).orElseThrow(()->new EntityNotFoundException("Landlord with id "+ landlordChangeRequest.getId()+" not found" ));
        return doConvert(landlord,landlordChangeRequest);
    }
}
