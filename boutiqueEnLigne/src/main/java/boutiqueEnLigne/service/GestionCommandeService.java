/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueEnLigne.service;

import boutiqueEnLigne.entity.Article;
import boutiqueEnLigne.entity.Codepromo;
import boutiqueEnLigne.entity.Commande;
import boutiqueEnLigne.entity.Souscommande;
import boutiqueEnLigne.enumeration.TypeCodePromo;
import boutiqueEnLigne.exception.CommandePayeeException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
public class GestionCommandeService {

    @Autowired
    private CodepromoService codepromoService;

    @Autowired
    private SouscommandeService souscommandeService;

    @Autowired
    private CommandeService commandeService;

    @Autowired
    private ArticleService articleService;

    public void mAjPrixTotal(Commande cmd) {

        double total = 0.0;

        for (Souscommande sscmd : cmd.getSousCommandes()) {
            total = total + (sscmd.getArticle().getPrix() * sscmd.getQuantite());
        }
        cmd.setPrixTotal(total);

    }

    public void modifierQuantiteArticle(Article a, Commande c, Integer quantite) throws CommandePayeeException {

        if (c.getPaye() == true) {
            throw new CommandePayeeException();
        }

        //Si commande non payee
        for (Souscommande sc : c.getSousCommandes()) {
            //Si l'article est deja present dans la sc
            if (sc.getArticle().equals(a)) {
                sc.setQuantite(quantite);
                souscommandeService.save(sc);
                c.setPrixTotal(c.getPrixTotal() + (sc.getArticle().getPrix() * sc.getQuantite()));
            } //Si l'article n'est pas present
            else {
                Souscommande sc1 = new Souscommande(quantite, a, c);
                c.getSousCommandes().add(sc1);
                souscommandeService.save(sc1);
                c.setPrixTotal(c.getPrixTotal() + (sc1.getArticle().getPrix() * sc1.getQuantite()));
            }
            commandeService.save(c);
        }
    }

    public void supprimerSousCommande(Souscommande sc, Commande c) throws CommandePayeeException {

        if (c.getPaye() == true) {
            throw new CommandePayeeException();
        }

        c.getSousCommandes().remove(sc);
        c.setPrixTotal(c.getPrixTotal() - (sc.getArticle().getPrix() * sc.getQuantite()));
        souscommandeService.delete(sc);
        commandeService.save(c);

    }

    public void payerCommande(Commande cmd) {
        cmd.setPaye(Boolean.TRUE);

        for (Souscommande sc : cmd.getSousCommandes()) {
            Article a = sc.getArticle();
            a.setStock(a.getStock() - sc.getQuantite());
            articleService.save(a);
        }
    }

    public Double prixTotalAvecCodePromo(String code, Commande cmd) {
        Codepromo codePromo = codepromoService.findOneByCodePromo(code);
        Double reduction = 0.0;
        Double prixTotal = 0.0;

        //Si le code promo n'existe pas calcul du total sans remise
        if (codePromo == null) {
            System.out.println("Code Promo invalide");
            mAjPrixTotal(cmd);
        }
        //Calculs de la réduction selonn le typeCodePromo : Poucentage, Remise
        if (codePromo.getTypeCodePromo() == TypeCodePromo.Pourcentage) {
            mAjPrixTotal(cmd);
            reduction = cmd.getPrixTotal() * (codePromo.getValeur() / 100);
        }

        if (codePromo.getTypeCodePromo() == TypeCodePromo.Remise) {
            mAjPrixTotal(cmd);
            reduction = codePromo.getValeur();
        }

        return prixTotal = cmd.getPrixTotal() - reduction;

    }

    }


