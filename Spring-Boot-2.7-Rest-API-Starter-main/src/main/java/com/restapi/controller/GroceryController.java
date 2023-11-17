package com.restapi.controller;

import com.restapi.model.Grocery;
import com.restapi.model.Role;
import com.restapi.response.common.APIResponse;
import com.restapi.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/grocery")
//@PreAuthorize("hasRole('ROLE_USER')")
@RolesAllowed(Role.USER)
public class GroceryController {

    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private GroceryService groceryService;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllGroceries() {
        List<Grocery> bookList = groceryService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


}
