package org.homeapart.service;


import org.homeapart.domain.Landlord;

import java.util.List;
import java.util.Optional;

public interface LandlordService {
    List<Landlord> findAll();

    Landlord save(Landlord landlord);

    Landlord update(Landlord landlord);

    Landlord findById(Long landlordId);

   Landlord findByLogin(String login);

    Long delete (Landlord landlord);
}
