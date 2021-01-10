package org.homeapart.converters.booking;

import org.homeapart.controller.request.BookingChangeRequest;
import org.homeapart.domain.Booking;
import org.homeapart.service.ApartService;
import org.homeapart.service.BookingService;
import org.homeapart.service.UserService;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class BookingChangeRequestConvert extends BookingConvert<BookingChangeRequest, Booking> {

    private BookingService bookingService;


    public BookingChangeRequestConvert(UserService userService, ApartService apartService, BookingService bookingService) {
        super(userService, apartService);
        this.bookingService = bookingService;
    }

    @Override
    public Booking convert(BookingChangeRequest bookingChangeRequest) {
        Booking booking=bookingService.findById(bookingChangeRequest.getId()).orElseThrow(()->new EntityNotFoundException("Booking with id "+ bookingChangeRequest.getId()+" not found"));
        return doConvert(booking,bookingChangeRequest);
    }
}
