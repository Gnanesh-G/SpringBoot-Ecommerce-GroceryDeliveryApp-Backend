package com.restapi.response;

import com.restapi.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
 public class AddressResponse {

    private List<Address> addressList;
}
