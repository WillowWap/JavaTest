
package sessionBeansPackage;

import EntityPackage.Discount;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class DiscountFacade extends AbstractFacade<Discount> implements DiscountFacadeLocal {
    @PersistenceContext(unitName = "DISNEY_MARKET-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiscountFacade() {
        super(Discount.class);
    }
    
    public List<Integer> FindAllId ()
    {
        Query query; 
        query = em.createNamedQuery("Discount.findAllIdDiscout");
        return (List<Integer>) query.getResultList();
    }
    
}
