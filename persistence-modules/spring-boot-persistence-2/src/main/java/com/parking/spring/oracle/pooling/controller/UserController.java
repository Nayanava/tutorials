package com.parking.spring.oracle.pooling.controller;

import com.parking.spring.oracle.pooling.entity.User;
import com.parking.spring.oracle.pooling.repository.UserRepository;
import com.parking.spring.oracle.pooling.exception.ValetParkingServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/users")
    public class UserController {

        @Autowired
        private UserRepository repository;

        @GetMapping(value = "/helloUser")
        public String sayHello() {
            return "Hello User";
        }

        @PostMapping("/create")
        public User newBook(@RequestBody User newUser) {
            return repository.save(newUser);
        }

        @GetMapping("/user/{id}")
        public User findUserById(@PathVariable Long id) throws ValetParkingServiceException {
            return repository.findById(id)
                    .orElseThrow(ValetParkingServiceException::new);
        }

    @GetMapping("/phoneNumber/{phoneNumber}")
    public User findUserByPhoneNumber(@PathVariable String phoneNumber) throws ValetParkingServiceException {
        return repository.findByPhoneNumber(phoneNumber)
                .orElseThrow(ValetParkingServiceException::new);
    }
}
