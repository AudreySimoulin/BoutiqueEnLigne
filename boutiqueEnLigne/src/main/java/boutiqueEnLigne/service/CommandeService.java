/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueEnLigne.service;

import boutiqueEnLigne.entity.Commande;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface CommandeService extends CrudRepository<Commande, Long>{
    
    public List<Commande> findByUtilisateurIdOrderByDateCommandeDesc(Long id);
    public List<Commande> findByPaye(Boolean paye);
    public List<Commande> findByLivre(Boolean livre);
    
}
