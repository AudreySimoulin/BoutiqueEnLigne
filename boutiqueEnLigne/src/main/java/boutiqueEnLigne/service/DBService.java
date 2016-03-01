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
public class DBService {
    
    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private CategorieService categorieService;
    
    @Autowired
    private CodepromoService codepromoService;
    
    @Autowired
    private CommandeService commandeService;
    
    @Autowired
    private ModelivraisonService modelivraisonService;
    
    @Autowired
    private SouscommandeService souscommandeService;
    
    @Autowired
    private UtilisateurService utilisateurService;
    
    public void deleteAll(){
        souscommandeService.deleteAll();
        articleService.deleteAll();
        categorieService.deleteAll();
        commandeService.deleteAll();
        modelivraisonService.deleteAll();
        utilisateurService.deleteAll();
        codepromoService.deleteAll();
    }
    
}
