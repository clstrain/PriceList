/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PriceList;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

class SmtpAuthenticator extends Authenticator {

    String user;
    String pw;

    public SmtpAuthenticator(String username, String password) {
        super();
        this.user = username;
        this.pw = password;
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, pw);
    }
}
