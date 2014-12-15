/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeansPackage;


import EntityPackage.Category;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CategoryFacade extends AbstractFacade<Category> implements CategoryFacadeLocal {
    @PersistenceContext(unitName = "DISNEY_MARKET-ejbPU")
    private EntityManager em;
 

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryFacade() {
        super(Category.class);
    }

    @Override
    public ArrayList<model_D.Category> convertToModel ()
    {
        ArrayList <model_D.Category> modelCat = new ArrayList <model_D.Category>();
        List<Category> entityCat = this.findAll();
        
        for(Category cat : entityCat)
        {
            model_D.Category category = new model_D.Category(); 
            category.setIdCategory(cat.getIdcategory());
            category.setFilePicture(cat.getFilepicture());
            category.setDiscountRef(null);
            modelCat.add(category);
        }
        return modelCat;
        
    }
    
}
