package com.team_spak.car_rental.mappers;

import com.team_spak.car_rental.model.dto.CreateCategoryDto;
import com.team_spak.car_rental.model.dto.ResponseCategoryDto;
import com.team_spak.car_rental.model.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category mapToEntity(CreateCategoryDto createCategoryDto) {
        Category category = new Category();
        category.setName(createCategoryDto.getName());
        category.setDescription(createCategoryDto.getDescription());

        return category;
    }
    public ResponseCategoryDto mapToResponse(Category category) {
        ResponseCategoryDto responseCategoryDto = new ResponseCategoryDto();
        responseCategoryDto.setName(category.getName());
        responseCategoryDto.setDescription(category.getDescription());
        responseCategoryDto.setId(category.getId());
        return responseCategoryDto;
    }
}
