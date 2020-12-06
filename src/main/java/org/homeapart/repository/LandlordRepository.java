package org.homeapart.repository;

import org.homeapart.domain.Landlord;
import org.homeapart.domain.User;

import java.util.List;
import java.util.Optional;

public interface LandlordRepository extends CrudRepository{
    List<Landlord> search(String query);

    Optional<Landlord> findByLogin(String login);
}
