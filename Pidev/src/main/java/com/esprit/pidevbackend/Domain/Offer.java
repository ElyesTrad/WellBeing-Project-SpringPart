package com.esprit.pidevbackend.Domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Offer implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long  idOffer;
	String title;
	String descrption;
	float price;
	String picture;
	Date starDate;
	Date endDate;
	int NPlaces;

	@Enumerated(EnumType.STRING)
	Happy happy;
	
	@ManyToOne
	Collaboration collaboration;

	@OneToMany(mappedBy="offers", cascade=CascadeType.ALL)
	private Set<Publicity>  publicity;

	@OneToMany(mappedBy="offer", cascade=CascadeType.ALL)
	private Set<Reservation>  reservations;






}
