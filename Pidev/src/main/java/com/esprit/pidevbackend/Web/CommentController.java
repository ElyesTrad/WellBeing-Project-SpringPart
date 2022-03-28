package com.esprit.pidevbackend.Web;

import com.esprit.pidevbackend.Domain.Commentaire;
import com.esprit.pidevbackend.Service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")

public class CommentController {
    @Autowired
    CommentaireService commentaireService;

    @PostMapping("addComment")
    public void addComment(@RequestBody Commentaire comment) {
        commentaireService.addComment(comment);
    }

    @DeleteMapping("deleteComment/{id}")
    public void deleteComment(@PathVariable("id") Long idComment) {
        commentaireService.deleteComment(idComment);
    }

    @GetMapping("ListComment")
    public List<Commentaire> listComment() {
        return commentaireService.listComment();
    }

    @PostMapping("addCommentAndAffect/{idEvent}/{idUser}")
    public void addCommentToEventAndAffectToUser(@RequestBody Commentaire commentaire, @PathVariable("idEvent") Long idEvent, @PathVariable("idUser") Long idUser) {
        commentaireService.addCommentToEventAndAffectToUser(commentaire, idEvent, idUser);
        commentaireService.BlockCommentsWithInsultingWords(commentaire);
    }



    @GetMapping("retrieveAllBlockedComments")
    public List<Commentaire> getAllCommentsBlocked(){
        return commentaireService.getAllCommentsBlocked();
    }

    @GetMapping("retrieveAllComments")
    public List<Commentaire> getAllCommentsNotBlocked(){
        return commentaireService.getAllCommentsNotBlocked();
    }



}
