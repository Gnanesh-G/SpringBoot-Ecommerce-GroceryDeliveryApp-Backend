package com.restapi.repository;

import com.restapi.model.Cart;
import com.restapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("select c from Cart c inner join c.appUser a where a.id=?1")
    Optional<List<Cart>> findUserCart(Long userId);

}
