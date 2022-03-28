package com.esprit.pidevbackend.Domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
public class Publication implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private TypePub typePub;
    private String Statut;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "publication")
    private Set<CommentPub> commentPub;
    @ManyToMany(mappedBy = "publications")
    private Set<LikePub> likePubs;
}
