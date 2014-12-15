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
@Table(name = "LANGUAGEAPP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Languageapp.findAll", query = "SELECT l FROM Languageapp l"),
    @NamedQuery(name = "Languageapp.findByCodelanguage", query = "SELECT l FROM Languageapp l WHERE l.codelanguage = :codelanguage")})
public class Languageapp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "CODELANGUAGE")
    private String codelanguage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languageref")
    private Collection<Translationcategory> translationcategoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languageref")
    private Collection<Translationproduct> translationproductCollection;

    public Languageapp() {
    }

    public Languageapp(String codelanguage) {
        this.codelanguage = codelanguage;
    }

    public String getCodelanguage() {
        return codelanguage;
    }

    public void setCodelanguage(String codelanguage) {
        this.codelanguage = codelanguage;
    }

    @XmlTransient
    public Collection<Translationcategory> getTranslationcategoryCollection() {
        return translationcategoryCollection;
    }

    public void setTranslationcategoryCollection(Collection<Translationcategory> translationcategoryCollection) {
        this.translationcategoryCollection = translationcategoryCollection;
    }

    @XmlTransient
    public Collection<Translationproduct> getTranslationproductCollection() {
        return translationproductCollection;
    }

    public void setTranslationproductCollection(Collection<Translationproduct> translationproductCollection) {
        this.translationproductCollection = translationproductCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codelanguage != null ? codelanguage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Languageapp)) {
            return false;
        }
        Languageapp other = (Languageapp) object;
        if ((this.codelanguage == null && other.codelanguage != null) || (this.codelanguage != null && !this.codelanguage.equals(other.codelanguage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityPackage.Languageapp[ codelanguage=" + codelanguage + " ]";
    }
    
}
