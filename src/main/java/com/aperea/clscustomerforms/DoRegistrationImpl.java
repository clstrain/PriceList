/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aperea.clscustomerforms;

import java.io.Serializable;
import javax.ejb.Stateful;
import javax.inject.Inject;

/**
 *
 * @author Armando
 */
@Stateful
public class DoRegistrationImpl implements DoRegistration, Serializable{
 @Inject
    private RegistrationDAO registrationDAO;
    @Override
    public void AddNewRegistration(Requestor registration) {
        registrationDAO.Add(registration);
    }
    
}
