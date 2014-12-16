
package controller;

import EntityPackage.Customer;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import sessionBeansPackage.CustomerFacadeLocal;


@Named(value = "connectionMB")
@SessionScoped
public class ConnectionMB implements Serializable {
    @EJB
    private CustomerFacadeLocal customerFacade;
    private Boolean connection = false;
    private String password;
    private String mail;
    private Customer custoDB;
    
    public ConnectionMB() {
    }

    public Boolean getConnection() {
        return connection;
    }

    public void setConnection(Boolean connection) {
        this.connection = connection;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Customer getCustoDB() {
        return custoDB;
    }

    public void setCustoDB(Customer custoDB) {
        this.custoDB = custoDB;
    }
    
    public String logIn ()
    {
       boolean exist = customerFacade.findIfEmailAlreadyExist(mail);
        
        if(exist)
        {
            if(custoDB.getEmailaddress().equals(mail) && custoDB.getPassword().equals(password))
            {
                connection = true;
            }
            else 
            {
                connection = false;
            }
        }
        else
        {
                connection = false;
        }
        
        if(connection)
        {
           return "index.xhtml"; 
        }
        else
        {
            return "RegistrationDenied.xhtml";
        }
    }
    
    
    public void logOut ()
    {
      connection = false; 
      custoDB = null;
    }
}
