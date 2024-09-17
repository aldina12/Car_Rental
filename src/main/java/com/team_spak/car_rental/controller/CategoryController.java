package com.team_spak.car_rental.controller;


import com.team_spak.car_rental.model.dto.CreateCategoryDto;
import com.team_spak.car_rental.model.dto.ResponseCategoryDto;
import com.team_spak.car_rental.service.interfaces.CategoryServiceInterface;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryServiceInterface categoryServiceInterface;

    @Operation(
            summary = "Find all Car Catrgories REST API",
            description = "Find all Car Categories REST API is used to find all cars categories into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 201 CREATED"
    )
    @SecurityRequirement(name = "basicAuth")
    @GetMapping("/findAll")
    public ResponseEntity<List<ResponseCategoryDto>> findAllCategories() {
        return new ResponseEntity<>(categoryServiceInterface.findAllCategories(), HttpStatus.OK);
    }

    @Operation(
            summary = "Create Car Categories REST API",
            description = "Create Car Categories REST API is used to save car categories into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )
    @PreAuthorize("hasRole('MANAGER')")
    @PostMapping("/save")
    public ResponseEntity<ResponseCategoryDto> saveNewCategory(@RequestBody CreateCategoryDto createCategoryDto) {
        return new ResponseEntity<>(categoryServiceInterface.saveNewCategory(createCategoryDto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Find Car Categories by Id REST API",
            description = "Find Car Categories by Id REST API is used to find a car category by Id into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 201 CREATED"
    )
    @SecurityRequirement(name = "basicAuth")
    @GetMapping("/findById/{id}")
    public ResponseEntity<ResponseCategoryDto> findCategoryById(@PathVariable("id") long id){

        return ResponseEntity.ok(categoryServiceInterface.findCategoryById(id));
    }

    @Operation(
            summary = "Update Car Category REST API",
            description = "Update Car Category REST API is used to update a car category into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 201 CREATED"
    )
    @SecurityRequirement(name = "basicAuth")
    @PreAuthorize("hasRole('MANAGER')")
    @PutMapping("update/{id}")
    public ResponseEntity<ResponseCategoryDto> updateExistingCategory(@RequestBody CreateCategoryDto createCategoryDto, @PathVariable("id") long id){
        return ResponseEntity.ok(categoryServiceInterface.updateExistingCategory(id, createCategoryDto));
    }

    @Operation(
            summary = "Delete Car Category by Id REST API",
            description = "Delete Car Category by Id REST API is used to delete car category from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 201 CREATED"
    )
    @SecurityRequirement(name = "basicAuth")
    @PreAuthorize("hasRole('MANAGER')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable("id") long id){

        return ResponseEntity.ok(categoryServiceInterface.deleteCategoryById(id));
    }

}
