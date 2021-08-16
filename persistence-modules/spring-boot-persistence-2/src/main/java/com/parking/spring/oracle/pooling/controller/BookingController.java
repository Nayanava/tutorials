package com.parking.spring.oracle.pooling.controller;
/**
 * @author nayanava
 */

import com.parking.spring.oracle.pooling.entity.Booking;
import com.parking.spring.oracle.pooling.entity.ParkingStatus;
import com.parking.spring.oracle.pooling.exception.ValetParkingServiceException;
import com.parking.spring.oracle.pooling.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingRepository repository;

    @GetMapping(value = "/helloUser")
    public String sayHello() {
        return "Hello User";
    }

    @GetMapping(value = "/{bookingId}")
    public Booking getBookingById(@PathVariable long bookingId) throws ValetParkingServiceException {
        return repository.findById(bookingId).orElseThrow(ValetParkingServiceException::new);
    }
    @PostMapping("/check-in")
    public Booking createNewBooking(@RequestBody Booking newBooking) {
        newBooking.setParkingStatus(ParkingStatus.CHECKED_IN);
        return repository.save(newBooking);
    }

    @PutMapping("/check-out/{bookingId}")
    public Booking findUserById(@PathVariable Long bookingId) throws ValetParkingServiceException {
        Booking booking = repository.findById(bookingId)
                .orElseThrow(ValetParkingServiceException::new);
        booking.setParkingCharges(totalCostOfParking(booking.getCheckInTime()));
        booking.setParkingStatus(ParkingStatus.CHECKED_OUT);

        return repository.save(booking);
    }

    private int totalCostOfParking(long checkInTime) {
        return totalParkingHours(checkInTime) * 40;
    }
    private int totalParkingHours(long checkInTime) {
        long currentTime = System.currentTimeMillis();
        long hours = (currentTime - checkInTime) / (3600*1000);
        return (currentTime - checkInTime) % 3600*1000 == 0 ? (int)hours : (int)hours + 1;
    }
}
