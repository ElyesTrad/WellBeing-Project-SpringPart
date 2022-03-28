package com.example.projetspring.ServicesInterfaces;

import com.example.projetspring.Entities.User;

import java.util.List;

public interface UserService {
    User AddUser (User u) ;
    User UpdateUser(User u);
    public void ResetKudos ();
    public void DecrementKudos(Long IdUser);

}
