package com.ivr.cafeback.entity.model.out;

import com.ivr.cafeback.entity.Group;
import com.ivr.cafeback.entity.model.out.ProductModel;

import java.util.List;

public class GroupModel {
    private String name;
    private String image;
    private Boolean deleted;
    private String linkName;
    private List<ProductModel> products;

    public GroupModel(Group group) {
        this.name = group.getName();
        this.image = group.getImage();
        this.deleted = group.isDeleted();
        this.linkName = group.getLinkName();
    }

    public List<ProductModel> getProducts(){
        return products;
    }
    
    public void setProducts(List<ProductModel> products){
        this.products = products;
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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }
}
