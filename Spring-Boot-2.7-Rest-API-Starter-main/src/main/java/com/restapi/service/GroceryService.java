package com.restapi.service;

import com.restapi.dto.GroceryDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.Category;
import com.restapi.model.Grocery;
import com.restapi.repository.CategoryRepository;
import com.restapi.repository.GroceryRepository;
import com.restapi.request.GroceryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GroceryService {

    @Autowired
    private GroceryDto groceryDto;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GroceryRepository groceryRepository;

    public List<Grocery> findAll() {
        return groceryRepository.findAll();
    }

    @Transactional
    public List<Grocery> createGrocery(GroceryRequest groceryRequest) {
        Grocery book = groceryDto.mapToGrocery(groceryRequest);
        Category category = categoryRepository.findById(groceryRequest.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("CategoryId",
                        "CategoryId", groceryRequest.getCategoryId()));
        book.setCategory(category);
        groceryRepository.save(book);
        return findAll();
    }

    @Transactional
    public List<Grocery> updateGrocery(GroceryRequest groceryRequest) {
        Grocery grocery = groceryDto.mapToGrocery(groceryRequest);
        Category category = categoryRepository.findById(groceryRequest.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("CategoryId",
                        "CategoryId", groceryRequest.getCategoryId()));
        grocery.setCategory(category);
        groceryRepository.save(grocery);
        return findAll();
    }

    public List<Grocery> deleteById(Integer id) {
        groceryRepository.deleteById(Long.valueOf(id));
        return findAll();
    }
}
