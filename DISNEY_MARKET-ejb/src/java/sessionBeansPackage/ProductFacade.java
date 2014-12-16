
package sessionBeansPackage;

import EntityPackage.Product;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
             if(product.getDiscountref() != null)
             {
                Double reduction = product.getPrice().doubleValue() * product.getDiscountref().getPercent()/100;
               double p= product.getPrice().doubleValue() - reduction;
               BigDecimal price = new BigDecimal(p);
                model_D.Discount discount = new model_D.Discount();
                discount.setPercent(product.getDiscountref().getPercent());    
                productModel.setPrice(price.setScale(2, BigDecimal.ROUND_CEILING));
                
             }
             else 
             {
                 productModel.setPrice(product.getPrice());
             }    
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
        if(product.getDiscountref() != null)
             {
                 model_D.Discount discount = new model_D.Discount();
                 Double reduction = product.getPrice().doubleValue() * product.getDiscountref().getPercent()/100;
                 double p= product.getPrice().doubleValue() - reduction;
                 BigDecimal price = new BigDecimal(p);
                 discount.setPercent(product.getDiscountref().getPercent());    
                 productModel.setPrice(price.setScale(2, BigDecimal.ROUND_CEILING));
                
             }
             else 
             {
                 productModel.setPrice(product.getPrice());
             } 
        productModel.setRuntime(product.getRuntime());
        
        return productModel;
    }
    
    public ArrayList<model_D.Product> findProductForDiscount (List<Integer> idDiscount)
    {
        ArrayList<model_D.Product> productModelList = new ArrayList<model_D.Product>();
        Query query; 
        for (Integer id : idDiscount)
        {
            query = em.createNamedQuery("Product.FindAllDiscount");
            query.setParameter("idDiscount", id);
            List<Product> productEntityList = (List<Product>) query.getResultList(); 

            for (Product product : productEntityList)
            {
                model_D.Product productModel = new model_D.Product();
                model_D.Discount discount = new model_D.Discount();
                Double reduction = product.getPrice().doubleValue() * product.getDiscountref().getPercent()/100;
                double p= product.getPrice().doubleValue() - reduction;
                BigDecimal price = new BigDecimal(p);
                discount.setPercent(product.getDiscountref().getPercent());


                productModel.setPrice(price.setScale(2, BigDecimal.ROUND_CEILING));
                productModel.setReference(product.getReference());
                productModel.setFilePicture(product.getFilepicture());
                productModel.setDiscountRef(discount);
                productModelList.add(productModel);
            }
        }
        return productModelList;
    }
}
