/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueEnLigne.service;

import boutiqueEnLigne.entity.Codepromo;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface CodepromoService extends CrudRepository<Codepromo, Long>{
    
    public Codepromo findOneByCode(String code);
    
}
