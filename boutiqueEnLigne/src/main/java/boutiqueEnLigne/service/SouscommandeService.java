/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueEnLigne.service;

import boutiqueEnLigne.entity.Souscommande;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface SouscommandeService extends CrudRepository<Souscommande, Long>{
    
}
