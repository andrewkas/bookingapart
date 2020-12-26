package org.homeapart.service;

import org.homeapart.domain.Additionally;
import org.homeapart.domain.Address;
import org.homeapart.domain.Apart;

import java.util.List;

public interface AdditionallyService {
    List<Additionally> findAll();

    Additionally save(Additionally additionally);

    List<Additionally> findByApart(Apart apart);

    Long delete(Additionally additionally);

    Additionally findById(Long id);

}
