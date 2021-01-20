package org.homeapart.repository;

import org.homeapart.domain.Landlord;
import org.homeapart.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface LandlordRepository extends JpaRepository<Landlord,Long> {
  //  List<Landlord> search(String query);

    Optional<Landlord> findByLogin(String login);

    List<Role> findRole(Long id);

    Landlord update(Landlord landlord);

    Long deleteLandlordById(Long Id);
}
