package com.kubudirira.jpamanytomany.Role.service;

import com.kubudirira.jpamanytomany.Role.model.Role;
import com.kubudirira.jpamanytomany.Role.repository.RoleReposiroty;
import com.kubudirira.jpamanytomany.User.model.User;
import com.kubudirira.jpamanytomany.User.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class RoleService implements IRoleService{

    private final RoleReposiroty roleReposiroty;
    private final UserRepository userRepository;

    @Override
    public void save(Role role) {
        roleReposiroty.save(role);
    }

    @Override
    public List<Role> get() {

        return (List<Role>) roleReposiroty.findAll();
    }

    @Override
    public void delete(Integer id) {
            roleReposiroty.deleteById(id);
    }

//    update role
    @Override
    public Role update(int id,Role role) {

        Role foundrole= roleReposiroty.findById(id).get();

        foundrole.setName(role.getName());
        foundrole.setPermission(role.getPermission());

        roleReposiroty.save(foundrole);

        return role;
    }

    @Override
    public Role assignRoleUser(Integer user_id, Integer role_id) {

        List<User> users = null;  //Holder for all users  assigned to this role
        User user = userRepository.findById(user_id).get();  //get user
        Role role = roleReposiroty.findById(role_id).get();  //get roles

        users =  role.getUsers();  //save all the users the role has into this list
        users.add(user);        //add a new user to the list
        role.setUsers(users); //save all users to the role

        roleReposiroty.save(role);    //save the role.

        return role;
    }
}
