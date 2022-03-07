package com.esprit.pidevbackend.Service;

import com.WellBeingProject.GetCloser.Entity.Account;
import com.WellBeingProject.GetCloser.Entity.CommentPub;
import com.WellBeingProject.GetCloser.Repository.AccountRepo;
import com.WellBeingProject.GetCloser.Repository.CommentPubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentPubServiceImpl implements ICommentPubService {
    @Autowired
    CommentPubRepository commentPubRepository;
    @Autowired
    AccountRepo accountRepo;
    @Override
    public void AddCommentPub(CommentPub e) {
        commentPubRepository.save(e);
    }

    @Override
    public List<CommentPub> getAllCommentPub() {
        return  commentPubRepository.findAll();
    }

    @Override
    public void DeleteCommentPub(int id) {
         commentPubRepository.deleteById(id);
    }

    @Override
    public void UpdateCommentPub(CommentPub e) {
        commentPubRepository.save(e);
    }

    @Override
    public void AddCommentPubToUser(CommentPub e, int idUser) {
        Account a=accountRepo.findById(idUser).orElse(null);
        commentPubRepository.save(e);
        e.setAccount(a);
    }
}
