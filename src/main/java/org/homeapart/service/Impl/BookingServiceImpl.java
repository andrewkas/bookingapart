package org.homeapart.service.Impl;

import lombok.RequiredArgsConstructor;
import org.homeapart.domain.Booking;
import org.homeapart.domain.User;
import org.homeapart.repository.BookingRepository;
import org.homeapart.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;



    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking update(Booking booking) {
        return bookingRepository.update(booking);
    }

    @Override
    public Booking findById(Long bookingId) {
        return bookingRepository.findById(bookingId);
    }

    @Override
    public Long delete(Booking booking) {
        return bookingRepository.delete(booking);
    }

    @Override
    public List<Booking> findByUserId(Long userId) {return bookingRepository.findByUserId(userId);
    }
}
