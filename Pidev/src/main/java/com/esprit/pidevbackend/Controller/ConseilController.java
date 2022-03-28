package com.esprit.pidevbackend.Web;


import com.esprit.pidevbackend.Domain.ConseilsUser;
import com.esprit.pidevbackend.Service.IConseilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ConseilUser")

public class ConseilController {
    @Autowired
    IConseilsService iConseilsService ;

    @GetMapping("Get/{idQ}/{idU}")
    public ConseilsUser ConseilsPersonnalisesQuiz(@PathVariable("idQ") Long idQvt , @PathVariable("idU") Long idUser){

        return iConseilsService.ConseilsPersonnalisesQuiz(idQvt, idUser);
    }
    @PostMapping("AddConseilToUser/{id}")
    public void AddConseilToUser(@PathVariable("id") Long idU){
        iConseilsService.AddConseilToUser(idU);
    }

}
