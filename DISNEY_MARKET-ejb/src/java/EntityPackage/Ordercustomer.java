/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityPackage;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aude
 */
@Entity
@Table(name = "ORDERCUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordercustomer.findAll", query = "SELECT o FROM Ordercustomer o"),
    @NamedQuery(name = "Ordercustomer.findByIdorder", query = "SELECT o FROM Ordercustomer o WHERE o.idorder = :idorder"),
    @NamedQuery(name = "Ordercustomer.findByDeliveryaddress", query = "SELECT o FROM Ordercustomer o WHERE o.deliveryaddress = :deliveryaddress")})
public class Ordercustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDORDER")
    private Integer idorder;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DELIVERYADDRESS")
    private String deliveryaddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderref")
    private Collection<Line> lineCollection;
    @JoinColumn(name = "CUSTOMERREF", referencedColumnName = "IDCUSTOMER")
    @ManyToOne(optional = false)
    private Customer customerref;

    public Ordercustomer() {
    }

    public Ordercustomer(Integer idorder) {
        this.idorder = idorder;
    }

    public Ordercustomer(Integer idorder, String deliveryaddress) {
        this.idorder = idorder;
        this.deliveryaddress = deliveryaddress;
    }

    public Integer getIdorder() {
        return idorder;
    }

    public void setIdorder(Integer idorder) {
        this.idorder = idorder;
    }

    public String getDeliveryaddress() {
        return deliveryaddress;
    }

    public void setDeliveryaddress(String deliveryaddress) {
        this.deliveryaddress = deliveryaddress;
    }

    @XmlTransient
    public Collection<Line> getLineCollection() {
        return lineCollection;
    }

    public void setLineCollection(Collection<Line> lineCollection) {
        this.lineCollection = lineCollection;
    }

    public Customer getCustomerref() {
        return customerref;
    }

    public void setCustomerref(Customer customerref) {
        this.customerref = customerref;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idorder != null ? idorder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordercustomer)) {
            return false;
        }
        Ordercustomer other = (Ordercustomer) object;
        if ((this.idorder == null && other.idorder != null) || (this.idorder != null && !this.idorder.equals(other.idorder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityPackage.Ordercustomer[ idorder=" + idorder + " ]";
    }
    
}
