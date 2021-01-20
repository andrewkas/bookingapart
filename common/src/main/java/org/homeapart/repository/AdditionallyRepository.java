package org.homeapart.repository;

import org.homeapart.domain.Additionally;
import org.homeapart.domain.Apart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AdditionallyRepository extends JpaRepository<Additionally, Long> {

    List<Additionally> findByApart(Apart apart);

    Long deleteAdditionalliesById(Long additionallyId);
}
