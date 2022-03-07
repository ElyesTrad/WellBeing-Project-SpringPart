
package com.esprit.pidevbackend.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Keydoo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
Long idkeydoo ;
Integer Numberkeydoo ;
@OneToOne(mappedBy="keydoo")
private Evaluation evaluation ;

}
