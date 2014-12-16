/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeansPackage;

import EntityPackage.Customer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class CustomerFacade extends AbstractFacade<Customer> implements CustomerFacadeLocal {
    @PersistenceContext(unitName = "DISNEY_MARKET-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }
    public Customer findByEmail (String email)
    {
        Query query;
        query = em.createNamedQuery("Customer.findByEmailaddress");
        query.setParameter("emailaddress", email);
        return (Customer) query.getSingleResult();
    }
    
     public Boolean findIfEmailAlreadyExist (String email)
    {
        Boolean exist = false;
        Query query;
        query = em.createNamedQuery("Customer.findByEmailaddress");
        query.setParameter("emailaddress", email);
        try{
            Customer customer = (Customer) query.getSingleResult();
            if(customer != null)
                exist = true;
        }
        catch (NoResultException em)
        {
            exist = false;
        }
        
        return exist;
    }
    
    
    
}
