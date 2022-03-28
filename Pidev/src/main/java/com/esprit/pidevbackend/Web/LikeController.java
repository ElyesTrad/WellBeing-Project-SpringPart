package com.esprit.pidevbackend.Web;


import com.esprit.pidevbackend.Domain.EnumLike;
import com.esprit.pidevbackend.Domain.LikePub;

import com.esprit.pidevbackend.Service.ILikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Like")
@RequiredArgsConstructor
public class LikeController {

private ILikeService iLikeService ;
    @PostMapping("/post")
    public void AddLikePub (LikePub e, Long idUser, Long idPub){
        iLikeService.AddLikePub(e, idUser, idPub);
    }

    @GetMapping("/Get")
    public List<LikePub> getAllLikePub(){
        return iLikeService.getAllLikePub();
    }

    @DeleteMapping("/Delete/{id}")
    public void DeleteLikePub (@PathVariable("id") Long id){
        iLikeService.DeleteLikePub(id);
    }

    @PutMapping("/put")
    public void UpdateLikePub (LikePub e){
        iLikeService.UpdateLikePub(e);
    }

    @GetMapping("/getallLikeByPub/{id}")
    public List<EnumLike> getAllLikeByPub (@PathVariable("id") Long idPub){
        return iLikeService.getAllLikeByPub(idPub);
    }

    @GetMapping("/getAllLikeByUser/{id}")
    public List<EnumLike> getAllLikeByUser (@PathVariable("id") Long idUserb){
        return iLikeService.getAllLikeByUser(idUserb);
    }

    @GetMapping("/countAllLikeByPub/{id}")
    public int countAllLikeByPub(@PathVariable("id") Long idPub){
        return iLikeService.countAllLikeByPub(idPub);
    }

    @GetMapping("/allLikeByUser/{id}")
    public List<EnumLike> getAllLikeByPubByUser (@PathVariable("id") Long idUser){
        return iLikeService.getAllLikeByPubByUser(idUser);
    }
}
