package com.Vamshii.BloodProject.Service;
import com.Vamshii.BloodProject.Model.PersonInfo;
import com.Vamshii.BloodProject.CustomExceptions.PersonNotFoundException;
import com.Vamshii.BloodProject.repository.RepositroyForPersonInfo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonInfoService {

    private RepositroyForPersonInfo repo;


    public PersonInfoService(RepositroyForPersonInfo repo){
        this.repo=repo;
    }
    
    public void addPersonInfo(PersonInfo person){
        repo.save(person);
    }


    public List<PersonInfo> getPersonInfoByBloodGroup(String bloodGroup, String address) throws PersonNotFoundException {

                List<PersonInfo> personInfos=repo.getPersonInfoByBloodGroupAndAddress(bloodGroup, address);
                if(personInfos==null){
                    throw new PersonNotFoundException("There is no person with Matching Blood ");

                }
          return personInfos;
    }

    public void updatePersonInfo(PersonInfo person) {
        repo.save(person);
    }

    public void deletePersonInfo(long phoneNumber) {
        repo.deleteById((int) phoneNumber);
    }
}
