package com.example.projetspring.Services;

import com.example.projetspring.Entities.Achievements;
import com.example.projetspring.Entities.Badge;
import com.example.projetspring.Entities.Evaluation;
import com.example.projetspring.Entities.User;
import com.example.projetspring.ServicesInterfaces.AchievementsService;
import com.example.projetspring.repositories.IAchievementsRepository;
import com.example.projetspring.repositories.IEvaluationRepository;
import com.example.projetspring.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AchievementsImpl implements AchievementsService {
    @Autowired
    IAchievementsRepository AchievementRepo;
    @Autowired
    IUserRepository UserRepo;
    @Autowired
    IEvaluationRepository EvaluationRepo;

    @Override
    public void addAchievementsandEvaluation(Long iduser) {
        Evaluation e = new Evaluation(0, 0, 0, 0, Badge.None, Badge.None, Badge.None, new Date(System.currentTimeMillis()));
        Achievements a = new Achievements();
        EvaluationRepo.save(e);
        a.setEvaluation(e);
        User user = UserRepo.findById(iduser).orElse(null);
        a.setUser(user);
        a.setScore(0);
        a.setTrophee(0);
        AchievementRepo.save(a);

    }

    @Override
    public Integer CalculateAndVerifyScore(Long IdUser, Integer score) {
        Integer A;
        Integer B;
        Integer C;
        Integer D;
        Integer E;
        User user = UserRepo.findById(IdUser).orElse(null);
        A = user.getAchievements().getEvaluation().getActivitypoints();
        B = user.getAchievements().getEvaluation().getGamespoints();
        C = user.getAchievements().getEvaluation().getQuizpoints();
        D = user.getAchievements().getEvaluation().getGiftpoints();
        score = ((A * 2) + (B * 2) + (C * 3) + (D * 1)) / 4;
        if (score >= 500) {
            user.getAchievements().setTrophee(user.getAchievements().getTrophee() + 1);
            E = score - 500;
            E = E / 2;
            user.getAchievements().setScore(0);
            user.getAchievements().getEvaluation().setActivitypoints(E);
            user.getAchievements().getEvaluation().setQuizpoints(0);
            user.getAchievements().getEvaluation().setGamespoints(0);
            user.getAchievements().getEvaluation().setGiftpoints(0);
        } else {
            user.getAchievements().setScore(score);
        }
        UserRepo.save(user);
        return score;
    }
        @Override
        public List<Achievements> findAllOrderByScoreTotalAsc () {
            return AchievementRepo.findAllOrderByScoreTotalAsc();
        }
    }
