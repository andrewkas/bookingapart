package org.homeapart.repository;

import org.homeapart.domain.Landlord;
import org.homeapart.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface LandlordRepository extends JpaRepository<Landlord,Long> {
  //  List<Landlord> search(String query);

    Optional<Landlord> findByLogin(String login);

    @Query(value="select l.landlordRole from Landlord l where l.id=:id")
    List<Role> findRole(Long id);


    Long deleteLandlordById(Long Id);
}
