package com.esprit.pidevbackend.Web;

import com.esprit.pidevbackend.API.UploadImage;
import com.esprit.pidevbackend.Domain.Publicity;
import com.esprit.pidevbackend.Repository.ICollaboration;
import com.esprit.pidevbackend.Service.CollaborationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;


@RestController
@RequestMapping("/Publicity")
@AllArgsConstructor
public class publicitycontroller {

    private CollaborationService publicityService;


    private UploadImage uploadImage;

    //http://localhost:8085/addPublicity/1
    @PostMapping("/addPublicity/{idOffer}")
    @ResponseBody
    public void addPublicity(@RequestBody Publicity p, @PathVariable long idOffer){
        publicityService.addPublicity(p,idOffer);
    }

    //http://localhost:8085/Offer/datePublicity/idPublicity/starDate/finDate
    @GetMapping("/datePublicity/{idPublicity}/{starDateOf}/{finDateOf}")
    @ResponseBody
    public boolean dateOffer(@PathVariable long idPublicity, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date starDateOf, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date finDateOf){
        return   publicityService.dateOffer(idPublicity,starDateOf,finDateOf);
    }




    @PostMapping("/uploadImage")
    @ResponseBody
    public ResponseEntity<Object> uploadImage(@RequestParam MultipartFile imageFile, Model model , Publicity publicity) throws IOException {
        return uploadImage.image(imageFile,model,publicity);
    }

}

