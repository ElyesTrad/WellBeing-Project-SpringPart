package com.example.projetspring.Entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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

public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long IdUser  ;
    String UserName ;
    String Password ;
    String Email ;
    Integer kudos ;
    @OneToOne(mappedBy="user",fetch = FetchType.LAZY)
    private Achievements achievements ;
}
