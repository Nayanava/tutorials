package com.parking.spring.oracle.pooling.entity;
/**
 * @author nayanava
 */

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.*;

@Entity
@Table(name = "bookings")
public class Booking implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookingId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "phoneNumber")
    private User user;

    private ParkingStatus parkingStatus;

    private long checkInTime = System.currentTimeMillis();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer parkingCharges = 0;

    public Booking() {
    }

    public Long getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getCheckInTime() {
        return checkInTime;
    }

    public ParkingStatus getParkingStatus() {
        return parkingStatus;
    }

    public void setParkingStatus(ParkingStatus parkingStatus) {
        this.parkingStatus = parkingStatus;
    }

    public void setParkingCharges(Integer parkingCharges) {
        this.parkingCharges = parkingCharges;
    }

    public Integer getParkingCharges() {
        return this.parkingCharges;
    }
}
