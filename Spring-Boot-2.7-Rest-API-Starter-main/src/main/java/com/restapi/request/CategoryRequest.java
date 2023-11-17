package com.restapi.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryRequest {
    private Long id;
    private String title;

    public CategoryRequest(String title) {
        this.title = title;
    }
}
