package org.homeapart.service;

import org.homeapart.domain.Booking;
import java.util.List;
import java.util.Optional;

public interface BookingService {
    List<Booking> findAll();

    Booking save(Booking booking);

    Booking update(Booking booking);

    Optional<Booking> findById(Long bookingId);

    Long delete (Long bookingId);

    List<Booking> findByUserId(Long userId);
}
