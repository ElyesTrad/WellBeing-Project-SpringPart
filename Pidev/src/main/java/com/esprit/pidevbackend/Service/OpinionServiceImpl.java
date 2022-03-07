package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.User;
import com.esprit.pidevbackend.Domain.Opinion;
import com.esprit.pidevbackend.Repository.OpinionRepository;
import com.esprit.pidevbackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OpinionServiceImpl implements IOpinionService {
    @Autowired
    OpinionRepository opinionRepository;
    @Autowired
    UserRepository accountRepo;


    @Override
    public void AddOpinion(Opinion e) {
        opinionRepository.save(e);
    }

    @Override
    public List<Opinion> getAllOpinions() {
        List<Opinion> e=  opinionRepository.findAll();
        return e;
    }

    @Override
    public void DeleteOpinion(int id) {
    opinionRepository.deleteById(id);
    }

    @Override
    public void UpdateOpinion(Opinion e) {
        opinionRepository.save(e);
    }

    @Override
    public void AddOpinionToUser(Opinion e, Long idUser) {
        User a=accountRepo.findById(idUser).orElse(null);
        opinionRepository.save(e);
        e.setUser(a);
    }
}
