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
@Table(name = "TRANSLATIONCATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Translationcategory.findAll", query = "SELECT t FROM Translationcategory t"),
    @NamedQuery(name = "Translationcategory.findByIdtranslation", query = "SELECT t FROM Translationcategory t WHERE t.idtranslation = :idtranslation"),
    @NamedQuery(name = "Translationcategory.findByLabel", query = "SELECT t FROM Translationcategory t WHERE t.label = :label"),
    @NamedQuery (name = "Translationcategory.findByCatAndLang", query = "SELECT p.label FROM Translationcategory p WHERE p.categoryref.idcategory = :categoryid AND p.languageref.codelanguage = :languagesId")})
public class Translationcategory implements Serializable {
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
    @JoinColumn(name = "CATEGORYREF", referencedColumnName = "IDCATEGORY")
    @ManyToOne(optional = false)
    private Category categoryref;
    @JoinColumn(name = "LANGUAGEREF", referencedColumnName = "CODELANGUAGE")
    @ManyToOne(optional = false)
    private Languageapp languageref;

    public Translationcategory() {
    }

    public Translationcategory(Integer idtranslation) {
        this.idtranslation = idtranslation;
    }

    public Translationcategory(Integer idtranslation, String label) {
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

    public Category getCategoryref() {
        return categoryref;
    }

    public void setCategoryref(Category categoryref) {
        this.categoryref = categoryref;
    }

    public Languageapp getLanguageref() {
        return languageref;
    }

    public void setLanguageref(Languageapp languageref) {
        this.languageref = languageref;
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
        if (!(object instanceof Translationcategory)) {
            return false;
        }
        Translationcategory other = (Translationcategory) object;
        if ((this.idtranslation == null && other.idtranslation != null) || (this.idtranslation != null && !this.idtranslation.equals(other.idtranslation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityPackage.Translationcategory[ idtranslation=" + idtranslation + " ]";
    }
    
}
