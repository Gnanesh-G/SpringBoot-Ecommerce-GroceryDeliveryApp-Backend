package com.restapi.response;

import com.restapi.model.Address;
import com.restapi.model.Grocery;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
 public class GroceryResponse {

    private List<Grocery> groceryList;
}
