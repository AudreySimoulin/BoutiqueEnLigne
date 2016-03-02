/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueEnLigne.service;

import boutiqueEnLigne.entity.Utilisateur;
import boutiqueEnLigne.exception.MailExistantException;
import boutiqueEnLigne.exception.PasswordOuEmailErroneException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
public class UtilisateurServiceImpl {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private MailServiceMock mailService;

    public void inscription(Utilisateur u) throws MailExistantException {

        List<Utilisateur> util = utilisateurService.findByEmail(u.getEmail());

        if (util.isEmpty() == false) {
            throw new MailExistantException();
        }
        utilisateurService.save(u); 
        
        mailService.mail("Admin", "Dest", "Inscription validée", "Vous êtes bien inscrit !");

    }
    
    public void connexion(String email, String mdp) throws PasswordOuEmailErroneException{
        List<Utilisateur> util1 = utilisateurService.findByEmail(email);
        
        if(util1.isEmpty()==false || util1.get(0).getMdp().equals(mdp)){
            throw new PasswordOuEmailErroneException();
        }
        
        System.out.println("Félicitations vous êtes connectés");
        
    }
}
