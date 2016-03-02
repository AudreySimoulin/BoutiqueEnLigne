/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueEnLigne.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author admin
 */
@Entity
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCommande;

    private Double prixTotal;

    private Boolean paye = false;

    private Boolean livre = false;

    @OneToMany(mappedBy = "commande")
    private List<Souscommande> sousCommandes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "Util_ID")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "ModeLivraison_ID")
    private Modelivraison modeLivraison;

    public Commande() {
    }

    public Commande(Long id, Date dateCommande, Double prixTotal, Utilisateur utilisateur, Modelivraison modeLivraison) {
        this.id = id;
        this.dateCommande = dateCommande;
        this.prixTotal = prixTotal;
        this.utilisateur = utilisateur;
        this.modeLivraison = modeLivraison;
    }

    public Boolean getLivre() {
        return livre;
    }

    public void setLivre(Boolean livre) {
        this.livre = livre;
    }

    public List<Souscommande> getSousCommandes() {
        return sousCommandes;
    }

    public void setSousCommandes(List<Souscommande> sousCommandes) {
        this.sousCommandes = sousCommandes;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Modelivraison getModeLivraison() {
        return modeLivraison;
    }

    public void setModeLivraison(Modelivraison modeLivraison) {
        this.modeLivraison = modeLivraison;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public Boolean getPaye() {
        return paye;
    }

    public void setPaye(Boolean paye) {
        this.paye = paye;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "boutiqueEnLigne.entity.Commande[ id=" + id + " ]";
    }

}
