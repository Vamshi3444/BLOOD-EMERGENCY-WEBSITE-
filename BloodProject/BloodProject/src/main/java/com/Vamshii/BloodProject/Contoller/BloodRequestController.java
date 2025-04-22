package com.Vamshii.BloodProject.Contoller;

import com.Vamshii.BloodProject.CustomExceptions.PersonNotFoundException;
import com.Vamshii.BloodProject.Model.PersonInfo;
import com.Vamshii.BloodProject.Model.RequestForBlood;
import com.Vamshii.BloodProject.Service.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class BloodRequestController {

    @Autowired
    private BloodRequestService bloodRequestService;


    @PostMapping("/requestForBlood")
    public String requestForBlood(@RequestBody RequestForBlood requestForBlood) throws PersonNotFoundException {
        return bloodRequestService.requestForBlood(requestForBlood);
    }

    @GetMapping("/requestedForBlood")
    public List<RequestForBlood> requestedForBlood(){
        return bloodRequestService.requestedForBlood();
    }

    @PostMapping("/acceptRequest")
    public void acceptRequest( @RequestBody RequestForBlood requestForBlood){
        bloodRequestService.acceptRequest(requestForBlood);
    }

    @GetMapping("/requestAccepted")
    public List<PersonInfo> requestAccepted(){
        return bloodRequestService.requestAccepted();
    }
}
