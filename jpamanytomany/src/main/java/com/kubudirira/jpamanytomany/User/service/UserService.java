package com.kubudirira.jpamanytomany.User.service;

import com.kubudirira.jpamanytomany.Role.model.Role;
import com.kubudirira.jpamanytomany.Role.repository.RoleReposiroty;
import com.kubudirira.jpamanytomany.User.model.User;
import com.kubudirira.jpamanytomany.User.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class UserService  implements IUserService{

    private final UserRepository userRepository;

    private final RoleReposiroty roleReposiroty;


    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> get() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(int id, User user) {
        User getUser=userRepository.findById(id).get();

        getUser.setFirstName(user.getFirstName());
        getUser.setLastName(user.getLastName());
        getUser.setEmail(user.getEmail());


        getUser.setRoles(user.getRoles());

        userRepository.save(getUser);


        return user;

    }


//    @Override
//    public Role createUserRole(int id, Role role) {
//        Role saverole=roleReposiroty.findById(id).get();
//
//        saverole.setName(role.getName());
//        saverole.setPermission(role.getPermission());
//
//        roleReposiroty.save(saverole);
//        return role;
//
//    }



    @Override
    public User assignRoleToUser(Integer user_id, Integer role_id) {


        List<Role> roles = null;  //Holder for all roles assigned to this user
        User user = userRepository.findById(user_id).get();  //get user to assign roles
        log.info("+++++++++++++++++++++User with the Id: {} is :  {}", user_id ,user);
        Role role = roleReposiroty.findById(role_id).get();  //get roles to assign to user
        log.info("********************** Role with the Id: {} is : {} ", role_id,role);
        roles =  user.getRoles();  //save all the roles user has into this list
        roles.add(role);        //add a new role to the list
        user.setRoles(roles); //save all roles to the user

        log.info("********************** New User : {} ", user);

        userRepository.save(user);  //save the user.


        return user;
    }
}
