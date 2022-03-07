package com.esprit.pidevbackend.Service;

import com.example.EventManage.entities.Commentaire;

import java.util.List;


public interface CommentaireService {
    public void addComment(Commentaire comment);
    public void deleteComment(Long idComment);
    List<Commentaire> listComment();
    public void addCommentToEventAndAffectToUser(Commentaire commentaire, Long idEvent, Long idUser);
}
