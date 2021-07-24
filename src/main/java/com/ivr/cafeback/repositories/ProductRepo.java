package com.ivr.cafeback.repositories;

import com.ivr.cafeback.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepo extends JpaRepository<Product, UUID> {
}
