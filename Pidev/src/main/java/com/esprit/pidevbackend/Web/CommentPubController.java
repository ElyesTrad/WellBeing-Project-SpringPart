package com.esprit.pidevbackend.Web;

import com.esprit.pidevbackend.Domain.CommentPub;
import com.esprit.pidevbackend.Service.ICommentPubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentPub")
@RequiredArgsConstructor
public class CommentPubController {

    private ICommentPubService iCommentPubService ;
    @PostMapping("/Add")
    public void AddCommentPub(@RequestBody CommentPub e) {
        iCommentPubService.AddCommentPub(e);
       // iCommentPubService.BlockCommentsWithInsultingWords(e);
    }
    @GetMapping("/Get")
    public List<CommentPub> getAllCommentPub() {
        return iCommentPubService.getAllCommentPub();
    }
    @PutMapping("/Put")
    public void UpdateCommentPub(@RequestBody CommentPub e) {
       iCommentPubService.UpdateCommentPub(e);
    }
    @DeleteMapping("/Delete/{id}")
    public void DeleteCommentPub(@PathVariable("id") Long id) {
        iCommentPubService.DeleteCommentPub(id);
    }
    @PostMapping("/addCommentToPubAndUser/{idU}/{idP}")
    public void AddCommentPubToUser(@RequestBody CommentPub e, @PathVariable("idU") Long idUser, @PathVariable("idP") Long idPub){
        iCommentPubService.AddCommentPubToUser(e,idUser,idPub);
        iCommentPubService.BlockCommentsWithInsultingWords(e);
    }

}
