package org.homeapart.service;

import org.homeapart.domain.Additionally;
import org.homeapart.domain.Apart;

import java.util.List;
import java.util.Optional;

public interface AdditionallyService {
    List<Additionally> findAll();

    Additionally save(Additionally additionally);

    List<Additionally> findByApart(Apart apart);

    void delete(Long id);

    Optional<Additionally> findById(Long id);

}
