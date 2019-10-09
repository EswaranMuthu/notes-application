package com.smith.micro.notes.notes.repository;

import com.smith.micro.notes.notes.entity.UserProfile;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserProfile, Long> {


    UserProfile findUserByUserLogon(String userLogon);

}
