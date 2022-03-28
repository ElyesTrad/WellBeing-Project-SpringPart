package com.esprit.pidevbackend.Web;


import com.esprit.pidevbackend.Domain.Question;
import com.esprit.pidevbackend.Service.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Question")
@RequiredArgsConstructor
public class QuestionController {

    private IQuestionService iQuestionService;

    @PostMapping("/Add")
    public void AddQuestion( @RequestBody Question e) {
        iQuestionService.AddQuestion(e);
    }
    @GetMapping("/Get")
    public List<Question> getAllQuestion() {
        return iQuestionService.getAllQuestion();
    }
    @PutMapping("/Put")
    public void UpdateQuestion(@RequestBody Question e) {
        iQuestionService.UpdateQuestion(e);
    }
    @DeleteMapping("/Delete/{id}")
    public void DeleteQuestion( @PathVariable("id") Long id) {
        iQuestionService.DeleteQuestion(id);
    }
    @PutMapping("/AddQuestionToQuizz/{idQuizz}")
    public void AddQuestionToQuizz(@RequestBody Question e, @PathVariable("idQuizz") Long idQuizz) {
        iQuestionService.AddQuestionToQuizz(e, idQuizz);
    }

}
