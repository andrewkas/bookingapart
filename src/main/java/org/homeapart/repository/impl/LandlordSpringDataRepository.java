package org.homeapart.repository.impl;

import org.homeapart.domain.Landlord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LandlordSpringDataRepository extends JpaRepository<Landlord,Long> {
    List<Landlord> findByLogin(String login);


}
