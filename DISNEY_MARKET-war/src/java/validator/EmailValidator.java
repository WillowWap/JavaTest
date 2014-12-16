
package validator;

import EntityPackage.Customer;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import sessionBeansPackage.CustomerFacadeLocal;

@FacesValidator ("EmailValidator")
public class EmailValidator implements Validator {
    CustomerFacadeLocal customerFacade = lookupCustomerFacadeLocal();
    Customer customer;
       @Override
    public void validate (FacesContext context, UIComponent component, Object value)
            throws ValidatorException
    {
        String entry = (String) value;
                    if(! entry.matches("^([\\w\\d\\-\\.]+)@{1}(([\\w\\d\\-]{1,67})|([\\w\\d\\-]+\\.[\\w\\d\\-]{1,67}))\\.(([a-zA-Z\\d]{2,4})(\\.[a-zA-Z\\d]{2})?)$"))
                    {
                        FacesMessage ErrorMail = new FacesMessage (internationalization(context).getString("emailNotCorrect"));
                        throw new ValidatorException(ErrorMail);
                    }
                    
                    if(customerFacade.findIfEmailAlreadyExist(entry))
                    {
                        FacesMessage errorExist = new FacesMessage (internationalization(context).getString("emailExist"));
                        throw new ValidatorException (errorExist);
                    }
    }

    private CustomerFacadeLocal lookupCustomerFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (CustomerFacadeLocal) c.lookup("java:global/DISNEY_MARKET/DISNEY_MARKET-ejb/CustomerFacade!sessionBeansPackage.CustomerFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
       public ResourceBundle internationalization (FacesContext context)
    {
          Locale locale = context.getViewRoot().getLocale();
       return  ResourceBundle.getBundle("languages.lang", locale);
    }
    
}
    

