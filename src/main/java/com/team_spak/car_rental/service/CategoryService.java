package com.team_spak.car_rental.service;

import com.team_spak.car_rental.model.dto.CreateCategoryDto;
import com.team_spak.car_rental.model.dto.ResponseCategoryDto;
import com.team_spak.car_rental.mappers.CategoryMapper;
import com.team_spak.car_rental.model.entity.Category;
import com.team_spak.car_rental.repository.CategoryRepository;
import com.team_spak.car_rental.service.interfaces.CategoryServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CategoryService implements CategoryServiceInterface {
    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    @Override
    public List<ResponseCategoryDto> findAllCategories() {

        List<Category> categoryList = categoryRepository.findAll();
        List<ResponseCategoryDto> responseCategoryDtoList = new ArrayList<>();

        for (Category category : categoryList) {

            responseCategoryDtoList.add(categoryMapper.mapToResponse(category));
        }

        return responseCategoryDtoList;
    }

    @Override
    public ResponseCategoryDto saveNewCategory(CreateCategoryDto createCategoryDto) {

        Category newCategory = categoryMapper.mapToEntity(createCategoryDto);
        Category savedCategory = categoryRepository.save(newCategory);

        return categoryMapper.mapToResponse(savedCategory);
    }

    @Override
    public ResponseCategoryDto findCategoryById(long id) {

        Category existingCategory = categoryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Category not found"));

        return categoryMapper.mapToResponse(existingCategory);
    }

    @Override
    public ResponseCategoryDto updateExistingCategory(long id, CreateCategoryDto createCategoryDto) {

        Category existingCategory = categoryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Category not found"));

        existingCategory.setName(createCategoryDto.getName());
        existingCategory.setDescription(createCategoryDto.getDescription());

        Category savedCategory = categoryRepository.save(existingCategory);
        return categoryMapper.mapToResponse(savedCategory);

    }

    @Override
    public String deleteCategoryById(long id) {

        Category existingCategory = categoryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Category not found"));

        categoryRepository.delete(existingCategory);

        return "Category with id" + id + "was succefully deleted";
    }
}
