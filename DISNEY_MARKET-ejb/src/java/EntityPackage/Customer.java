/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityPackage;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByIdcustomer", query = "SELECT c FROM Customer c WHERE c.idcustomer = :idcustomer"),
    @NamedQuery(name = "Customer.findByEmailaddress", query = "SELECT c FROM Customer c WHERE c.emailaddress = :emailaddress"),
    @NamedQuery(name = "Customer.findByPassword", query = "SELECT c FROM Customer c WHERE c.password = :password"),
    @NamedQuery(name = "Customer.findByNamecustomer", query = "SELECT c FROM Customer c WHERE c.namecustomer = :namecustomer"),
    @NamedQuery(name = "Customer.findByFirstname", query = "SELECT c FROM Customer c WHERE c.firstname = :firstname"),
    @NamedQuery(name = "Customer.findByAddress", query = "SELECT c FROM Customer c WHERE c.address = :address"),
    @NamedQuery(name = "Customer.findByPhonenumber", query = "SELECT c FROM Customer c WHERE c.phonenumber = :phonenumber"),
    @NamedQuery(name = "Customer.findByBirthdate", query = "SELECT c FROM Customer c WHERE c.birthdate = :birthdate")})
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCUSTOMER")
    private Integer idcustomer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAILADDRESS")
    private String emailaddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAMECUSTOMER")
    private String namecustomer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PHONENUMBER")
    private Long phonenumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BIRTHDATE")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerref")
    private Collection<Ordercustomer> ordercustomerCollection;

    public Customer() {
    }

    public Customer(Integer idcustomer) {
        this.idcustomer = idcustomer;
    }

    public Customer(Integer idcustomer, String emailaddress, String password, String namecustomer, String firstname, String address, Date birthdate) {
        this.idcustomer = idcustomer;
        this.emailaddress = emailaddress;
        this.password = password;
        this.namecustomer = namecustomer;
        this.firstname = firstname;
        this.address = address;
        this.birthdate = birthdate;
    }

    public Integer getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(Integer idcustomer) {
        this.idcustomer = idcustomer;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNamecustomer() {
        return namecustomer;
    }

    public void setNamecustomer(String namecustomer) {
        this.namecustomer = namecustomer;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @XmlTransient
    public Collection<Ordercustomer> getOrdercustomerCollection() {
        return ordercustomerCollection;
    }

    public void setOrdercustomerCollection(Collection<Ordercustomer> ordercustomerCollection) {
        this.ordercustomerCollection = ordercustomerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcustomer != null ? idcustomer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.idcustomer == null && other.idcustomer != null) || (this.idcustomer != null && !this.idcustomer.equals(other.idcustomer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityPackage.Customer[ idcustomer=" + idcustomer + " ]";
    }
    
}
