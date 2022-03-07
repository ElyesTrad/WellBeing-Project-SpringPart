package com.esprit.pidevbackend.Service;

import com.WellBeingProject.GetCloser.Entity.QVT;

import java.util.List;

public interface IQVTService {
    public void AddQVT(QVT e);
    public List<QVT> getAllQVT();
    public void DeleteQVT(int id);
    public void UpdateQVT(QVT e);
    public String ConseilsPersonnalisesQuiz(int idQuizz);

}
