/*
 * Ciena Course Registration Form
 * 
 */
package PriceList;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.util.logging.Logger;
import org.primefaces.event.FlowEvent;


@ManagedBean(name = "courseRegistration")
@SessionScoped
public class CourseRegBean implements Serializable {

    private Customer customer = new Customer();
    private CourseRegistration courseRegistration = new CourseRegistration();

    public void trainingCreditsMessage() {
        String summary = courseRegistration.getTrainingCredits() ? "Training Credits" : "No Training Credits";

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }

    public void agreeMessage() {
        String summary = courseRegistration.getAcceptTerms() ? "Agreed" : "Not Agreed";

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }

    public String getCurrentDate() {
        String dateString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        dateString = sdf.format(date);
        return dateString;
    }

    public void submit() {

        String trainingCreditsBoolean = String.valueOf(this.courseRegistration.getTrainingCredits());
        
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("techtrng.course.reg@gmail.com", "dmewualfcajjfxqd");
            }
        });

        try {

            Message message = new MimeMessage(session);
           // message.setFrom(new InternetAddress("techtrng.course.reg@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("techtng@ciena.com"));
            message.setSubject(this.courseRegistration.getCourseName()+" Course Registration on "+this.getCourseRegistration().getCourseDate());
            message.setText("This is an automated email."
                    + "\n\n Ciena Course Registration information follows:"
                    +"\n\n Student Name: "+this.customer.getFirstName()+" "+this.customer.getLastName()
                    +"\n\n Student Email: "+this.customer.getEmail()
                    +"\n\n Company Name: "+this.customer.getCompanyName()
                    +"\n\n Company Address: "+this.customer.getCompanyAddress()
                    +"\n\n Company Address2: "+this.customer.getCompanyAddress2()
                    +"\n\n Country: "+this.customer.getCountry()
                    +"\n\n Student Phone Number: "+this.customer.getPhone()
                    +"\n\n Relation to Ciena: "+this.customer.getCienaRelation()
                    +"\n\n Course Type: "+this.courseRegistration.getCourseType()
                    +"\n\n Course Kit/ Number and Name: "+this.courseRegistration.getCourseName()
                    +"\n\n Course Date: "+this.courseRegistration.getCourseDate()
                    +"\n\n PO Number: "+this.courseRegistration.getPoNumber()
                    +"\n\n Training Credits: "+trainingCreditsBoolean
                    +"\n\n Non-Rev Number: "+this.courseRegistration.getNonRevNumber()
                    +"\n\n End");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CourseRegistration getCourseRegistration() {
        return courseRegistration;
    }

    public void setCourseRegistration(CourseRegistration courseRegistration) {
        this.courseRegistration = courseRegistration;
    }
    
    
    
     private boolean skip;  
      
    private static Logger logger = Logger.getLogger(CourseRegBean.class.getName());  
     
      
    public void save(ActionEvent actionEvent) {  
        //Persist courseregistation  
          
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + courseRegistration.getCustomer().getFirstName());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
      
    public boolean isSkip() {  
        return skip;  
    }  
  
    public void setSkip(boolean skip) {  
        this.skip = skip;  
    }  
      
    public String onFlowProcess(FlowEvent event) {  
        logger.info("Current wizard step:" + event.getOldStep());  
        logger.info("Next step:" + event.getNewStep());  
          
        if(skip) {  
            skip = false;   //reset in case user goes back  
            return "confirm";  
        }  
        else {  
            return event.getNewStep();  
        }  
    }  
    
}
