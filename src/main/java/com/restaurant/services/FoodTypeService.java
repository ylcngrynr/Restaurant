package com.restaurant.services;

import com.restaurant.dao.FoodTypeRepository;
import com.restaurant.domain.FoodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodTypeService {

    @Autowired
    private FoodTypeRepository foodTypeRepository;

    public FoodType addFoodType(FoodType foodType) {
        return foodTypeRepository.save(foodType);
    }

    public List<FoodType> getAllFoodTypes() {
        return foodTypeRepository.findAll();
    }
    public Optional<FoodType> getFoodTypeById(long id) {
        return foodTypeRepository.findById(id);
    }

}
