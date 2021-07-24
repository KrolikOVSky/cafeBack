package com.ivr.cafeback.services;

import com.ivr.cafeback.entity.Group;
import com.ivr.cafeback.entity.model.in.CreateGroupModel;
import com.ivr.cafeback.entity.model.out.GroupModel;
import com.ivr.cafeback.repositories.GroupRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GroupService {
    private final GroupRepo groupRepo;

    public GroupService(GroupRepo groupRepo) {
        this.groupRepo = groupRepo;
    }

    public void createGroup(CreateGroupModel createdModel) {
        Group group = new Group(createdModel.getName(), createdModel.getImage());
        group.setCreatedDate(LocalDate.now());
        groupRepo.save(group);
    }

    public List<GroupModel> getAllGroups() {
        return groupRepo.findAllModels();
    }
}
