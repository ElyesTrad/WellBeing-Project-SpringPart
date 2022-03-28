package com.esprit.pidevbackend.Web;


import com.esprit.pidevbackend.Domain.Publication;
import com.esprit.pidevbackend.Service.IPublicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Publication")

public class PublicationController {
@Autowired
    IPublicationService iPublicationService;

    @PostMapping("/Add")
    public void AddPublication(@RequestBody Publication e) {
        iPublicationService.AddPublication(e);
    }
    @GetMapping("/Get")
    public List<Publication> getAllPublication() {
        return  iPublicationService.getAllPublication();
    }
    @PutMapping("/Put")
    public void UpdatePublication(@RequestBody Publication e) {
        iPublicationService.UpdatePublication(e);
    }
    @DeleteMapping("Delete/{id}")
    public void DeletePublication(@PathVariable("id") Long id) {
        iPublicationService.DeletePublication(id);
    }
    @PostMapping("AddPubToUser/{idu}")
    public void AddPublicationToUser(@RequestBody Publication e, @PathVariable("idu") Long id){
        iPublicationService.AddPublicationToUser(e,id);
    }


}
