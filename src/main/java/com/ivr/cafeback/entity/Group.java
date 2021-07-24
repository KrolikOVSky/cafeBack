package com.ivr.cafeback.entity;

import com.ivr.cafeback.services.Utilities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group extends BaseEntity {
    private String name;
    private String image;
    private String linkName;
    private Boolean deleted;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "group")
    private List<Product> products;

    protected Group() {
    }

    public Group(String name, String image) {
        this.name = name;
        this.image = image;
        this.deleted = false;
        this.linkName = Utilities.convert(name);
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }
}
