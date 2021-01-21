package org.homeapart.converters.landlord;

import org.homeapart.controller.request.LandlordCreateRequest;
import org.homeapart.domain.Landlord;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;

public abstract class LandlordConvert <S, T> implements Converter<S,T> {

    protected Landlord doConvert(Landlord landlord, LandlordCreateRequest request) {

        landlord.setName(request.getName());
        landlord.setSurname(request.getSurname());
        landlord.setLogin(request.getLogin());
        landlord.setChanged(new Timestamp(System.currentTimeMillis()));
        landlord.setEmail(request.getEmail());
        landlord.setPhone(request.getPhone());

        return landlord;
    }

}
