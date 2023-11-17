package com.restapi.controller.admin;

import com.restapi.dto.GroceryDto;
import com.restapi.model.Grocery;
import com.restapi.model.Role;
import com.restapi.request.GroceryRequest;
import com.restapi.response.common.APIResponse;
import com.restapi.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/admin/grocery")
//@PreAuthorize("hasRole('ROLE_ADMIN')")
@RolesAllowed(Role.ADMIN)
public class AdminGroceryController {

    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private GroceryService groceryService;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllGroceries() {
        List<Grocery> groceryList = groceryService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(groceryList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<APIResponse> createGrocery(@RequestBody
                                                      GroceryRequest groceryRequest) {
        List<Grocery> groceryList = groceryService.createGrocery(groceryRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(groceryList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<APIResponse> updateGrocery(@RequestBody
                                                  GroceryRequest groceryRequest) {
        List<Grocery> groceryList = groceryService.updateGrocery(groceryRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(groceryList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteGrocery(@PathVariable Integer id) {
        List<Grocery> groceryList = groceryService.deleteById(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(groceryList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
