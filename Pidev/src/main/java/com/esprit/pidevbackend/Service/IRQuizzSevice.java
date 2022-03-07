package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.RQuizz;

import java.util.List;

public interface IRQuizzSevice {
    public void AddRQuizz(RQuizz e);
    public List<RQuizz> getAllRQuizz();
    public void DeleteRQuizz(int id);
    public void UpdateRQuizz(RQuizz e);
    public void AddRQuizzToQuizz(RQuizz e, int idQuizz);
    public RQuizz SelectRquizz(int id);

}
