package com.rohit.product_inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rohit.product_inventory.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
