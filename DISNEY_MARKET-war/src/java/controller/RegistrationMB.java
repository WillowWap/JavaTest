
package controller;

import EntityPackage.Customer;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sessionBeansPackage.CustomerFacadeLocal;

@Named(value = "registrationMB")
@ViewScoped
public class RegistrationMB {
    @EJB
    private CustomerFacadeLocal customerFacade;
    private Customer customer = new Customer(); 
    private String confirmePassword;
    
    public RegistrationMB() {
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getConfirmePassword() {
        return confirmePassword;
    }

    public void setConfirmePassword(String confirmePassword) {
        this.confirmePassword = confirmePassword;
    }
  

   
    public String CheckPassword (String nothing) // si je ne met pas un argument ma page xhtml ne reconnait pas la méthode
    {
        if(customer.getPassword().equals(confirmePassword))
        {
             createCustomer(customer); 
            return "index.xhtml";
        }
        else 
        {
            return "RegistrationDenied.xhtml"; 
        }
    }
    
    public void createCustomer (Customer custome)
    {
        
        Date date = new Date(1994,12,11); 
        customer.setBirthdate(date);
        customer.setIdcustomer(this.generateTheID());
        customerFacade.create(customer);
    }
 
    public Integer generateTheID ()
    {
          Integer id = customerFacade.count();
        return id + 1;
    }
    
}
