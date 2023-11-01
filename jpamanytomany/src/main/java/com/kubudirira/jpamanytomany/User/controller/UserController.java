package com.kubudirira.jpamanytomany.User.controller;


import com.kubudirira.jpamanytomany.Role.model.Role;
import com.kubudirira.jpamanytomany.Role.service.RoleService;
import com.kubudirira.jpamanytomany.User.model.User;
import com.kubudirira.jpamanytomany.User.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity create(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public List<User> getUsers() {
        return userService.get();
    }

    @DeleteMapping("/delete/{projectId}")
    public ResponseEntity removeProject(@PathVariable Integer user_id) {
        userService.delete(user_id);
        return new ResponseEntity(HttpStatus.OK);
    }



    @GetMapping("/assign/{role_id}/{user_id}")
    public User assignUserRoles(
            @PathVariable Integer user_id,
            @PathVariable Integer role_id
    ){
        return userService.assignRoleToUser(role_id,user_id);
    }



    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return    userService.updateUser(id,user);

    }


}
