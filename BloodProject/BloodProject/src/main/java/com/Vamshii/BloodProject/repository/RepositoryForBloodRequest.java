package com.Vamshii.BloodProject.repository;

import com.Vamshii.BloodProject.Model.MatchingandRequesting;
import com.Vamshii.BloodProject.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryForBloodRequest extends JpaRepository<MatchingandRequesting,Integer> {
    List<MatchingandRequesting> findByhelperEmail(String userName);
}
