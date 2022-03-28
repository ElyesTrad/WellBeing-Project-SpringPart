package com.esprit.pidevbackend.Web;


import com.esprit.pidevbackend.API.StripeService;
import com.esprit.pidevbackend.Domain.Payment;
import com.esprit.pidevbackend.Domain.Reservation;
import com.esprit.pidevbackend.Domain.User;
import com.esprit.pidevbackend.Repository.UserRepository;
import com.esprit.pidevbackend.Service.ICollaborationService;
import com.stripe.exception.StripeException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RequestMapping("/Reservation")
@RestController
@AllArgsConstructor
public class ReservationController {


  private ICollaborationService reservationService;


    private StripeService stripeService;


    private   UserRepository userRepository;

    //http://localhost:8085/Reservation/addResevation/1/1
    @PostMapping("/addResevation/{idOffer}/{idUser}")
    @ResponseBody
    public void addOffer( @RequestBody Reservation r,@PathVariable long idUser, @PathVariable long idOffer) throws MessagingException {
        reservationService.reservation(idUser,idOffer,r);
    }

    //http://localhost:8085/Reservation/calculTotal/1/1
    @GetMapping("/calculTotal/{idReservation}")
    @ResponseBody
    public float calculTotal( @PathVariable long idReservation){
        return reservationService.prixTotale(idReservation);
    }



    //http://localhost:8085/Reservation/1/stripe
    @PostMapping("/stripe/{idUser}")
    @ResponseBody
    public Payment index( @PathVariable long idUser ,@RequestBody Payment p ) throws StripeException {
            return stripeService.payment(idUser,p);
    }


}
