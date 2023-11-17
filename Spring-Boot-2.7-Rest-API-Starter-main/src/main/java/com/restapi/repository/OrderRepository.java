package com.restapi.repository;

import com.restapi.model.Cart;
import com.restapi.model.Category;
import com.restapi.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Order o inner join o.appUser a where a.id=?1")
    Optional<List<Order>> findUserOrder(Long userId);

}
