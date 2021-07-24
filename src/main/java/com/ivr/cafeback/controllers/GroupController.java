package com.ivr.cafeback.controllers;

import com.ivr.cafeback.entity.model.in.CreateGroupModel;
import com.ivr.cafeback.entity.model.out.GroupModel;
import com.ivr.cafeback.services.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/group")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<GroupModel> getAll() {
        return groupService.getAllGroups();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createGroup(@RequestBody CreateGroupModel createdModel) {
        groupService.createGroup(createdModel);
    }
}
