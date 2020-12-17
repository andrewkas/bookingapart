package org.homeapart.service;

import org.homeapart.domain.Additionally;
import org.homeapart.domain.Address;

import java.util.List;

public interface AdditionallyService {
    List<Additionally> findAll();

    Additionally save(Additionally additionally);

    List<Additionally> findByApartId(Long id);

    Long delete(Additionally additionally);
}
