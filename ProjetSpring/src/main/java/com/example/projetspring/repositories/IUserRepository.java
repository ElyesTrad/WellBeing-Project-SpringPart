package com.example.projetspring.repositories;

import com.example.projetspring.Entities.Achievements;
import com.example.projetspring.Entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> {

}
