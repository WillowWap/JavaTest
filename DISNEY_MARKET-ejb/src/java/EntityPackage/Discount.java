/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityPackage;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aude
 */
@Entity
@Table(name = "DISCOUNT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Discount.findAll", query = "SELECT d FROM Discount d"),
    @NamedQuery(name = "Discount.findByIddiscount", query = "SELECT d FROM Discount d WHERE d.iddiscount = :iddiscount"),
    @NamedQuery(name = "Discount.findByPercent", query = "SELECT d FROM Discount d WHERE d.percent = :percent")})
public class Discount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDDISCOUNT")
    private Integer iddiscount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERCENT")
    private short percent;
    @OneToMany(mappedBy = "discountref")
    private Collection<Category> categoryCollection;
    @OneToMany(mappedBy = "discountref")
    private Collection<Product> productCollection;

    public Discount() {
    }

    public Discount(Integer iddiscount) {
        this.iddiscount = iddiscount;
    }

    public Discount(Integer iddiscount, short percent) {
        this.iddiscount = iddiscount;
        this.percent = percent;
    }

    public Integer getIddiscount() {
        return iddiscount;
    }

    public void setIddiscount(Integer iddiscount) {
        this.iddiscount = iddiscount;
    }

    public short getPercent() {
        return percent;
    }

    public void setPercent(short percent) {
        this.percent = percent;
    }

    @XmlTransient
    public Collection<Category> getCategoryCollection() {
        return categoryCollection;
    }

    public void setCategoryCollection(Collection<Category> categoryCollection) {
        this.categoryCollection = categoryCollection;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddiscount != null ? iddiscount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Discount)) {
            return false;
        }
        Discount other = (Discount) object;
        if ((this.iddiscount == null && other.iddiscount != null) || (this.iddiscount != null && !this.iddiscount.equals(other.iddiscount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityPackage.Discount[ iddiscount=" + iddiscount + " ]";
    }
    
}
