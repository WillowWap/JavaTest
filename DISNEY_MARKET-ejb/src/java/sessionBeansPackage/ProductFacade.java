
package sessionBeansPackage;

import EntityPackage.Product;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ProductFacade extends AbstractFacade<Product> implements ProductFacadeLocal {
    @PersistenceContext(unitName = "DISNEY_MARKET-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }
    
    @Override
    public List<Product> FindAllProductCat (short idCat)
    {
        Query query; 
        query = em.createNamedQuery("Product.FindAllProductCat");
        query.setParameter("idCategory", idCat);
        return (List<Product>) query.getResultList(); 
    }
    
    public ArrayList<model_D.Product> convertListEntityToListModel(Short idCat)
    {
         List<Product>listProduct = this.FindAllProductCat(idCat);
        ArrayList<model_D.Product> listModel = new ArrayList<model_D.Product>();
         for(Product product : listProduct)
         {
             model_D.Product productModel = new  model_D.Product();
             productModel.setReference((product.getReference()));
             productModel.setFilePicture(product.getFilepicture());
             productModel.setPrice(product.getPrice());
             listModel.add(productModel);
         }
         return listModel;
    }
    
    @Override
    public model_D.Product convertOneToModel (Integer idProduct)
    {
        Product product = this.find(idProduct);
        model_D.Product productModel = new model_D.Product();
        
        productModel.setAge(product.getAge());
        productModel.setAuthor(product.getAuthor());
        productModel.setFilePicture(product.getFilepicture());
        productModel.setReference(product.getReference());
        productModel.setNbCd(product.getNbcd());
        productModel.setNbTrack(product.getNbtrack());
        productModel.setPrice(product.getPrice());
        productModel.setRuntime(product.getRuntime());
        
        return productModel;
    }
}
