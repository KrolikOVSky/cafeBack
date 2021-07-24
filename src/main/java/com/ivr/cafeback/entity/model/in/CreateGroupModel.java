package com.ivr.cafeback.entity.model.in;

public class CreateGroupModel {
    private String name;
    private String image;
    private Boolean deleted;


    public CreateGroupModel(String name, String image, Boolean deleted) {
        this.name = name;
        this.image = image;
        this.deleted = deleted;
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
}
