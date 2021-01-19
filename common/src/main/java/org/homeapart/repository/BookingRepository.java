package org.homeapart.repository;

import org.homeapart.domain.Booking;
import org.homeapart.domain.User;


import java.util.List;
import java.util.Optional;

public interface BookingRepository extends CrudRepository <Long,Booking> {

         List<Booking> findByUserId(Long userId);
}
