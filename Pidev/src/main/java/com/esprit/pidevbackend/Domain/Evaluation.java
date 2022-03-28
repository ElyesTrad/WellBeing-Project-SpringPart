package com.esprit.pidevbackend.Domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	Integer activitypoints =0;
	Integer Gamespoints=0 ;
	Integer Quizpoints=0 ;
	Integer giftpoints=0 ;
	@Enumerated(EnumType.STRING)
	Badge activitybadge = Badge.None ;
	@Enumerated(EnumType.STRING)
	Badge gamesbadge = Badge.None ;
	@Enumerated(EnumType.STRING)
	Badge Knowledgebadge = Badge.None ;
	@Temporal(TemporalType.DATE)
	Date startEvaluation = new Date(System.currentTimeMillis());
	@OneToOne
	private Keydoo keydoo ;
	@ManyToOne
	private Achievements achievements ;
	
	

}
