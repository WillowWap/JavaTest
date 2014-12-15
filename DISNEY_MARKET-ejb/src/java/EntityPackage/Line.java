/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aude
 */
@Entity
@Table(name = "LINE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Line.findAll", query = "SELECT l FROM Line l"),
    @NamedQuery(name = "Line.findByIdline", query = "SELECT l FROM Line l WHERE l.idline = :idline"),
    @NamedQuery(name = "Line.findByQuantity", query = "SELECT l FROM Line l WHERE l.quantity = :quantity"),
    @NamedQuery(name = "Line.findByPrice", query = "SELECT l FROM Line l WHERE l.price = :price")})
public class Line implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLINE")
    private Integer idline;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY")
    private short quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private BigDecimal price;
    @JoinColumn(name = "ORDERREF", referencedColumnName = "IDORDER")
    @ManyToOne(optional = false)
    private Ordercustomer orderref;
    @JoinColumn(name = "PRODUCTREF", referencedColumnName = "REFERENCE")
    @ManyToOne(optional = false)
    private Product productref;

    public Line() {
    }

    public Line(Integer idline) {
        this.idline = idline;
    }

    public Line(Integer idline, short quantity, BigDecimal price) {
        this.idline = idline;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getIdline() {
        return idline;
    }

    public void setIdline(Integer idline) {
        this.idline = idline;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Ordercustomer getOrderref() {
        return orderref;
    }

    public void setOrderref(Ordercustomer orderref) {
        this.orderref = orderref;
    }

    public Product getProductref() {
        return productref;
    }

    public void setProductref(Product productref) {
        this.productref = productref;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idline != null ? idline.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Line)) {
            return false;
        }
        Line other = (Line) object;
        if ((this.idline == null && other.idline != null) || (this.idline != null && !this.idline.equals(other.idline))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityPackage.Line[ idline=" + idline + " ]";
    }
    
}
