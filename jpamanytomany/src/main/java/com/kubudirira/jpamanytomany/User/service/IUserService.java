package com.kubudirira.jpamanytomany.User.service;


import com.kubudirira.jpamanytomany.Role.model.Role;
import com.kubudirira.jpamanytomany.User.model.User;

import java.util.List;

public interface IUserService {

    public void save(User user);
    public List<User> get();
    public void delete(Integer id);

    public User updateUser(int id,User user);


//    public Role createUserRole(int id,Role role);




    public User assignRoleToUser (Integer user_id, Integer role_id);

}
