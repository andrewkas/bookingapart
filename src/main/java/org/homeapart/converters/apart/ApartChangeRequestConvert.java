package org.homeapart.converters.apart;

import org.homeapart.controller.request.ApartChangeRequest;
import org.homeapart.domain.Apart;
import org.homeapart.domain.Landlord;
import org.homeapart.service.ApartService;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;

@Component
public class ApartChangeRequestConvert extends ApartConvert<ApartChangeRequest, Apart>{

    private ApartService apartService;

    public ApartChangeRequestConvert(ApartService apartService) {
        this.apartService = apartService;
    }

    @Override
    public Apart convert(ApartChangeRequest apartChangeRequest) {

        Apart apart= apartService.findById(apartChangeRequest.getId()).orElseThrow(()->new EntityNotFoundException("Apart with id "+ apartChangeRequest.getId()+" not found" ));
        return doConvert(apart,apartChangeRequest);
    }
}
