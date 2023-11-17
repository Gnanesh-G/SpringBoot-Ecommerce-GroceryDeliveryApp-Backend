package com.restapi.request;

import com.restapi.model.AppUser;
import com.restapi.model.Grocery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CartRequest {
    private Long userId;
    private Long groceryId;
    private Integer count;
}
