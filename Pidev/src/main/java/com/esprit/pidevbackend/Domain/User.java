package com.esprit.pidevbackend.Domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id ;
    String name ;
    String username ;
    String password ;
    String picture ;
    String email ;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    Collection<Role> roles = new ArrayList<>();
    // jma3aa
    @OneToOne(mappedBy="user")
    @JsonIgnore
    Achievements achievements ;
    @OneToMany(mappedBy="users", cascade=CascadeType.ALL)
    @JsonIgnore
    Set<Collaboration> collaborations;
    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Event> events;
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Commentaire> commentaires;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    Set <Opinion> opinion;
    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    Set<Answer>answers;
    @OneToMany(mappedBy ="user" )
    @JsonIgnore
    Set<Publication>publications;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    Set<CommentPub>commentPubs;
    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    Set<LikePub> likePubs;
    @ManyToOne
    @JsonIgnore
    Team team;

}
