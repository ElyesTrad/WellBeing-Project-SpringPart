package com.example.projetspring.Controller;

import com.example.projetspring.Entities.Achievements;
import com.example.projetspring.ServicesInterfaces.AchievementsService;
import com.example.projetspring.ServicesInterfaces.EvaluationService;
import com.example.projetspring.ServicesInterfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Evaluation")
public class EvaluationController {
    @Autowired
    UserService userservice;
    @Autowired
    AchievementsService achieveservice;
    @Autowired
    EvaluationService evaluationservice;


    //AchievementsController
    @PostMapping("/Add-AchievementsAndEvaluation/{IdUser}")
    @ResponseBody
    public Achievements addAchievementsandEvaluation(@PathVariable("IdUser") Long IdUser) {
        achieveservice.addAchievementsandEvaluation(IdUser);
        return null;
    }

    //Incrementation et decrementation des points
    @PostMapping("/Increment-ActivityPointsLike/{User-id}")
    public void IncrementActivityPointsLike(@PathVariable("User-id") Long IdUser) {
        evaluationservice.IncrementActivityPointsLike(IdUser);
    }

    @PostMapping("/Increment-ActivityPointsComment/{User-id}")
    public void IncrementActivityPointsComment(@PathVariable("User-id") Long IdUser) {
        evaluationservice.IncrementActivityPointsComment(IdUser);
    }

    @PostMapping("/Decrement-ActivityPointsUnlike/{User-id}")
    public void DecrementActivityPointsUnlike(@PathVariable("User-id") Long IdUser) {
        evaluationservice.DecrementActivityPointsUnlike(IdUser);
        ;
    }

    @PostMapping("/Decrement-ActivityPointsUncomment/{User-id}")
    public void DecrementActivityPointsUncomment(@PathVariable("User-id") Long IdUser) {
        evaluationservice.DecrementActivityPointsUncomment(IdUser);
    }

    @PostMapping("/Increment-QuizPoints/{User-id}/{QuizResult}")
    public void IncrementQuizPoints(@PathVariable("User-id") Long IdUser, @PathVariable("QuizResult") Integer QuizResult) {
        evaluationservice.IncrementQuizPoints(IdUser, QuizResult);
    }
    @PostMapping("/Increment-GamesPoints/{User-id}")
    public void IncrementGamesPoints(@PathVariable("User-id") Long IdUser) {
        evaluationservice.IncrementGamesPoints(IdUser);
    }


    //Reset keudos
    @PostMapping("/Resetkeudos")
    public void ResetKudos () {
        userservice.ResetKudos ();
    }

    //Affecter Les Badges
    @PostMapping("/Affect-ActivityBadge/{User-id}")
    public void AffectActivityBadge(@PathVariable("User-id") Long IdUser) {
        evaluationservice.AffectActivityBadge(IdUser);
    }

    //CalculScore
    @PostMapping("Calcul-Score/{User-id}")
    public Integer CalculateAndVerifyScore(@PathVariable("User-id") Long IdUser, Integer score) {
        return achieveservice.CalculateAndVerifyScore(IdUser,score);
    }

    //ClassementParOrdredesscores
    @GetMapping(value = "/Retrieve-Achievements")
    public List<Achievements> findAllOrderByScoreTotalAsc() {
    return achieveservice.findAllOrderByScoreTotalAsc() ;
    }
    //DecrementKeudos
    @PostMapping("/Decrement-Keudos/{User-id}")
    public void DecrementKudos(@PathVariable("User-id") Long IdUser) {
        userservice.DecrementKudos(IdUser);
    }
}