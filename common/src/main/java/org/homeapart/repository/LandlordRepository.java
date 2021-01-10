package org.homeapart.repository;

import org.homeapart.domain.Landlord;
import org.homeapart.domain.Role;


import java.util.List;
import java.util.Optional;

public interface LandlordRepository extends CrudRepository<Long,Landlord> {
  //  List<Landlord> search(String query);

    Optional<Landlord> findByLogin(String login);

    List<Role> findRole(Long id);


}
