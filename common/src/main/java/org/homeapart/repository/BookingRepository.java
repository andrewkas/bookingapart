package org.homeapart.repository;

import org.homeapart.domain.Booking;
import org.homeapart.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking,Long> {

         List<Booking> findByUserId(Long userId);

        Long deleteBookingById(Long Id);
}
