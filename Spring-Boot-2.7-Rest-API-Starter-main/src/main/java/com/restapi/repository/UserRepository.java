package com.restapi.repository;

import com.restapi.model.AppUser;
import com.restapi.model.Category;
import com.restapi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

    @Query("select e from #{#entityName} e where e.username=?1")
    Optional<AppUser> findByUsername(String username);
}
