/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aperea.clscustomerforms;

import javax.ejb.Local;

/**
 *
 * @author Armando
 */
@Local
public interface RegistrationDAO {
    public void Add(Requestor requestor);
}
