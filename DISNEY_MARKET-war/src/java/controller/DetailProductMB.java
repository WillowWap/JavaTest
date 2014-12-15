
package controller;

import EntityPackage.Product;
import EntityPackage.Translationproduct;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import sessionBeansPackage.ProductFacadeLocal;
import sessionBeansPackage.TranslationproductFacadeLocal;

@Named(value = "detailProductMB")
@ViewScoped
public class DetailProductMB {
    @EJB
    private TranslationproductFacadeLocal translationproductFacade;
    @EJB
    private ProductFacadeLocal productFacade;
         @Inject
    private InternationalizationManagedBeans lang; 
 
   private model_D.Product productModel = new model_D.Product();
    public DetailProductMB() {
    }

  
    public model_D.Product getProductModel() {
        return productModel;
    }

    public void setProductModel(model_D.Product productModel) {
        this.productModel = productModel;
    }
    
    
    @PostConstruct
       public void init ()
       {      
           String language = lang.getLocale().getLanguage();
           Integer idProduct =Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idProduct"));
           model_D.Product productTranslation;
           productModel  = productFacade.convertOneToModel(idProduct);
           productTranslation = translationproductFacade.ConvertToModel(idProduct, language);
           
           productModel.setDescription(productTranslation.getDescription());
           productModel.setLabel(productTranslation.getLabel());
           productModel.setCountry(productTranslation.getCountry());
           productModel.setGenre(productTranslation.getGenre());
           productModel.setTypeVideoGame(productTranslation.getTypeVideoGame());
        }
}