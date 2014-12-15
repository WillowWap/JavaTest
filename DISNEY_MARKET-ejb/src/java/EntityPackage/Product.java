
package EntityPackage;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByReference", query = "SELECT p FROM Product p WHERE p.reference = :reference"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price"),
    @NamedQuery(name = "Product.findByAuthor", query = "SELECT p FROM Product p WHERE p.author = :author"),
    @NamedQuery(name = "Product.findByRuntime", query = "SELECT p FROM Product p WHERE p.runtime = :runtime"),
    @NamedQuery(name = "Product.findByAge", query = "SELECT p FROM Product p WHERE p.age = :age"),
    @NamedQuery(name = "Product.findByNbtrack", query = "SELECT p FROM Product p WHERE p.nbtrack = :nbtrack"),
    @NamedQuery(name = "Product.findByNbcd", query = "SELECT p FROM Product p WHERE p.nbcd = :nbcd"),
    @NamedQuery(name = "Product.findByFilepicture", query = "SELECT p FROM Product p WHERE p.filepicture = :filepicture"),
    @NamedQuery(name = "Product.FindAllProductCat", query = "SELECT p FROM Product p WHERE p.categoryref.idcategory = :idCategory")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "REFERENCE")
    private Integer reference;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private BigDecimal price;
    @Size(max = 50)
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "RUNTIME")
    private Short runtime;
    @Column(name = "AGE")
    private Short age;
    @Column(name = "NBTRACK")
    private Short nbtrack;
    @Column(name = "NBCD")
    private Short nbcd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FILEPICTURE")
    private String filepicture;
    @JoinColumn(name = "CATEGORYREF", referencedColumnName = "IDCATEGORY")
    @ManyToOne(optional = false)
    private Category categoryref;
    @JoinColumn(name = "DISCOUNTREF", referencedColumnName = "IDDISCOUNT")
    @ManyToOne
    private Discount discountref;

    public Product() {
    }

    public Product(Integer reference) {
        this.reference = reference;
    }

    public Product(Integer reference, BigDecimal price, String filepicture) {
        this.reference = reference;
        this.price = price;
        this.filepicture = filepicture;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Short getRuntime() {
        return runtime;
    }

    public void setRuntime(Short runtime) {
        this.runtime = runtime;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public Short getNbtrack() {
        return nbtrack;
    }

    public void setNbtrack(Short nbtrack) {
        this.nbtrack = nbtrack;
    }

    public Short getNbcd() {
        return nbcd;
    }

    public void setNbcd(Short nbcd) {
        this.nbcd = nbcd;
    }

    public String getFilepicture() {
        return filepicture;
    }

    public void setFilepicture(String filepicture) {
        this.filepicture = filepicture;
    }

    public Category getCategoryref() {
        return categoryref;
    }

    public void setCategoryref(Category categoryref) {
        this.categoryref = categoryref;
    }

    public Discount getDiscountref() {
        return discountref;
    }

    public void setDiscountref(Discount discountref) {
        this.discountref = discountref;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reference != null ? reference.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.reference == null && other.reference != null) || (this.reference != null && !this.reference.equals(other.reference))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityPackage.Product[ reference=" + reference + " ]";
    }
    
}
