package com.Vamshii.BloodProject.Contoller;

import com.Vamshii.BloodProject.CustomExceptions.PersonNotFoundException;
import com.Vamshii.BloodProject.Model.PersonInfo;
import com.Vamshii.BloodProject.Service.PersonInfoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PersonInfoController {

    private PersonInfoService personInfoService;

    public PersonInfoController(PersonInfoService personInfoService){
        this.personInfoService=personInfoService;
    }

    @PostMapping("/addPersonInfo")
    public void addPersonInfo(@RequestBody PersonInfo person) {
        personInfoService.addPersonInfo(person);
    }

    @GetMapping("/getPersonsInfo/{bloodGroup},{address}")
    public List<PersonInfo> getPersonInfoByBloodGroup(@PathVariable String bloodGroup,@PathVariable String address) throws PersonNotFoundException {
            return personInfoService.getPersonInfoByBloodGroup(bloodGroup, address);
    }



    @PutMapping("/updatePersonInfo")
    public void updatePersonInfo(@RequestBody PersonInfo person){
        personInfoService.updatePersonInfo(person);
    }

    @DeleteMapping("/deletePersonInfo/{phoneNumber}")
    public void deletePersonInfo(@PathVariable long phoneNumber){
        personInfoService.deletePersonInfo(phoneNumber);
    }
}
