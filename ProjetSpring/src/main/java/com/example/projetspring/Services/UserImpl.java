package com.example.projetspring.Services;

import com.example.projetspring.Entities.User;
import com.example.projetspring.ServicesInterfaces.UserService;
import com.example.projetspring.repositories.IUserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;

@Service
@EnableScheduling
public class UserImpl implements UserService {
    @Autowired
    IUserRepository UserRepo;


    @Override
    public User AddUser(User u) {
        return UserRepo.save(u);
    }

    @Override
    public User UpdateUser(User u) {
        return UserRepo.save(u);
    }

    @Override
    @Scheduled(cron = "@monthly")
    public void ResetKudos () {
        for (User u : UserRepo.findAll()) {
            u.setKudos(3);
            UserRepo.save(u);
        }

    }

    @Override
    public void DecrementKudos(Long IdUser) {

        User user = UserRepo.findById(IdUser).orElse(null);
        if (user.getKudos() > 0 && user.getKudos()<=3){
            user.setKudos(user.getKudos()-1);
            UserRepo.save(user);
        }
    }


}
