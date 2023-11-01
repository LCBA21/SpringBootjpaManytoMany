package com.kubudirira.jpamanytomany.User.repository;


import com.kubudirira.jpamanytomany.User.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {


}
