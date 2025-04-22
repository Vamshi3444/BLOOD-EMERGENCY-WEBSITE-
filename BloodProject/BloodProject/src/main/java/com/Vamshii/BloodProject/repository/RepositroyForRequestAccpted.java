package com.Vamshii.BloodProject.repository;

import com.Vamshii.BloodProject.Model.PersonInfo;
import com.Vamshii.BloodProject.Model.RequestAccepted;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositroyForRequestAccpted extends JpaRepository<RequestAccepted,Integer> {
    List<RequestAccepted> findByrequesterMail(String email);
}
