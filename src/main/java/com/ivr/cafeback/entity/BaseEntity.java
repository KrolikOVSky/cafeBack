package com.ivr.cafeback.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @Type(type = "pg-uuid")
    private UUID id = UUID.randomUUID();
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private LocalDate deletedDate;

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    public LocalDate getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(LocalDate deletedDate) {
        this.deletedDate = deletedDate;
    }
}
