package org.homeapart.service.Impl;

import lombok.AllArgsConstructor;
import org.homeapart.domain.Booking;
import org.homeapart.repository.BookingRepository;
import org.homeapart.service.BookingService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
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
    public Optional<Booking> findById(Long bookingId) {
        return bookingRepository.findById(bookingId);
    }

    @Override
    public Long delete(Long bookingId) {
        return bookingRepository.deleteBookingById(bookingId);
    }

    @Override
    public List<Booking> findByUserId(Long userId) {return bookingRepository.findByUserId(userId);
    }
}
