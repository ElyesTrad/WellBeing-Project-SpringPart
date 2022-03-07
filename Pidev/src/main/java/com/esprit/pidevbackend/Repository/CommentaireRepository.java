package com.esprit.pidevbackend.Repository;

import com.example.EventManage.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepository  extends JpaRepository<Commentaire,Long> {
}