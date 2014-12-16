
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import sessionBeansPackage.DiscountFacadeLocal;
import sessionBeansPackage.ProductFacadeLocal;
import sessionBeansPackage.TranslationproductFacadeLocal;

@Named(value = "discountMB")
@ViewScoped
public class DiscountMB {
     @EJB
    private DiscountFacadeLocal discountFacade;
   @EJB
    private TranslationproductFacadeLocal translationproductFacade;
    @EJB
    private ProductFacadeLocal productFacade;
    
      @Inject
    private InternationalizationManagedBeans lang; 
  
    public DiscountMB() {
    }
    
    public ArrayList<model_D.Product> findDiscount ()
    {
        String langage = lang.getLocale().getLanguage();
        List<Integer> listId = discountFacade.FindAllId();
        ArrayList <model_D.Product> productDiscount = productFacade.findProductForDiscount(listId);
        for (model_D.Product product : productDiscount)
        {
            product.setLabel(translationproductFacade.findByProductAndLang(product.getReference(), langage));
        }
        return productDiscount;
        
    }
}
