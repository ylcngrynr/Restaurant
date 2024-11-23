package com.restaurant.dao;

import com.restaurant.domain.Foods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodsRepository extends JpaRepository<Foods, Long> {
    @Query("SELECT f FROM Foods f")
    List<Foods> findAllWithoutFetch();

}
