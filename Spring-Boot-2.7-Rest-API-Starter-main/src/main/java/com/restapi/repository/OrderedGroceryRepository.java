package com.restapi.repository;

import com.restapi.model.OrderedGrocery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedGroceryRepository extends JpaRepository<OrderedGrocery, Long> {

}
