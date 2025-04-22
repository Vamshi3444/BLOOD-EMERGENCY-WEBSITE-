package com.Vamshii.BloodProject.Service;
import com.Vamshii.BloodProject.Contoller.PersonInfoController;
import com.Vamshii.BloodProject.CustomExceptions.PersonNotFoundException;
import com.Vamshii.BloodProject.Model.MatchingandRequesting;
import com.Vamshii.BloodProject.Model.PersonInfo;
import com.Vamshii.BloodProject.Model.RequestAccepted;
import com.Vamshii.BloodProject.Model.RequestForBlood;
import com.Vamshii.BloodProject.repository.RepositoryForBloodRequest;
import com.Vamshii.BloodProject.repository.RepositroyForPersonInfo;
import com.Vamshii.BloodProject.repository.RepositroyForRequestAccpted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class BloodRequestService {

    @Autowired
    private PersonInfoController personInfoService;

    @Autowired
    private RepositoryForBloodRequest repositoryForBloodRequest;

    @Autowired
    private RepositroyForPersonInfo repositoryForPersonInfo;

    @Autowired
    private RepositroyForRequestAccpted repositroyForRequestAccpted;

    public String requestForBlood(RequestForBlood requestForBlood) throws PersonNotFoundException {
        if(requestForBlood.getEmail().equals(GetUserName.getUserName())){
        ArrayList<PersonInfo> helpers = new ArrayList<>(personInfoService.getPersonInfoByBloodGroup(requestForBlood.getBloodGroup(), requestForBlood.getAddress()));
        for (PersonInfo p : helpers) {
            MatchingandRequesting matchingandRequesting = new MatchingandRequesting(0,p.getEmail(), requestForBlood);
            repositoryForBloodRequest.save(matchingandRequesting);
            return "Request Sent";
        }
        }
        return "Email is not same ";
    }

    public List<RequestForBlood> requestedForBlood() {
        List<RequestForBlood> req=new ArrayList<>();
       for(MatchingandRequesting m:repositoryForBloodRequest.findByhelperEmail(GetUserName.getUserName())){
           req.add(m.getRequestForBlood());
       }
       return req;
    }

    public void acceptRequest(RequestForBlood requestForBlood) {
        PersonInfo person=repositoryForPersonInfo.getPersonInfoByEmail(GetUserName.getUserName());
        System.out.println(requestForBlood);
        RequestAccepted requestAccepted=new RequestAccepted(0,requestForBlood.getEmail(),person);
        repositroyForRequestAccpted.save(requestAccepted);
    }

    public List<PersonInfo> requestAccepted() {
        String email=GetUserName.getUserName();
        List<PersonInfo> personsAccpeted=new ArrayList<>();
        for(RequestAccepted requestAccepted:repositroyForRequestAccpted.findByrequesterMail(email)){
             personsAccpeted.add(requestAccepted.getPersonInfo());
        }
        return personsAccpeted;
    }
}