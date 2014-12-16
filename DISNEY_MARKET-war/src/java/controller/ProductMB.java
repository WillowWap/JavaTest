
package controller;

import EntityPackage.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import sessionBeansPackage.DiscountFacadeLocal;
import sessionBeansPackage.ProductFacadeLocal;
import sessionBeansPackage.TranslationproductFacadeLocal;

@Named(value = "productMB")
@ViewScoped
public class ProductMB {
    @EJB
    private DiscountFacadeLocal discountFacade;
   @EJB
    private TranslationproductFacadeLocal translationproductFacade;
    @EJB
    private ProductFacadeLocal productFacade;
    
      @Inject
    private InternationalizationManagedBeans lang; 
    private List<Product> listProduct; 
    private ArrayList<model_D.Product> productListModel = new ArrayList<model_D.Product>(); 
    
    public ProductMB() {
    }
    
    public ArrayList<model_D.Product> getProductListModel() {
        return productListModel;
    }

    public void setProductListModel(ArrayList<model_D.Product> productListModel) {
        this.productListModel = productListModel;
    }
    public ProductFacadeLocal getProductFacade() {
        return productFacade;
    }
    
    public void setProductFacade(ProductFacadeLocal productFacade) {
        this.productFacade = productFacade;
    }
 
    
    
    
    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }
    
    @PostConstruct
    public void init ()
    {
        String langage = lang.getLocale().getLanguage();
        Short idCat = new Short (FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("categoryId"));
        
        productListModel = productFacade.convertListEntityToListModel(idCat);
       
        
         for(model_D.Product product : productListModel)
         {
             
             product.setLabel(translationproductFacade.findByProductAndLang(product.getReference(), langage));
         }
         
    }
    
}
