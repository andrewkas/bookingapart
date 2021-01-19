package org.homeapart.converters.booking;

import org.homeapart.controller.request.BookingRequest;
import org.homeapart.domain.Booking;
import org.homeapart.service.ApartService;
import org.homeapart.service.UserService;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class BookingConvert<S,T> implements Converter<S,T> {

    private UserService userService;

    private ApartService apartService;

    public BookingConvert(UserService userService, ApartService apartService) {
        this.userService = userService;
        this.apartService = apartService;
    }

    protected Booking doConvert(Booking booking, BookingRequest bookingRequest) {

        booking.setUser(userService.findById(bookingRequest.getUserId()).get());
        booking.setApart(apartService.findById(bookingRequest.getApartId()).get());
        booking.setDateFrom(bookingRequest.getDateFrom());
        booking.setDateTo(bookingRequest.getDateTo());
        booking.setChanged(new Timestamp(System.currentTimeMillis()));
        booking.setPrice(getTime(bookingRequest.getDateFrom(),bookingRequest.getDateTo())
                *apartService.findById(bookingRequest.getApartId()).get().getCostPerDay());

        return booking;
    }
    private long getTime(Date dateFrom, Date dateTo)  {
        long time=(dateTo.getTime()-dateFrom.getTime());
        return TimeUnit.DAYS.convert(time, TimeUnit.MILLISECONDS);

    }
}
