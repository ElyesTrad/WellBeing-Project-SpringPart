package com.esprit.pidevbackend.Domain;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idReservation;
    Date finDate;
    Date endDate;
    int NmPalce;

    /*
    idUser
    idOffer
     */

    @ManyToOne
    Offer offer;


}
