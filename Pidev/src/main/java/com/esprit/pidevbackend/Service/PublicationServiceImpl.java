package com.esprit.pidevbackend.Service;

import com.WellBeingProject.GetCloser.Entity.Account;
import com.WellBeingProject.GetCloser.Entity.Publication;
import com.WellBeingProject.GetCloser.Repository.AccountRepo;
import com.WellBeingProject.GetCloser.Repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PublicationServiceImpl implements IPublicationService {
    @Autowired
    PublicationRepository publicationRepository;
    @Autowired
    AccountRepo accountRepo;
    @Override
    public void AddPublication(Publication e) {
       publicationRepository.save(e);
    }

    @Override
    public List<Publication> getAllPublication() {
        return  publicationRepository.findAll();
    }

    @Override
    public void DeletePublication(int id) {
        publicationRepository.deleteById(id);
    }

    @Override
    public void UpdatePublication(Publication e) {
        publicationRepository.save(e);
    }

    @Override
    public void AddPublicationToUser(Publication e, int id) {
        Account account=accountRepo.findById(id).orElse(null);
        publicationRepository.save(e);
        e.setAccount(account);

    }


}
