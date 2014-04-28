/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PriceList;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author aperea
 */
public class CourseRegistration {
    private Customer customer;
    private String courseType, courseName, poNumber, nonRevNumber;
    private Date courseDate, registrationDate;
    private Boolean trainingCredits, acceptTerms;

    public CourseRegistration() {
    }

    public CourseRegistration(Customer customer, String courseType, 
            String courseName, Date courseDate, Date registrationDate, Boolean trainingCredits, Boolean acceptTerms, String nonRevNumber) {
        this.customer = customer;
        this.courseType = courseType;
        this.courseName = courseName;
        this.courseDate = courseDate;
        this.registrationDate = registrationDate;
        this.trainingCredits = trainingCredits;
        this.nonRevNumber = nonRevNumber;
        this.acceptTerms = acceptTerms;
    }

    public String getCurrentDate() {
        String dateString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        dateString = sdf.format(date);
        return dateString;
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(Date courseDate) {
        this.courseDate = courseDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getNonRevNumber() {
        return nonRevNumber;
    }

    public void setNonRevNumber(String nonRevNumber) {
        this.nonRevNumber = nonRevNumber;
    }

    public Boolean getTrainingCredits() {
        return trainingCredits;
    }

    public void setTrainingCredits(Boolean trainingCredits) {
        this.trainingCredits = trainingCredits;
    }

    public Boolean getAcceptTerms() {
        return acceptTerms;
    }

    public void setAcceptTerms(Boolean acceptTerms) {
        this.acceptTerms = acceptTerms;
    }
    
    
}
