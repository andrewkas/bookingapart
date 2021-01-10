package org.homeapart.converters.apart;

import org.homeapart.controller.request.ApartCreateRequest;
import org.homeapart.domain.Apart;
import org.homeapart.service.LandlordService;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;

@Component
public class ApartCreateRequestConvert extends ApartConvert<ApartCreateRequest, Apart>{

    private  LandlordService landlordService;

    public ApartCreateRequestConvert(LandlordService landlordService) {
        this.landlordService = landlordService;
    }

    @Override
    public Apart convert(ApartCreateRequest apartCreateRequest) {

        Apart apart = new Apart();
        apart.setLandlord(landlordService.findById(apartCreateRequest.getLandlordId()).orElseThrow(()->new EntityNotFoundException("Landlord with id "+ apartCreateRequest.getLandlordId()+" not found")));
        apart.setCreated(new Timestamp(System.currentTimeMillis()));

        return doConvert(apart,apartCreateRequest);
    }
}
