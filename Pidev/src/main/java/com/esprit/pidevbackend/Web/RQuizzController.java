package com.esprit.pidevbackend.Web;


import com.esprit.pidevbackend.Domain.RQuizz;
import com.esprit.pidevbackend.Service.IRQuizzService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("RQuizz")
@RequiredArgsConstructor
public class RQuizzController {
    private IRQuizzService irQuizzSevice;

    @PostMapping("/Post")
    public void AddRQuizz (@RequestBody RQuizz e){
    irQuizzSevice.AddRQuizz(e);
    }
    @GetMapping("/Get")
    @ResponseBody
    public List<RQuizz> getAllRQuizz(){
        return irQuizzSevice.getAllRQuizz();
    }
    @DeleteMapping("Delete/{id}")
    public void DeleteRQuizz (@PathVariable("id") Long id){
        irQuizzSevice.DeleteRQuizz(id);
    }
    @PutMapping("Put")
    public void UpdateRQuizz (@RequestBody RQuizz e){
        irQuizzSevice.UpdateRQuizz(e);
    }
}
