package com.rohit.product_inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rohit.product_inventory.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
