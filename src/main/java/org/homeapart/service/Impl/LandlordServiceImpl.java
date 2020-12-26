package org.homeapart.service.Impl;

import lombok.AllArgsConstructor;
import org.homeapart.domain.Landlord;
import org.homeapart.domain.User;
import org.homeapart.repository.LandlordRepository;
import org.homeapart.service.LandlordService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LandlordServiceImpl implements LandlordService {

     private final LandlordRepository landlordRepository;


    @Override
    public List<Landlord> findAll() {
        return landlordRepository.findAll();
    }

    @Override
    public Landlord save(Landlord landlord) {
        return landlordRepository.save(landlord);
    }

    @Override
    public Landlord update(Landlord landlord) {
        return landlordRepository.update(landlord);
    }

    @Override
    public Landlord findById(Long landlordId) {
        Optional<Landlord> optional= landlordRepository.findById(landlordId);
        return optional.orElseGet(optional::orElseThrow);
    }

    @Override
    public Landlord findByLogin(String login) {
        Optional<Landlord>optional= landlordRepository.findByLogin(login);

        return optional.orElseGet(optional::orElseThrow);
    }

    @Override
    public Long delete(Landlord landlord) {
        return landlordRepository.delete(landlord);
    }
}
