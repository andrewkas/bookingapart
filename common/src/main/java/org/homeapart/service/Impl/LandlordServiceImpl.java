package org.homeapart.service.Impl;

import lombok.AllArgsConstructor;
import org.homeapart.domain.Landlord;
import org.homeapart.domain.Role;
import org.homeapart.repository.LandlordRepository;
import org.homeapart.service.LandlordService;
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
    public Optional<Landlord> findById(Long landlordId) {
        return landlordRepository.findById(landlordId);
    }

    @Override
    public Optional<Landlord> findByLogin(String login) {
        return landlordRepository.findByLogin(login);

    }

    @Override
    public Long delete(Long landlordId) {
        return landlordRepository.deleteLandlordById(landlordId);
    }

    @Override
    public List<Role> findRole(Long id){return landlordRepository.findRole(id);}
}
