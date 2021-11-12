package com.ivr.cafeback.repositories;

import com.ivr.cafeback.entity.Product;
import com.ivr.cafeback.entity.model.out.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductRepo extends JpaRepository<Product, UUID> {

    @Query("select prod from Product prod where prod.deleted = false")
    List<ProductModel> findAllModels();

    @Query("select prod from Product prod where prod.deleted = true")
    List<ProductModel> findAllDeletedModels();

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    boolean existsProductByNameAndDeleted(String Name, boolean deleted);

    boolean existsProductByLinkNameAndDeleted(String linkName, boolean deleted);

    Product findProductByLinkNameAndDeleted(String linkName, boolean deleted);

    Product getProductByLinkName(String linkName);

}
