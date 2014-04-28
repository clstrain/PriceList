/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PriceList;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
@ManagedBean(name="dateBean")
@SessionScoped
public class DateBean implements Serializable{
 
	Date date=new Date();
 
	public Date getDate() {
		return date;
	}
 
	public void setDate(Date date) {
		this.date = date;
	}
        
        public String getFileName(){
            return "CLS_PriceList_"+date;
        }
 
}