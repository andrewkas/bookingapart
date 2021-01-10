package org.homeapart.controller;

import io.swagger.annotations.Api;

import lombok.RequiredArgsConstructor;
import org.homeapart.controller.request.BookingChangeRequest;
import org.homeapart.controller.request.BookingRequest;
import org.homeapart.controller.response.BookingResponce;
import org.homeapart.domain.Booking;
import org.homeapart.service.ApartService;
import org.homeapart.service.BookingService;
import org.homeapart.service.UserService;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import java.util.List;


@RestController
@RequestMapping("/booking")
@Api( tags = "BOOKING")
@RequiredArgsConstructor
public class BookingController {


    private final BookingService bookingService;

    private final UserService userService;

    private final ApartService apartService;

    private final ConversionService conversionService;

    @GetMapping("/all")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<Object> findAll() {
        List<Booking> all = bookingService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

   //TODO: search by busy dates for these apartments

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BookingResponce> createReservation (@RequestBody BookingRequest bookingRequest){
        Booking booking= conversionService.convert(bookingRequest,Booking.class);
        bookingService.save(booking);
        return new ResponseEntity<>(new BookingResponce(
                apartService.findById(booking.getApart().getId()).get()
                ,userService.findById(booking.getUser().getId()).get()
                ,booking.getPrice()
                ,booking.getDateFrom()
                ,booking.getDateTo())
                ,HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BookingResponce> updateReservation(@RequestParam BookingChangeRequest bookingChangeRequest){
        Booking booking=conversionService.convert(bookingChangeRequest,Booking.class);
        bookingService.update(booking);
        return new ResponseEntity<>(new BookingResponce(
                apartService.findById(booking.getApart().getId()).get()
                ,userService.findById(booking.getUser().getId()).get()
                ,booking.getPrice()
                ,booking.getDateFrom()
                ,booking.getDateTo())
                ,HttpStatus.OK);

    }


   @DeleteMapping("/delete/{id}")
   @ResponseStatus(HttpStatus.OK)
   public Long deleteBooking(@PathVariable Long id) {
       Booking booking = bookingService.findById(id).orElseThrow(()->new EntityNotFoundException("Booking with id "+id+" not found"));
       return bookingService.delete(booking);
   }




}
