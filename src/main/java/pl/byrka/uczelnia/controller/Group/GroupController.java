package pl.byrka.uczelnia.controller.Group;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.byrka.uczelnia.model.DTO.Group.GroupAutoCreateDTO;
import pl.byrka.uczelnia.model.DTO.Group.GroupDTO;
import pl.byrka.uczelnia.model.Emuns.GroupTypeEnum;
import pl.byrka.uczelnia.service.Group.GroupScheduler;
import pl.byrka.uczelnia.service.Group.GroupService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/group")
public class GroupController {
    private final GroupService groupService;
    private final GroupScheduler groupScheduler;

    @Autowired
    public GroupController(GroupService groupService, GroupScheduler groupScheduler) {
        this.groupService = groupService;
        this.groupScheduler = groupScheduler;
    }

    @GetMapping
    public ResponseEntity<List<GroupDTO>> getAllgroups(){
        log.info("Entering [getAllgroups]");
        var reponse = groupService.getAllGroup();
        return ResponseEntity.ok(reponse);
    }

    @PostMapping
    public void createAllGroups(GroupAutoCreateDTO autoCreateDTO){
        groupScheduler.autoCreateGroup(autoCreateDTO);

    }
}
