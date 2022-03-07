package com.esprit.pidevbackend.Service;

import com.WellBeingProject.GetCloser.Entity.QVT;
import com.WellBeingProject.GetCloser.Entity.RQuizz;
import com.WellBeingProject.GetCloser.Repository.QVTRepsitory;
import com.WellBeingProject.GetCloser.Repository.RQuizzRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RQuizzServiceImpl implements IRQuizzSevice {
    @Autowired
    RQuizzRepo rQuizzRepo;
    @Autowired
    QVTRepsitory qvtRepsitory;
    @Override
    public void AddRQuizz(RQuizz e) {
        rQuizzRepo.save(e);
    }

    @Override
    public List<RQuizz> getAllRQuizz() {
        return rQuizzRepo.findAll();
    }

    @Override
    public void DeleteRQuizz(int id) {
        rQuizzRepo.deleteById(id);
    }

    @Override
    public void UpdateRQuizz(RQuizz e) {
        rQuizzRepo.save(e);
    }

    @Override
    public void AddRQuizzToQuizz(RQuizz e, int idQuizz) {
        QVT qvt= qvtRepsitory.findById(idQuizz).orElse(null);
        rQuizzRepo.save(e);
        qvt.setRQuizzes(e);
    }

    public RQuizz SelectRquizz( int id){
        return rQuizzRepo.SelectRquizz(id);
    }

}
