/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueEnLigne.entity;

import boutiqueEnLigne.enumeration.Genre;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer stock;

    private Double prix;

    @Column(length = 32)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "Categorie_ID")
    private Categorie categorie;

    @OneToMany(mappedBy = "article")
    private List<Souscommande> articlesCommandes = new ArrayList<Souscommande>();

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Temporal(TemporalType.DATE)
    private Date datePublication;

    public Article() {
    }

    public Article(Long id, Integer stock, Double prix, String nom, Categorie categorie, Genre genre, Date datePublication) {
        this.id = id;
        this.stock = stock;
        this.prix = prix;
        this.nom = nom;
        this.categorie = categorie;
        this.genre = genre;
        this.datePublication = datePublication;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Date getDate() {
        return datePublication;
    }

    public void setDate(Date datePublication) {
        this.datePublication = datePublication;
    }

    public List<Souscommande> getArticlesCommandes() {
        return articlesCommandes;
    }

    public void setArticlesCommandes(List<Souscommande> articlesCommandes) {
        this.articlesCommandes = articlesCommandes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
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
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "boutiqueEnLigne.entity.Article[ id=" + id + " ]";
    }

}
