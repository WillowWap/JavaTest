/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Locale;

/**
 *
 * @author Aude
 */
@Named(value = "internationalizationManagedBeans")
@SessionScoped
public class InternationalizationManagedBeans implements Serializable {

      private Locale locale = new Locale ("fr");
     
    public Locale getLocale() {
        return locale;
    }
    
    public InternationalizationManagedBeans() {}
    
    public void setToEnglish ()
    {
        locale = new Locale ("en");
    }
    public void setToFrench ()
    {
        locale = new Locale ("fr");
    }
    
    public void setToNederlands ()
    {
        locale = new Locale ("nl");
    }
}
