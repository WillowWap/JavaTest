
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
    private String connection = "Failed";
    private String password;
    private String mail;
    private Customer custoDB;
    
    public ConnectionMB() {
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
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
    
    public String Connect ()
    {
       custoDB = customerFacade.findByEmail(mail);
        
        if(custoDB != null)
        {
            if(custoDB.getEmailaddress().equals(mail) && custoDB.getPassword().equals(password))
            {
                connection = "connect";
            }
            else 
            {
                connection = "Failed";
            }
        }
        else
        {
                connection = "Failed";
        }
        
        if(connection.equals("connect"))
        {
           return "index.xhtml"; 
        }
        else
        {
            return "RegistrationDenied.xhtml";
        }
    }
}
