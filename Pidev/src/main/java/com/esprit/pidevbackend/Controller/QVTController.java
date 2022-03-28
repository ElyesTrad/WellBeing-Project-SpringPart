package com.esprit.pidevbackend.Web;


import com.esprit.pidevbackend.Domain.QVT;
import com.esprit.pidevbackend.Service.IQVTService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("QVT")

public class QVTController {
    @Autowired
     IQVTService iqvtService;

    @PostMapping("/Add")
    public void AddQVT( @RequestBody QVT e) {
        iqvtService.AddQVT(e);
    }
    @GetMapping("/Get")
    public List<QVT> getAllQVT() {
        return iqvtService.getAllQVT();
    }
    @PutMapping("/Put")
    public void UpdateQVT(@RequestBody QVT e) {
        iqvtService.UpdateQVT(e);
    }
    @DeleteMapping("/Delete/{id}")
    public void DeleteQVT(@PathVariable("id") Long id) {
        iqvtService.DeleteQVT(id);
    }
    @GetMapping("/C/{id}")
    public void ConseilsPersonnalisesQuiz(@PathVariable("id") Long idQuizz) {
         iqvtService.ConseilsPersonnalisesQuiz(idQuizz);
    }
}
