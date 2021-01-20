package org.homeapart.service;


import org.homeapart.domain.Landlord;
import org.homeapart.domain.Role;
import java.util.List;
import java.util.Optional;

public interface LandlordService {
    List<Landlord> findAll();

    Landlord save(Landlord landlord);

    Landlord update(Landlord landlord);

    Optional<Landlord> findById(Long landlordId);

   Optional<Landlord> findByLogin(String login);

    Long delete (Long landlordId);

    List<Role> findRole(Long id);
}
