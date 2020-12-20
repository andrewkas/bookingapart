package org.homeapart.service;

import org.homeapart.domain.Booking;
import org.homeapart.domain.User;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    List<Booking> findAll();

    Booking save(Booking booking);

    Booking update(Booking booking);

    Booking findById(Long bookingId);

    Long delete (Booking booking);

    List<Booking> findByUserId(Long userId);
}
