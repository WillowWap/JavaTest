
package sessionBeansPackage;

import EntityPackage.Translationproduct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class TranslationproductFacade extends AbstractFacade<Translationproduct> implements TranslationproductFacadeLocal {
    @PersistenceContext(unitName = "DISNEY_MARKET-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TranslationproductFacade() {
        super(Translationproduct.class);
    }
    public String findByProductAndLang (Integer refProduct, String languages)
    {
        Query query; 
        query = em.createNamedQuery("Translationproduct.findByProductAndLang");
        query.setParameter("codeLang", languages);
        query.setParameter("refProduct", refProduct);
        return (String) query.getSingleResult();
    }
       public  Translationproduct findForProdcutDetailWithLang (Integer refProduct, String languages)
    {
        Query query;
        query = em.createNamedQuery("Translationproduct.findForProductDetailWithLang");
        query.setParameter("codeLang", languages);
        query.setParameter("refProduct", refProduct);
        return (Translationproduct) query.getSingleResult();
    }
       
      public model_D.Product ConvertToModel (Integer refProduct, String languages)
      {
          Translationproduct translation = this.findForProdcutDetailWithLang(refProduct, languages);
          model_D.Product product = new model_D.Product();
          
          product.setCountry(translation.getCountry());
          product.setDescription(translation.getDescription());
          product.setGenre(translation.getGenre());
          product.setLabel(translation.getLabel());
          product.setTypeVideoGame(translation.getTypevideogame());
          
          return product;
      }
}
