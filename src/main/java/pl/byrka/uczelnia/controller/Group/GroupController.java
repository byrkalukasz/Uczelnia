package pl.byrka.uczelnia.controller.Group;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.byrka.uczelnia.model.DTO.Group.GroupDTO;
import pl.byrka.uczelnia.service.Group.GroupService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/group")
public class GroupController {
    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public ResponseEntity<List<GroupDTO>> getAllgroups(){
        log.info("Entering [getAllgroups]");
        var reponse = groupService.getAllGroup();
        return ResponseEntity.ok(reponse);
    }
    @PostMapping
    public void getAllStudentWithoutGroups(){
        groupService.createGroups("WYK");
    }
}
