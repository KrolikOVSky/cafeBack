package com.ivr.cafeback.services;

import com.ivr.cafeback.entity.Product;
import com.ivr.cafeback.entity.model.in.CreateProductModel;
import com.ivr.cafeback.entity.model.in.UpdateProductModel;
import com.ivr.cafeback.entity.model.out.ProductModel;
import com.ivr.cafeback.repositories.GroupRepo;
import com.ivr.cafeback.repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepo productRepo;
    private final GroupRepo groupRepo;

    public ProductService(ProductRepo productRepo, GroupRepo groupRepo) {
        this.productRepo = productRepo;
        this.groupRepo = groupRepo;
    }

    public List<ProductModel> getAllModels() {
        return productRepo.findAllModels();
    }

    public List<ProductModel> getAllDeletedModels() {
        return productRepo.findAllDeletedModels();
    }

    public void createProduct(CreateProductModel createdModel) {
        if (!productRepo.existsProductByNameAndDeleted(createdModel.getName(), false)) {
            Product product = new Product(
                    createdModel.getName(),
                    createdModel.getImage(),
                    createdModel.getShortDesc(),
                    createdModel.getDescription(),
                    createdModel.getPrice(),
                    groupRepo.getGroupByLinkName(createdModel.getGroupName())
            );
            productRepo.save(product);
        } else throw new RuntimeException(String.format("Product \"%s\" already exists", createdModel.getName()));
    }

    public void updateProduct(UpdateProductModel updatedModel) {
        if (productRepo.existsProductByLinkNameAndDeleted(updatedModel.getLinkName(), false)) {
            Product product = productRepo.getProductByLinkName(updatedModel.getLinkName());
            if (updatedModel.isDeleted()) {
                product.setDeleted(true);
                product.setDeletedDate(LocalDateTime.now());
            } else if (updatedModel.getName().equals(product.getName())) {
                product.setImage(updatedModel.getImage());
                product.setDescription(updatedModel.getDescription());
                product.setShortDesc(updatedModel.getShortDesc());
                product.setPrice(updatedModel.getPrice());
                product.setUpdatedDate(LocalDateTime.now());
            } else if (!productRepo.existsProductByNameAndDeleted(updatedModel.getName(), false)) {
                product.setName(updatedModel.getName());
                product.setImage(updatedModel.getImage());
                product.setDescription(updatedModel.getDescription());
                product.setShortDesc(updatedModel.getShortDesc());
                product.setPrice(updatedModel.getPrice());
                product.setUpdatedDate(LocalDateTime.now());
            } else throw new RuntimeException(String.format("Product \"%s\" already exists", updatedModel.getName()));
            productRepo.save(product);
        } else throw new RuntimeException(String.format("Product \"%s\" not found", updatedModel.getName()));
    }
}
