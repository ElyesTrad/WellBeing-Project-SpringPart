package com.esprit.pidevbackend.Domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
public class Achievements {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long idAchievements ;
	Integer progressionLevel ;
	Integer Score ;
	Integer trophee ;
	@OneToOne
	private User user ;
	@OneToMany(cascade ={CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="achievements")
	private Set<Evaluation> evaluations ; 
	@OneToMany(cascade ={CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="achievement")
	private Set<Discount> discount ;
}
