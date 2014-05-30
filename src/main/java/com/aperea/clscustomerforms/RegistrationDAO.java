/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aperea.clscustomerforms;

import java.io.Serializable;
import org.hibernate.Session;

/**
 *
 * @author Armando
 */
public class RegistrationDAO implements Serializable {

    public void Add(Requestor requestor) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        session.save(requestor);
        session.getTransaction().commit();

    }

    

}
