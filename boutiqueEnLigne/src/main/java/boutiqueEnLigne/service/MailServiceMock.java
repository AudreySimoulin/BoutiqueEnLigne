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
public class MailServiceMock implements MailService{

    @Override
    public void mail(String src, String dest, String titre, String contenu) {
        System.out.println(titre + " : " + contenu);
    }
    
}
