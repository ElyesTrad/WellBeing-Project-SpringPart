package com.esprit.pidevbackend.API;

import com.esprit.pidevbackend.Domain.Payment;
import com.esprit.pidevbackend.Domain.User;
import com.esprit.pidevbackend.Repository.UserRepository;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    @Autowired
    UserRepository userRepository;

    @Value("sk_test_51KhM0dLVKNxUp7QKaSYm5RgoKdyz63FcA8J4yGCR5QpO6nrroYsbsITZu5YEcURxo5erVDTmGG25XWAC6cvfqztK00TbzVhB6d")
    String stripeKey;

    public Payment payment(long idUser , Payment p) throws StripeException {
        Stripe.apiKey= stripeKey;
        User user = userRepository.findById(idUser).get();
        Map<String, Object> params = new HashMap<>();
        params.put("name",user.getName());
        params.put("email",user.getEmail());
        params.put("amount","");
        Customer customer = Customer.create(params);
        p.setCustomerId(customer.getId());
        return p;
    }



}
