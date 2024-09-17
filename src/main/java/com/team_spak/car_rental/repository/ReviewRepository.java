package com.team_spak.car_rental.repository;
import com.team_spak.car_rental.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {


    List<Review> findByCarId(Long carId);


}
