/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueEnLigne.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */

@Service
public class MailServiceMock implements MailService{
    
    @Autowired
    private ConfigService configService;

    @Override
    public void mail(String dest, String titre, String contenu) {
        configService.getEmailSite();
        System.out.println(titre + " : " + contenu);
    }
    
}
