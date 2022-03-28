package com.esprit.pidevbackend.Web;


import com.esprit.pidevbackend.Domain.Opinion;
import com.esprit.pidevbackend.Service.IOpinionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Opinion")

public class OpinionController {
@Autowired
     IOpinionService iOpinionService;


    @PostMapping("/Add")
    public void AddOpinion(@RequestBody Opinion e) {
        iOpinionService.AddOpinion(e);
    }
    @PutMapping("/Put")
    public void UpdateOpinion(@RequestBody Opinion e) {
        iOpinionService.UpdateOpinion(e);
    }
    @GetMapping("/Get")
    public List<Opinion> getAllOpinions() {
        return iOpinionService.getAllOpinions();
    }
    @DeleteMapping("/Delete/{id}")
    public void DeleteOpinion(@PathVariable("id") Long id) {
        iOpinionService.DeleteOpinion(id);
    }
    @PostMapping("/AddOpinionToUser/{id}")
    public void AddOpinionToUser(@RequestBody Opinion e, @PathVariable("id") Long idUser) {
        iOpinionService.AddOpinionToUser(e, idUser);
    }

}
