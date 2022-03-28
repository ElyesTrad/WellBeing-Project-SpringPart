package com.example.projetspring.Entities;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor

public class Achievements {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long idAchievements ;
    Integer score ;
    Integer trophee ;
    @OneToOne
    private User user ;
    @OneToOne(fetch = FetchType.LAZY)
    private Evaluation evaluation ;
    @OneToMany(cascade ={CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="achievement")
    private Set<Discount> discount ;
    public Achievements(Integer progressionLevel, Integer score, Integer trophee) {
        super();
        this.score = score;
        this.trophee = trophee;
    }


}
