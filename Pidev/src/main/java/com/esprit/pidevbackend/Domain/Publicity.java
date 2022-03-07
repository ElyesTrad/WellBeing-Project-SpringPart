package com.esprit.pidevbackend.Domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@ToString
public class Publicity implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long idPublicity;
	String title;
	String description;
	Date starDate;
	Date endDate;
	String picture;

	@ManyToOne
	Offer offers;
}