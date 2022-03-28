package com.example.projetspring.ServicesInterfaces;

import com.example.projetspring.Entities.Achievements;
import com.example.projetspring.Entities.User;

import java.util.List;

public interface AchievementsService {

        public void addAchievementsandEvaluation(Long iduser);
        public Integer CalculateAndVerifyScore(Long IdUser,Integer score);
        List<Achievements> findAllOrderByScoreTotalAsc() ;

}
