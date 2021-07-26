package com.ivr.cafeback.controllers;

import com.ivr.cafeback.entity.model.in.CreateGroupModel;
import com.ivr.cafeback.entity.model.in.UpdateGroupModel;
import com.ivr.cafeback.entity.model.out.GroupModel;
import com.ivr.cafeback.services.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<?> createGroup(@RequestBody CreateGroupModel createdModel) {
        try {
            groupService.createGroup(createdModel);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateGroup(@RequestBody UpdateGroupModel updatedModel) {
        try {
            groupService.updateGroup(updatedModel);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("del")
    public List<GroupModel> getAllDeletedModels() {
        return groupService.getAllDeletedGroups();
    }
}
