package com.esprit.pidevbackend.Web;


import com.esprit.pidevbackend.Domain.ConseilsUser;
import com.esprit.pidevbackend.Service.IConseilsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ConseilUser")
@RequiredArgsConstructor
public class ConseilController {

    private IConseilsService iConseilsService ;

    @GetMapping("Get/{idQ}/{idU}")
    public ConseilsUser ConseilsPersonnalisesQuiz(@PathVariable("idQ") Long idQvt , @PathVariable("idU") Long idUser){

        return iConseilsService.ConseilsPersonnalisesQuiz(idQvt, idUser);
    }
}
