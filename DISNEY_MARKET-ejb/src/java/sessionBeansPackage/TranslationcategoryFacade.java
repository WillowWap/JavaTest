
package sessionBeansPackage;

import EntityPackage.Category;
import EntityPackage.Languageapp;
import EntityPackage.Translationcategory;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class TranslationcategoryFacade extends AbstractFacade<Translationcategory> implements TranslationcategoryFacadeLocal {
    @PersistenceContext(unitName = "DISNEY_MARKET-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TranslationcategoryFacade() {
        super(Translationcategory.class);
    }
    public String findLabel (short idCategory, String languages)
    {
        Query query; 
        query = em.createNamedQuery("Translationcategory.findByCatAndLang");
        query.setParameter("categoryid", idCategory);
        query.setParameter("languagesId", languages);
        return (String) query.getSingleResult();
    }
    
}
