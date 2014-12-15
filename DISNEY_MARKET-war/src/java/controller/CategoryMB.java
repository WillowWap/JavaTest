package controller;

import java.util.ArrayList;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import sessionBeansPackage.CategoryFacadeLocal;
import sessionBeansPackage.TranslationcategoryFacadeLocal;

@Named(value = "categoryMB")
@RequestScoped
public class CategoryMB {
    @EJB
    private TranslationcategoryFacadeLocal translationcategoryFacade;
    @EJB
    private CategoryFacadeLocal categoryFacade;
    @Inject
    private InternationalizationManagedBeans lang; 
    
    public CategoryMB() {
    }
     public ArrayList<model_D.Category> findAll ()
    {
        String langage = lang.getLocale().getLanguage();
        
        ArrayList <model_D.Category> modelCat = categoryFacade.convertToModel();
        
        for(model_D.Category category : modelCat)
        {
            category.setLabel(translationcategoryFacade.findLabel(category.getIdCategory(), langage));
        }
        return modelCat;
    }
   
}
