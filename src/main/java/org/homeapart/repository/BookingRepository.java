package org.homeapart.repository;

import org.homeapart.domain.Booking;
import org.homeapart.domain.User;

import java.util.Optional;

public interface BookingRepository extends CrudRepository{

    Optional<Booking> findByUser(User user);
}
