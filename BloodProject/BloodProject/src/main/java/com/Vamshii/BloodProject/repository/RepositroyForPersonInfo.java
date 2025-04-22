package com.Vamshii.BloodProject.repository;

import com.Vamshii.BloodProject.Model.PersonInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositroyForPersonInfo extends JpaRepository<PersonInfo,Integer> {
    List<PersonInfo> getPersonInfoByBloodGroupAndAddress(String bloodGroup, String address);
    PersonInfo getPersonInfoByEmail(String email);
}




