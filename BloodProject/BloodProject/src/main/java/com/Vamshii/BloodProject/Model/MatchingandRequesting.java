package com.Vamshii.BloodProject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class MatchingandRequesting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String helperEmail;
   private RequestForBlood requestForBlood;

    public MatchingandRequesting() {
    }

    public MatchingandRequesting(int id, String helperEmail, RequestForBlood requestForBlood) {
        this.id = id;
        this.helperEmail = helperEmail;
        this.requestForBlood = requestForBlood;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHelperEmail() {
        return helperEmail;
    }

    public void setHelperEmail(String helperEmail) {
        this.helperEmail = helperEmail;
    }

    public RequestForBlood getRequestForBlood() {
        return requestForBlood;
    }

    public void setRequestForBlood(RequestForBlood requestForBlood) {
        this.requestForBlood = requestForBlood;
    }

    @Override
    public String toString() {
        return "MatchingandRequesting{" +
                "id=" + id +
                ", helperEmail='" + helperEmail + '\'' +
                ", requestForBlood=" + requestForBlood +
                '}';
    }
}
