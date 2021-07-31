package com.ivr.cafeback.entity;

import com.ivr.cafeback.services.Utilities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    private String name;
    private String image;
    private String shortDesc;
    private String description;
    private String linkName;
    private Boolean deleted;
    private Integer price;

    @ManyToOne
    private Group group;

    protected Product() {
    }

    public Product(String name, String image, String shortDesc, String description, Integer price, Group group) {
        this.name = name;
        this.image = image;
        this.shortDesc = shortDesc;
        this.description = description;
        this.linkName = Utilities.convert(name);
        this.deleted = false;
        this.price = price;
        this.group = group;
        super.setCreatedDate(LocalDateTime.now());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.linkName = Utilities.convert(name);
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
