package com.baeldung.spring.oracle.pooling.repository;

import com.baeldung.spring.oracle.pooling.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nayanava
 */
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
