package com.Vamshii.BloodProject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RequestAccepted {
    @Id
    private int id;
    private String requesterMail;
    private PersonInfo personInfo;

    public RequestAccepted() {
    }

    public RequestAccepted(int id, String requesterMail, PersonInfo personInfo) {
        this.id = id;
        this.requesterMail = requesterMail;
        this.personInfo = personInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequesterMail() {
        return requesterMail;
    }

    public void setRequesterMail(String requesterMail) {
        this.requesterMail = requesterMail;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    @Override
    public String toString() {
        return "RequestAccepted{" +
                "id=" + id +
                ", requesterMail='" + requesterMail + '\'' +
                ", personInfo=" + personInfo +
                '}';
    }
}
