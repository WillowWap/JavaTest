/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityPackage;

import java.io.Serializable;
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
@Table(name = "TRANSLATIONPRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Translationproduct.findAll", query = "SELECT t FROM Translationproduct t"),
    @NamedQuery(name = "Translationproduct.findByIdtranslation", query = "SELECT t FROM Translationproduct t WHERE t.idtranslation = :idtranslation"),
    @NamedQuery(name = "Translationproduct.findByLabel", query = "SELECT t FROM Translationproduct t WHERE t.label = :label"),
    @NamedQuery(name = "Translationproduct.findByDescription", query = "SELECT t FROM Translationproduct t WHERE t.description = :description"),
    @NamedQuery(name = "Translationproduct.findByCountry", query = "SELECT t FROM Translationproduct t WHERE t.country = :country"),
    @NamedQuery(name = "Translationproduct.findByGenre", query = "SELECT t FROM Translationproduct t WHERE t.genre = :genre"),
    @NamedQuery(name = "Translationproduct.findByTypevideogame", query = "SELECT t FROM Translationproduct t WHERE t.typevideogame = :typevideogame"),
    @NamedQuery(name = "Translationproduct.findByProductAndLang", query = "SELECT t.label FROM Translationproduct t WHERE t.languageref.codelanguage = :codeLang AND t.productref.reference = :refProduct"),
    @NamedQuery(name = "Translationproduct.findForProductDetailWithLang", query = "SELECT t FROM Translationproduct t WHERE t.languageref.codelanguage = :codeLang AND t.productref.reference = :refProduct")})
public class Translationproduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTRANSLATION")
    private Integer idtranslation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LABEL")
    private String label;
    @Size(max = 600)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 500)
    @Column(name = "COUNTRY")
    private String country;
    @Size(max = 50)
    @Column(name = "GENRE")
    private String genre;
    @Size(max = 50)
    @Column(name = "TYPEVIDEOGAME")
    private String typevideogame;
    @JoinColumn(name = "LANGUAGEREF", referencedColumnName = "CODELANGUAGE")
    @ManyToOne(optional = false)
    private Languageapp languageref;
    @JoinColumn(name = "PRODUCTREF", referencedColumnName = "REFERENCE")
    @ManyToOne(optional = false)
    private Product productref;

    public Translationproduct() {
    }

    public Translationproduct(Integer idtranslation) {
        this.idtranslation = idtranslation;
    }

    public Translationproduct(Integer idtranslation, String label) {
        this.idtranslation = idtranslation;
        this.label = label;
    }

    public Integer getIdtranslation() {
        return idtranslation;
    }

    public void setIdtranslation(Integer idtranslation) {
        this.idtranslation = idtranslation;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTypevideogame() {
        return typevideogame;
    }

    public void setTypevideogame(String typevideogame) {
        this.typevideogame = typevideogame;
    }

    public Languageapp getLanguageref() {
        return languageref;
    }

    public void setLanguageref(Languageapp languageref) {
        this.languageref = languageref;
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
        hash += (idtranslation != null ? idtranslation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Translationproduct)) {
            return false;
        }
        Translationproduct other = (Translationproduct) object;
        if ((this.idtranslation == null && other.idtranslation != null) || (this.idtranslation != null && !this.idtranslation.equals(other.idtranslation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityPackage.Translationproduct[ idtranslation=" + idtranslation + " ]";
    }
    
}
