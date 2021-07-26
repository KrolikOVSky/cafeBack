package com.ivr.cafeback.entity.model.in;

public class CreateProductModel {
    private String name;
    private String image;
    private String shortDesc;
    private String description;
    private Integer price;

    public CreateProductModel(String name, String image, String shortDesc, String description, Integer price) {
        this.name = name;
        this.image = image;
        this.shortDesc = shortDesc;
        this.description = description;
        this.price = price;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
