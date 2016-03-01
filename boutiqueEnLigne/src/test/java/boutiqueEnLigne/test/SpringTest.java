/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueEnLigne.test;

import boutiqueEnLigne.service.ArticleService;
import boutiqueEnLigne.service.CategorieService;
import boutiqueEnLigne.service.CodepromoService;
import boutiqueEnLigne.service.CommandeService;
import boutiqueEnLigne.service.DBService;
import boutiqueEnLigne.service.ModelivraisonService;
import boutiqueEnLigne.service.SouscommandeService;
import boutiqueEnLigne.service.UtilisateurService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import boutiqueEnLigne.spring.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author ETY
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfig.class)
public class SpringTest {

    @PersistenceContext
    private EntityManager em;

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
    
    @Autowired
    private DBService dBService;

    @Test
    public void doNadaOK() {

    }

}
