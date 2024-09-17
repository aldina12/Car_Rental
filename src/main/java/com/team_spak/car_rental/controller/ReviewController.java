package com.team_spak.car_rental.controller;

import com.team_spak.car_rental.model.dto.CreateReviewDto;
import com.team_spak.car_rental.model.dto.ResponseReviewDto;
import com.team_spak.car_rental.service.interfaces.ReviewServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewController {
    private ReviewServiceInterface reviewServiceInterface;

    @Operation(
            summary = "Find all Review REST API",
            description = "Find all Review REST API is used to find all reviews into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 201 CREATED"
    )
    @SecurityRequirement(name = "basicAuth")
    @GetMapping("/findAll/{carId}")
    public ResponseEntity<List<ResponseReviewDto>> findAllByReviewIdAndCarId(@PathVariable("carId") long carId) {

        return new ResponseEntity<>(reviewServiceInterface.findAllByReviewIdAndCarId(carId), HttpStatus.OK);
    }

    @Operation(
            summary = "Create Review REST API",
            description = "Create Review REST API is used to save review into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )
    @SecurityRequirement(name = "basicAuth")
    @PostMapping("/save/{carId}")
    public ResponseEntity<ResponseReviewDto> saveByReviewIdAndCarId(@RequestBody CreateReviewDto createReviewDto, @PathVariable("carId") long carId) {
        return new ResponseEntity<>(reviewServiceInterface.saveByReviewIdAndCarId(createReviewDto, carId), HttpStatus.OK);
    }

    @Operation(
            summary = "Find Reviw by Id REST API",
            description = "Find Review by Id REST API is used to find a Review by Id into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 201 CREATED"
    )
    @SecurityRequirement(name = "basicAuth")
    @GetMapping("/findById/{id}/{carId}")
    public ResponseEntity<ResponseReviewDto> findByReviewIdAndCarId(@PathVariable("id") long id, @PathVariable("carId") long carId){

        return ResponseEntity.ok(reviewServiceInterface.findByReviewIdAndCarId(id, carId));
    }

    @Operation(
            summary = "Update review by Id REST API",
            description = "Update review by Id REST API is used to update a review by Id into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 201 CREATED"
    )
    @SecurityRequirement(name = "basicAuth")
    @PostMapping("/update/{id}/{carId}")
    public ResponseEntity<ResponseReviewDto> updateByReviewIdAndCarId(@PathVariable ("id") long id, @RequestBody CreateReviewDto createReviewDto, @PathVariable("carId") long carId) {
        return ResponseEntity.ok(reviewServiceInterface.updateByReviewIdAndCarId(id, createReviewDto, carId));
    }

    @Operation(
            summary = "Delete review by Id REST API",
            description = "Delete review by Id REST API is used to delete a review by Id into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 201 CREATED"
    )
    @SecurityRequirement(name = "basicAuth")
    @DeleteMapping("/delete/{id}/{carId}")
    public ResponseEntity<String> deleteByReviewIdAndCarId(@PathVariable("id") long id, @PathVariable long carId){

        return ResponseEntity.ok(reviewServiceInterface.deleteByReviewIdAndCarId(id, carId));
    }
}
