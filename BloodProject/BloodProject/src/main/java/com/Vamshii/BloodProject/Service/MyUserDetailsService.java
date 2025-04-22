package com.Vamshii.BloodProject.Service;

import com.Vamshii.BloodProject.Model.UserPrinciple;
import com.Vamshii.BloodProject.Model.Users;
import com.Vamshii.BloodProject.repository.RepositoryForUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private RepositoryForUsers repositoryForUsers;

    public MyUserDetailsService(){
        System.out.println(repositoryForUsers);
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users user=repositoryForUsers.findByUserName(userName);
        System.out.println(repositoryForUsers);
        if(user==null){
            throw new UsernameNotFoundException("User is Not Registered");
        }
        return new UserPrinciple(user);
    }
}
