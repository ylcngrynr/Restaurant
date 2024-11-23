package com.restaurant.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "food_type")
public class FoodType extends BaseEntity {

    @Column (name = "name", length = 50)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
