package com.ivr.cafeback.repositories;

import com.ivr.cafeback.entity.Group;
import com.ivr.cafeback.entity.model.out.GroupModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface GroupRepo extends JpaRepository<Group, UUID> {
    @Query("select gr from Group gr where gr.deleted = false")
    List<GroupModel> findAllModels();

    @Query("select gr from Group gr where gr.deleted = true")
    List<GroupModel> findAllDeletedModels();

    boolean existsGroupByNameAndDeleted(String Name, boolean deleted);

    boolean existsGroupByLinkNameAndDeleted(String linkName, boolean deleted);

    Group findGroupByLinkNameAndDeleted(String linkName, boolean deleted);

    Group getGroupByLinkName(String linkName);

}
