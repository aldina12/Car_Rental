package com.team_spak.car_rental.service.interfaces;

import com.team_spak.car_rental.model.dto.CreateCategoryDto;
import com.team_spak.car_rental.model.dto.ResponseCategoryDto;

import java.util.List;

public interface CategoryServiceInterface {

    public List<ResponseCategoryDto> findAllCategories();

    public ResponseCategoryDto saveNewCategory(CreateCategoryDto createCategoryDto);

    public ResponseCategoryDto findCategoryById(long id);

    public ResponseCategoryDto updateExistingCategory(long id, CreateCategoryDto createCategoryDto);


    public String deleteCategoryById(long id);

}
