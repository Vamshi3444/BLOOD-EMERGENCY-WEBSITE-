package com.Vamshii.BloodProject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Component;

@Data
public class RequestForBlood {

    private String name;
    private String email;
    private String gender;
    private int age;
    private String bloodGroup;
    private String bloodRequiredInLitres;
    private String address;

    public RequestForBlood() {
    }

    public RequestForBlood(String name,String email, String gender, int age, String bloodGroup, String bloodRequiredInLitres, String address) {
        this.name = name;
        this.email=email;
        this.gender = gender;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.bloodRequiredInLitres = bloodRequiredInLitres;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getBloodRequiredInLitres() {
        return bloodRequiredInLitres;
    }

    public void setBloodRequiredInLitres(String bloodRequiredInLitres) {
        this.bloodRequiredInLitres = bloodRequiredInLitres;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "RequestForBlood{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", bloodRequiredInLitres='" + bloodRequiredInLitres + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
