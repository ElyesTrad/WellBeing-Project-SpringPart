package com.esprit.pidevbackend.Service;



import com.WellBeingProject.GetCloser.Entity.Question;

import java.util.List;

public interface IQuestionService {
    public void AddQuestion(Question e);
    public List<Question> getAllQuestion();
    public void DeleteQuestion(int id);
    public void UpdateQuestion(Question e);
    public void AddQuestionToQuizz(Question e, int idQuizz);

}
