package com.esprit.pidevbackend.Repository;

import com.WellBeingProject.GetCloser.Entity.RQuizz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RQuizzRepo extends JpaRepository<RQuizz,Integer> {

    @Query("select u from RQuizz u where u.qvt.id=:id")
    RQuizz SelectRquizz(@Param("id") int id);

}
