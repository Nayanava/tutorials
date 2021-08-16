package com.parking.spring.oracle.pooling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.spring.oracle.pooling.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{		

}
