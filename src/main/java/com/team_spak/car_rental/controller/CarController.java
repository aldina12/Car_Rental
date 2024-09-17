package com.team_spak.car_rental.controller;

import com.team_spak.car_rental.model.dto.CreateCarDTO;
import com.team_spak.car_rental.model.dto.ResponseCarDto;
import com.team_spak.car_rental.service.interfaces.CarServiceInterface;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping ("/car")
public class CarController {

    private final CarServiceInterface carServiceInterface;

    @Operation(
            summary = "Find all Car REST API",
            description = "Find all Car REST API is used to find all cars into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 201 CREATED"
    )
    @SecurityRequirement(name = "basicAuth")
    @GetMapping("/findAll/{categoryId}")
    public ResponseEntity<List<ResponseCarDto>> findByCategoryId(@PathVariable("categoryId") long categoryId) {
        return new ResponseEntity<>(carServiceInterface.findByCategoryId(categoryId), HttpStatus.OK);
    }

    @Operation(
            summary = "Create Car REST API",
            description = "Create Car REST API is used to save car into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )
    @SecurityRequirement(name = "basicAuth")
    @PostMapping("/save/{categoryId}")
    @SecurityRequirement(name = "basicAuth")
    public ResponseEntity<ResponseCarDto> save(@Valid @RequestBody CreateCarDTO createCarDto, @PathVariable ("categoryId") long categoryId){
        return new ResponseEntity<>(carServiceInterface.saveNewCar(createCarDto, categoryId), HttpStatus.CREATED);
    }


    @Operation(
            summary = "Find Car by Id REST API",
            description = "Find Car by Id REST API is used to find a car by Id into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 201 CREATED"
    )
    @SecurityRequirement(name = "basicAuth")
    @GetMapping("/findById/{id}")
    public ResponseEntity<ResponseCarDto> findCarById(@PathVariable("id") long id){

        return ResponseEntity.ok(carServiceInterface.findCarById(id));
    }

    @Operation(
            summary = "Update Car REST API",
            description = "Update Car REST API is used to update a car into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 201 CREATED"
    )
    @SecurityRequirement(name = "basicAuth")
    @PreAuthorize("hasRole('MANAGER')")
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseCarDto> updateExistingCar(@RequestBody CreateCarDTO createCarDto,@PathVariable("id") long id){
        return ResponseEntity.ok(carServiceInterface.updateExistingCar(id, createCarDto));
    }

    @Operation(
            summary = "Delete Car by Id REST API",
            description = "Delete Car by Id REST API is used to delete car from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 201 CREATED"
    )
    @SecurityRequirement(name = "basicAuth")
    @PreAuthorize("hasRole('MANAGER')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCarById(@PathVariable("id") long id){

        return ResponseEntity.ok(carServiceInterface.deleteCarById(id));
    }

    @Operation(
            summary = "Find Car by Brand And Model REST API",
            description = "Find Car by Brand And Model REST API is used to find cars by brand and model into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 201 CREATED"
    )
    @SecurityRequirement(name = "basicAuth")
    @GetMapping("/findByBrandAndModel/{brand}/{model}")
    public ResponseEntity<List<ResponseCarDto>> findByBrandAndModel(@PathVariable("brand") String brand,@PathVariable("model") String model){
        return new ResponseEntity<>(carServiceInterface.findByBrandAndModel(brand,model), HttpStatus.OK);
    }


}

