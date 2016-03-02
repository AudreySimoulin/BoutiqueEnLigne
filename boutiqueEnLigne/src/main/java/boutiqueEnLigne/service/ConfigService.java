/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueEnLigne.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */

@Service
public class ConfigService {
    
    private String emailSite = "admin@boutiqueenligne.com";

    public String getEmailSite() {
        return emailSite;
    }

    public void setEmailSite(String emailSite) {
        this.emailSite = emailSite;
    }
    
}
