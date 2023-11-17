package com.restapi.dto;

import com.restapi.model.Address;
import com.restapi.model.Grocery;
import com.restapi.request.AddressRequest;
import com.restapi.request.GroceryRequest;
import com.restapi.response.AddressResponse;
import com.restapi.response.GroceryResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroceryDto {

    public GroceryResponse mapToGroceryResponse(List<Grocery> groceryList) {
        return new GroceryResponse(groceryList);
    }

    public Grocery mapToGrocery(GroceryRequest groceryRequest) {
        Grocery grocery = new Grocery();
        if (groceryRequest.getId() != null) {
            grocery.setId(groceryRequest.getId());
        }
        grocery.setPrice(groceryRequest.getPrice());
        grocery.setDescription(groceryRequest.getDescription());
        grocery.setTitle(groceryRequest.getTitle());
        grocery.setPhoto(groceryRequest.getPhoto());
        return grocery;
    }
}
