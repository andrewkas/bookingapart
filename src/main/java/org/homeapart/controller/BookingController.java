package org.homeapart.controller;

import lombok.RequiredArgsConstructor;
import org.homeapart.domain.Apart;
import org.homeapart.domain.Booking;
import org.homeapart.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {


    private final BookingService bookingService;

    @GetMapping("/all")
    public ResponseEntity<Object> findAll() {
        List<Booking> all = bookingService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }




}
