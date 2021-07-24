package com.ivr.cafeback.entity.model.out;

import com.ivr.cafeback.entity.Product;

public class ProductModel {
    private String name;
    private String image;
    private String shortDesc;
    private String description;
    private Boolean deleted;
    private Integer price;
    private String linkName;

    public ProductModel(Product product) {
        this.name = product.getName();
        this.image = product.getImage();
        this.shortDesc = product.getShortDesc();
        this.description = product.getDescription();
        this.deleted = product.getDeleted();
        this.price = product.getPrice();
        this.linkName = product.getLinkName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }
}
