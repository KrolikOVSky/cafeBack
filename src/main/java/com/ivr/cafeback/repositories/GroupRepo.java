package com.ivr.cafeback.repositories;

import com.ivr.cafeback.entity.Group;
import com.ivr.cafeback.entity.model.out.GroupModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface GroupRepo extends JpaRepository<Group, UUID> {
    @Query("select gr from Group gr where gr.deletedDate is null")
    List<GroupModel> findAllModels();

}
