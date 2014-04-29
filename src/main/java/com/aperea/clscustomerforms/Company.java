/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aperea.clscustomerforms;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Armando
 */
@Embeddable
public class Company implements Serializable {
    private String companyName, companyPhone;
        
    private Address companyAddress;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public Address getCompanyAddress() {
        if (companyAddress==null)
        {
            companyAddress=new Address();
        }
        return companyAddress;
    }

    public void setCompanyAddress(Address companyAddress) {
        this.companyAddress = companyAddress;
    }


    
    
}
