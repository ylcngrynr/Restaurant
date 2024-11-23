package com.restaurant;

import com.restaurant.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RestaurantApplication {

    public static void main(String[] args) {

        SpringApplication.run(RestaurantApplication.class, args);
        UserController userController = new UserController();
    }


}
