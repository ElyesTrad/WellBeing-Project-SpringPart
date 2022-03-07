package com.esprit.pidevbackend.Service;

import com.WellBeingProject.GetCloser.Entity.Account;
import com.WellBeingProject.GetCloser.Entity.Answer;
import com.WellBeingProject.GetCloser.Entity.Question;
import com.WellBeingProject.GetCloser.Repository.AccountRepo;
import com.WellBeingProject.GetCloser.Repository.AnswerRepository;
import com.WellBeingProject.GetCloser.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AnswerServiceImpl implements IAnswerService {
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    AccountRepo accountRepo;
    @Autowired
    QuestionRepository questionRepository;
    @Override
    public void AddAnswer(Answer e) {
    answerRepository.save(e);
    }

    @Override
    public List<Answer> getAllAnswer() {
        return answerRepository.findAll();
    }

    @Override
    public void DeleteAnswer(int id) {
    answerRepository.deleteById(id);
    }

    @Override
    public void UpdateAnswer(Answer e) {
    answerRepository.save(e);
    }

    @Override
    @Transactional
    public void AddAnswerToUser(int idUser, int idAnswer) {
        Account u =accountRepo.findById(idUser).orElse(null);
        Answer a =answerRepository.findById(idAnswer).orElse(null);
        a.getAccounts().add(u);
    }

    @Override
    @Transactional
    public void AddAnswerToQuestion( Answer e,int idQuestion) {
        Question q =questionRepository.findById(idQuestion).orElse(null);
        answerRepository.save(e);
        e.setQuestion(q);
    }
}
