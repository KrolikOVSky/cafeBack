package com.ivr.cafeback.services;

import com.ivr.cafeback.entity.Group;
import com.ivr.cafeback.entity.model.in.CreateGroupModel;
import com.ivr.cafeback.entity.model.in.UpdateGroupModel;
import com.ivr.cafeback.entity.model.out.GroupModel;
import com.ivr.cafeback.repositories.GroupRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GroupService {
    private final GroupRepo groupRepo;

    @Value("${upload.path}")
    private String uploadPath;

    public GroupService(GroupRepo groupRepo) {
        this.groupRepo = groupRepo;
    }

    public void createGroup(CreateGroupModel createdModel) {
        if (!groupRepo.existsGroupByNameAndDeleted(createdModel.getName(), false)) {
            Group group = new Group(
                    createdModel.getName(),
                    Utilities.saveImages(createdModel.getImage(), uploadPath)
            );
            groupRepo.save(group);
        } else throw new RuntimeException(String.format("\"%s\" is already exists", createdModel.getName()));
    }

    public void updateGroup(UpdateGroupModel updatedModel) {
        if (groupRepo.existsGroupByLinkNameAndDeleted(updatedModel.getLinkName(), false)) {
            Group group = groupRepo.findGroupByLinkNameAndDeleted(updatedModel.getLinkName(), false);
            if (updatedModel.isDeleted()) {
                group.setDeleted(true);
                group.setDeletedDate(LocalDateTime.now());
            } else if (group.getName().equals(updatedModel.getName())) {
                group.setImage(updatedModel.getImage());
                group.setUpdatedDate(LocalDateTime.now());
            } else if (!groupRepo.existsGroupByNameAndDeleted(updatedModel.getName(), false)) {
                group.setName(updatedModel.getName());
                group.setImage(updatedModel.getImage());
                group.setUpdatedDate(LocalDateTime.now());
            } else throw new RuntimeException(String.format("Name \"%s\" is already exists", updatedModel.getName()));
            groupRepo.save(group);
        } else
            throw new RuntimeException(String.format("Not found: \"%s\"", updatedModel.getLinkName()));
    }

    public List<GroupModel> getAllGroups() {
        return groupRepo.findAllModels();
    }

    public List<GroupModel> getAllDeletedGroups() {
        return groupRepo.findAllDeletedModels();
    }
}
