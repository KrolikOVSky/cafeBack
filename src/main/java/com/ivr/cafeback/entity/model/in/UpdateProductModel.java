package com.ivr.cafeback.entity.model.in;

public class UpdateProductModel {
    private String name;
    private String image;
    private String shortDesc;
    private String description;
    private String linkName;
    private String groupName;
    private boolean deleted;
    private Integer price;

    public UpdateProductModel(String name, String image, String shortDesc, String description, String linkName, String groupName, boolean deleted, Integer price) {
        this.name = name;
        this.image = image;
        this.shortDesc = shortDesc;
        this.description = description;
        this.linkName = linkName;
        this.groupName = groupName;
        this.deleted = deleted;
        this.price = price;
    }


    public UpdateProductModel() {
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

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

