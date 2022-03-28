package com.esprit.pidevbackend.Web;


import com.esprit.pidevbackend.Domain.Answer;

import com.esprit.pidevbackend.Service.IAnswerService;
import com.esprit.pidevbackend.Service.IPdfService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Answer")
@RequiredArgsConstructor
public class AnswerController {
   private IAnswerService iAnswerService ;
   private IPdfService iPdfService ;

    @PostMapping("/Add")
    public void AddAnswer(@RequestBody Answer e) {
        iAnswerService.AddAnswer(e);
    }
    @PutMapping("/Put")
    public void UpdateAnswer(@RequestBody Answer e) {
        iAnswerService.UpdateAnswer(e);
    }
    @GetMapping("/Get")
    public List<Answer> getAllAnswer() {
        return iAnswerService.getAllAnswer();
    }
    @DeleteMapping("/Delete/{id}")
    public void DeleteAnswer(@PathVariable("id") Long id) {
       iAnswerService.DeleteAnswer(id);
    }
    @PostMapping("/AddAnswerToQuestion/{idQ}")
    public void AddAnswerToQuestion(@RequestBody Answer e, @PathVariable("idQ") Long idQ) {
    iAnswerService.AddAnswerToQuestion(e,idQ);
    }
    @PutMapping("/AddAnswerToUser/{idU}/{idA}")
    public void AddAnswerToUser(@PathVariable("idU") Long idUser, @PathVariable("idA") Long idAnswer) {
        iAnswerService.AddAnswerToUser(idUser, idAnswer);
    }
    @GetMapping("/getPDF/{idu}/{idQvt}")
    public String toPDF(@PathVariable("idu") Long idUser, @PathVariable("idQvt") Long idQvt){

        return iPdfService.toPDF(idUser, idQvt);
    }

}
