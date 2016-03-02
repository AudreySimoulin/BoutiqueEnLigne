/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueEnLigne.service;

import boutiqueEnLigne.entity.Codepromo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class GenerationCodeService {

    @Autowired
    private CodepromoService codepromoService;

    private String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private int charLength = chars.length();

    public String generateString(int length) {
        StringBuilder pass = new StringBuilder(charLength);

        boolean codeValide = false;

        do {
            for (int x = 0; x < length; x++) {
                int i = (int) (Math.random() * charLength);
                pass.append(chars.charAt(i));
            }

            Codepromo cp = codepromoService.findOneByCodePromo(pass.toString());

            if (cp != null) {
                pass = new StringBuilder(charLength);
            }
            codeValide = true;
            

        } while (codeValide = false);
        
        return pass.toString();

    }

}
