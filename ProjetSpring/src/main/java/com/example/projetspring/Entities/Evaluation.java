package com.example.projetspring.Entities;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
public class Evaluation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long idEvaluation ;
    Integer activitypoints ;
    Integer gamespoints ;
    Integer quizpoints ;
    Integer giftpoints ;
    @Enumerated(EnumType.STRING)
    Badge activitybadge ;
    @Enumerated(EnumType.STRING)
    Badge gamesbadge ;
    @Enumerated(EnumType.STRING)
    Badge knowledgebadge  ;
    @Temporal(TemporalType.DATE)
    Date startEvaluation ;
    @OneToOne(mappedBy="evaluation")
    private Achievements achievements ;
    public Evaluation(Integer activitypoints, Integer gamespoints, Integer quizpoints, Integer giftpoints,
                      Badge activitybadge, Badge gamesbadge, Badge knowledgebadge, Date startEvaluation) {
        super();
        this.activitypoints = activitypoints;
        this.gamespoints = gamespoints;
        this.quizpoints = quizpoints;
        this.giftpoints = giftpoints;
        this.activitybadge = activitybadge;
        this.gamesbadge = gamesbadge;
        this.knowledgebadge = knowledgebadge;
        this.startEvaluation = startEvaluation;
    }




}
