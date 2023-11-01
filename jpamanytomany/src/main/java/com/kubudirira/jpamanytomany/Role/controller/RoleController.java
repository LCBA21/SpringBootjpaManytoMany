package com.kubudirira.jpamanytomany.Role.controller;


import com.kubudirira.jpamanytomany.Role.model.Role;
import com.kubudirira.jpamanytomany.Role.repository.RoleReposiroty;
import com.kubudirira.jpamanytomany.Role.service.RoleService;
import com.kubudirira.jpamanytomany.User.model.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;


    @PostMapping("/save")
    public ResponseEntity<HttpStatus> create(@RequestBody Role role) {
        roleService.save(role);
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public List<Role> getRoles() {
        return roleService.get();
    }

    @DeleteMapping("/delete/{projectId}")
    public ResponseEntity<HttpStatus> removeProject(@PathVariable Integer role_id) {
        roleService.delete(role_id);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    @GetMapping("/assign/{role_id}/{user_id}")
    public Role assignRolesUsers(
            @PathVariable Integer user_id,
            @PathVariable Integer role_id
    ){
        return roleService.assignRoleUser(role_id, user_id); // .assignRoleToUser(role_id,user_id);
    }

    @PutMapping("/updateRole/{id}")
    public Role updateRole(@PathVariable Integer id, @RequestBody Role role) {
        return roleService.update(id, role);
    }



}
