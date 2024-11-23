package com.restaurant.controller;

import com.restaurant.domain.FoodType;
import com.restaurant.services.FoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodtype")
public class FoodTypeController {

    @Autowired
    public FoodTypeService foodTypeService;

    @PostMapping("/add")
    public void addFoodType(@RequestBody FoodType foodType) {
        foodTypeService.addFoodType(foodType);
    }

    @GetMapping("/showall")
    public List<FoodType> getAllFoodTypes() {
        return foodTypeService.getAllFoodTypes();
    }

    @GetMapping("/findById/{id}")
    private ResponseEntity<Object> getFoodTypeById(@PathVariable long id) {
        return foodTypeService.getFoodTypeById(id)
                .map( foodType -> ResponseEntity.ok((Object) foodType))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Yemek tipi bulunamadı"));
    }


}
