package com.restapi.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressRequest {

    private Long id;
    private Long userId;
    private String address;
    private String city;
    private Integer pinCode;
}
