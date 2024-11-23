package com.restaurant.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "foods")
public class Foods extends BaseEntity {


    @Column(nullable = false)
    private String name;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal price;

    @ManyToOne (fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "id_food_type", referencedColumnName = "id", nullable = false)
    private FoodType foodType;



 /*
    @JoinColumn(name = "id_food_type", referencedColumnName = "id", nullable = false)
    private Lond idFoodType;
    @Formula("(select ft.name from food_type ft where ft.id = id_food_type)")
    private String foodTypeName;*/

    @Column(nullable = false)
    private Long cookingMinutes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }


    public Long getCookingMinutes() {
        return cookingMinutes;
    }

    public void setCookingMinutes(Long cookingMinutes) {
        this.cookingMinutes = cookingMinutes;
    }
}