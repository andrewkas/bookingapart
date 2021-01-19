package org.homeapart.converters.apart;

import org.homeapart.controller.request.ApartCreateRequest;
import org.homeapart.controller.request.LandlordCreateRequest;
import org.homeapart.domain.Address;
import org.homeapart.domain.Apart;
import org.homeapart.domain.Landlord;
import org.homeapart.service.LandlordService;
import org.springframework.core.convert.converter.Converter;

import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;

public abstract class ApartConvert <S,T> implements Converter<S,T> {


    protected Apart doConvert(Apart apart, ApartCreateRequest request) {

        apart.setAddress(new Address(request.getAddress().getCountry()
                , request.getAddress().getCity()
                , request.getAddress().getLocation()));
        apart.setApartName(request.getApartName());
        apart.setArea(request.getArea());
        apart.setCostPerDay(request.getCostPerDay());
        apart.setAdditionally(request.getAdditionallySet());
        apart.setChanged(new Timestamp(System.currentTimeMillis()));
        apart.setType(request.getType());
        apart.setGuestNumber(request.getGuestNumber());
        apart.setStatus(request.getStatus());

        return apart;
    }
}
