/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueEnLigne.service;

import boutiqueEnLigne.entity.Article;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface ArticleService extends CrudRepository<Article, Long>{
    
    public List<Article> findByCategorieId(Long id);
    public List<Article> findByCategorieIdOrderByPrixAsc(Long id);
    public List<Article> findByCategorieIdOrderByPrixDesc(Long id);
    public List<Article> findByNomContainingIgnoreCase(String str);
    public List<Article> findByNomContainingIgnoreCaseOrderByPrixDesc(String str);
    public List<Article> findByNomContainingIgnoreCaseOrderByPrixAsc(String str);
    public List<Article> findByCategorieIdAndNomContainingIgnoreCase(Long id, String str);
    public List<Article> findByCategorieIdAndNomContainingIgnoreCaseOrderByPrixDesc(Long id, String str);
    public List<Article> findByCategorieIdAndNomContainingIgnoreCaseOrderByPrixAsc(Long id, String str);
  
     
    
    
}
