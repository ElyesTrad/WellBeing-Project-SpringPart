package com.esprit.pidevbackend.Repository;

import com.esprit.pidevbackend.Domain.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
    @Query(value = "SELECT u FROM Commentaire u where u.IsBlocked=True")
    public List<Commentaire> getAllCommentsBlocked();

    @Query(value = "SELECT u FROM Commentaire u where u.IsBlocked=false ")
    public List<Commentaire> getAllCommentsNotBlocked();

    //  @Query(value="SELECT count(id) FROM Commentaire ")
//    public int CountComments;


}
