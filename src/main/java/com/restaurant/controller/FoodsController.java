package com.restaurant.controller;
import com.restaurant.domain.FoodType;
import com.restaurant.domain.Foods;
import com.restaurant.services.FoodTypeService;
import com.restaurant.services.FoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/foods")
public class FoodsController {
    @Autowired
    private FoodsService foodsService;
    @Autowired
    private FoodTypeService foodTypeService;


    @PostMapping("/saveFoods")
    public ResponseEntity<?> saveFoods(@RequestBody Foods food) {
        if (food.getFoodType() == null || food.getFoodType().getId() == null) {
            return new ResponseEntity<>("FoodType ID is required!", HttpStatus.BAD_REQUEST);
        }

        Optional<FoodType> foodType = foodTypeService.getFoodTypeById(food.getFoodType().getId());
        if (foodType.isEmpty()) {
            return new ResponseEntity<>("FoodType not found with id: " + food.getFoodType().getId(), HttpStatus.NOT_FOUND);
        }
        food.setFoodType(foodType.get());
        Foods addFood = foodsService.saveFood(food);
        return new ResponseEntity<>(addFood, HttpStatus.CREATED);
    }

    @GetMapping("/showall")
    public List<Foods> showall() {
        return foodsService.getAllFoods();
    }

    @GetMapping("/showAllWithout")
    public List<Foods> showAllWithout() {
        return  foodsService.showAllWithoutFoodType();
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Object> getFoodById(@PathVariable Long id) {
        return foodsService.getFoodById(id)
                .map( foods -> ResponseEntity.ok((Object)foods))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Yemek bulunamadı"));

    }
}
