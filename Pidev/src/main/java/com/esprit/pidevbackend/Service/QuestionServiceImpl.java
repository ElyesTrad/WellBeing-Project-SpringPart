package com.esprit.pidevbackend.Service;

import com.WellBeingProject.GetCloser.Entity.QVT;
import com.WellBeingProject.GetCloser.Entity.Question;
import com.WellBeingProject.GetCloser.Repository.QVTRepsitory;
import com.WellBeingProject.GetCloser.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class QuestionServiceImpl implements IQuestionService {
    @Autowired
    QuestionRepository  questionRepository;
    @Autowired
    QVTRepsitory qvtRepsitory;
    @Override
    public void AddQuestion(Question e) {
    questionRepository.save(e);
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public void DeleteQuestion(int id) {
    questionRepository.deleteById(id);
    }

    @Override
    public void UpdateQuestion(Question e) {
    questionRepository.save(e);
    }

    @Override
    public void AddQuestionToQuizz(Question e, int idQuizz) {
        QVT qvt=qvtRepsitory.findById(idQuizz).orElse(null);
        questionRepository.save(e);
        qvt.getQuestions().add(e);
    }


}
