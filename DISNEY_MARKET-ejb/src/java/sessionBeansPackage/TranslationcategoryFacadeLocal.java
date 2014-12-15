/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeansPackage;

import EntityPackage.Translationcategory;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TranslationcategoryFacadeLocal {

    void create(Translationcategory translationcategory);

    void edit(Translationcategory translationcategory);

    void remove(Translationcategory translationcategory);

    Translationcategory find(Object id);

    String findLabel (short idCategory, String languages);
    
    List<Translationcategory> findAll();

    List<Translationcategory> findRange(int[] range);

    int count();
    
}
