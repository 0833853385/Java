package com.example.btcn_thuchanhjava.Validator;



import com.example.btcn_thuchanhjava.entity.Category;
import com.example.btcn_thuchanhjava.Validator.annotation.ValidCategoryId;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {

    @Override
    public boolean isValid(Category category, ConstraintValidatorContext context) {
        return category != null && category.getId() != null;
    }

}

