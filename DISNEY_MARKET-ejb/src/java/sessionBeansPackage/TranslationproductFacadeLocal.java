
package sessionBeansPackage;

import EntityPackage.Translationproduct;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TranslationproductFacadeLocal {

    void create(Translationproduct translationproduct);

    void edit(Translationproduct translationproduct);

    void remove(Translationproduct translationproduct);

    Translationproduct find(Object id);
       
    List<Translationproduct> findAll();
    
   String findByProductAndLang (Integer refProduct, String languages);
   
   Translationproduct findForProdcutDetailWithLang (Integer refProduct, String languages);
   
   model_D.Product ConvertToModel (Integer refProduct, String languages);

    List<Translationproduct> findRange(int[] range);

    int count();
    
}
