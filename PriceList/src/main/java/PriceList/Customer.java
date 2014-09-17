/*
 * Customer Class
 * 
 */
package PriceList;

import java.io.Serializable;

/**
 *
 * @author aperea
 */
public class Customer implements Serializable {

    private String firstName, lastName, email,
            companyName, companyAddress, companyAddress2,
            country, phone, cienaRelation;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email,
            String companyName, String companyAddress, String companyAddress2,
            String country, String phone, String cienaRelation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyAddress2 = companyAddress2;
        this.country = country;
        this.phone = phone;
        this.cienaRelation = cienaRelation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyAddress2() {
        return companyAddress2;
    }

    public void setCompanyAddress2(String companyAddress2) {
        this.companyAddress2 = companyAddress2;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCienaRelation() {
        return cienaRelation;
    }

    public void setCienaRelation(String cienaRelation) {
        this.cienaRelation = cienaRelation;
    }
}
