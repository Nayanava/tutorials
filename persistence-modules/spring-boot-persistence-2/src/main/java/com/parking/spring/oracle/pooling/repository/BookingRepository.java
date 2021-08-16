package com.parking.spring.oracle.pooling.repository;

import com.parking.spring.oracle.pooling.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nayanava
 */
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
