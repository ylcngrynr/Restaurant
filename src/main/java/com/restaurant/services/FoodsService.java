package com.restaurant.services;

import com.restaurant.dao.FoodsRepository;
import com.restaurant.domain.Foods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodsService {

    @Autowired
    private FoodsRepository foodRepository;

    public Foods saveFood(Foods food) {
        return foodRepository.save(food);
    }

    public List<Foods> getAllFoods() {
        return foodRepository.findAll();
    }



    public Optional<Foods> getFoodById(Long id) {
        return foodRepository.findById(id);
    }

    public List<Foods> showAllWithoutFoodType()
    {
        return foodRepository.findAllWithoutFetch();
    }

}
