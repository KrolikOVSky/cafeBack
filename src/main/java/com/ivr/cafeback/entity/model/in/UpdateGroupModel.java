package com.ivr.cafeback.entity.model.in;

public class UpdateGroupModel {
    private String name;
    private String image;
    private String linkName;
    private boolean deleted;

    public UpdateGroupModel(String name, String image, String linkName, boolean deleted) {
        this.name = name;
        this.image = image;
        this.linkName = linkName;
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

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
