package com.esprit.pidevbackend.Service;

import com.WellBeingProject.GetCloser.Entity.CommentPub;

import java.util.List;

public interface ICommentPubService {
    public void AddCommentPub(CommentPub e);
    public List<CommentPub> getAllCommentPub();
    public void DeleteCommentPub(int id);
    public void UpdateCommentPub(CommentPub e);
    public void AddCommentPubToUser(CommentPub e, int idUser);

}
