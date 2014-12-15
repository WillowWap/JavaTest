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

@Entity
@Table(name = "CATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByIdcategory", query = "SELECT c FROM Category c WHERE c.idcategory = :idcategory"),
    @NamedQuery(name = "Category.findByFilepicture", query = "SELECT c FROM Category c WHERE c.filepicture = :filepicture")})
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCATEGORY")
    private Short idcategory;
    @Size(max = 50)
    @Column(name = "FILEPICTURE")
    private String filepicture;
    @JoinColumn(name = "DISCOUNTREF", referencedColumnName = "IDDISCOUNT")
    @ManyToOne
    private Discount discountref;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryref")
    private Collection<Product> productCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryref")
    private Collection<Translationcategory> translationcategoryCollection;

    public Category() {
    }

    public Category(Short idcategory) {
        this.idcategory = idcategory;
    }

    public Short getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(Short idcategory) {
        this.idcategory = idcategory;
    }

    public String getFilepicture() {
        return filepicture;
    }

    public void setFilepicture(String filepicture) {
        this.filepicture = filepicture;
    }

    public Discount getDiscountref() {
        return discountref;
    }

    public void setDiscountref(Discount discountref) {
        this.discountref = discountref;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @XmlTransient
    public Collection<Translationcategory> getTranslationcategoryCollection() {
        return translationcategoryCollection;
    }

    public void setTranslationcategoryCollection(Collection<Translationcategory> translationcategoryCollection) {
        this.translationcategoryCollection = translationcategoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcategory != null ? idcategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.idcategory == null && other.idcategory != null) || (this.idcategory != null && !this.idcategory.equals(other.idcategory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityPackage.Category[ idcategory=" + idcategory + " ]";
    }
    
}
