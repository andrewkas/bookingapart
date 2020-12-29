package org.homeapart.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.homeapart.controller.request.BookingRequest;
import org.homeapart.domain.Apart;
import org.homeapart.domain.Booking;
import org.homeapart.service.ApartService;
import org.homeapart.service.BookingService;
import org.homeapart.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {


    private final BookingService bookingService;

    private final UserService userService;

    private final ApartService apartService;

    @GetMapping("/all")
    public ResponseEntity<Object> findAll() {
        List<Booking> all = bookingService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

   //TODO: search by busy dates for these apartments

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Booking> createReservation (@RequestBody BookingRequest bookingRequest){
        Booking booking=new Booking();

        booking.setUser(userService.findById(bookingRequest.getUserId()).get());
        booking.setApart(apartService.findById(bookingRequest.getApartId()));
        booking.setDateFrom(bookingRequest.getDateFrom());
        booking.setDateTo(bookingRequest.getDateTo());
        booking.setCreated(new Timestamp(System.currentTimeMillis()));
        booking.setChanged(new Timestamp(System.currentTimeMillis()));
        booking.setPrice(getTime(bookingRequest.getDateFrom(),bookingRequest.getDateTo())
                *apartService.findById(bookingRequest.getApartId()).getCostPerDay());
        return new ResponseEntity<>(bookingService.save(booking),HttpStatus.CREATED);
    }
   private long getTime(Date dateFrom,Date dateTo)  {
        long time=(dateTo.getTime()-dateFrom.getTime());
        return TimeUnit.DAYS.convert(time, TimeUnit.MILLISECONDS);

   }
   @DeleteMapping("/delete/{id}")
   @ResponseStatus(HttpStatus.OK)
   public Long deleteBooking(@PathVariable Long id) {
       if(bookingService.findById(id)==null) throw new IllegalArgumentException("booking do not exist");
       Booking booking = bookingService.findById(id);
       return bookingService.delete(booking);
   }




}
