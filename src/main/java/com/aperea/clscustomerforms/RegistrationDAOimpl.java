/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aperea.clscustomerforms;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Armando
 */
@Stateless
public class RegistrationDAOimpl implements RegistrationDAO, Serializable {
     @PersistenceContext(unitName = "CLSFormsDB")
    private EntityManager entityManager;
     
    @Override
    public void Add(Requestor requestor){
        
            entityManager.persist(requestor);
           
    }

}
