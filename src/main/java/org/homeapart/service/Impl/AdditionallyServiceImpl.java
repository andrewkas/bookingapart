package org.homeapart.service.Impl;

import org.homeapart.domain.Additionally;
import org.homeapart.domain.Apart;
import org.homeapart.repository.AdditionallyRepository;
import org.homeapart.service.AdditionallyService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdditionallyServiceImpl implements AdditionallyService {
    private final AdditionallyRepository additionallyRepository;

    public AdditionallyServiceImpl(AdditionallyRepository additionallyRepository) {
        this.additionallyRepository = additionallyRepository;
    }

    @Override
    public List<Additionally> findAll() {
        return additionallyRepository.findAll();
    }

    @Override
    public Additionally save(Additionally additionally) {
        return additionallyRepository.save(additionally);
    }

    @Override
    public List<Additionally> findByApart(Apart apart) {
        return additionallyRepository.findByApart(apart);
    }

    @Override
    public Long delete(Additionally additionally) {
        return additionallyRepository.delete(additionally);
    }
}
