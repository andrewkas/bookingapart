package org.homeapart.converters.booking;

import org.homeapart.controller.request.BookingRequest;
import org.homeapart.domain.Booking;
import org.homeapart.service.ApartService;
import org.homeapart.service.UserService;
import org.springframework.stereotype.Component;
import java.sql.Timestamp;

@Component
public class BookingCreateRequestConvert extends BookingConvert<BookingRequest, Booking>{


    public BookingCreateRequestConvert(UserService userService, ApartService apartService) {
        super(userService, apartService);
    }

    @Override
    public Booking convert(BookingRequest bookingRequest) {
        Booking booking=new Booking();
        booking.setCreated(new Timestamp(System.currentTimeMillis()));
        return doConvert(booking,bookingRequest);
    }

}
