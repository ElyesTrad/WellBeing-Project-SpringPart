package com.esprit.pidevbackend.Service;


import com.esprit.pidevbackend.Domain.Answer;

import java.util.List;

public interface IAnswerService {
    public void AddAnswer(Answer e);
    public List<Answer> getAllAnswer();
    public void DeleteAnswer(int id);
    public void UpdateAnswer(Answer e);
    public void AddAnswerToUser(int idUser, int idAnswer);
    public void AddAnswerToQuestion(Answer e, int idQuestion);

}
