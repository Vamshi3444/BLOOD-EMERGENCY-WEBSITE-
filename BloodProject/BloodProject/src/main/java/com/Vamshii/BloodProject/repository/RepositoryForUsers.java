package com.Vamshii.BloodProject.repository;


import com.Vamshii.BloodProject.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryForUsers extends JpaRepository<Users,String> {
          Users findByUserName(String userName);
}
