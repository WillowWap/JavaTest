/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeansPackage;

import EntityPackage.Languageapp;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aude
 */
@Local
public interface LanguageappFacadeLocal {

    void create(Languageapp languageapp);

    void edit(Languageapp languageapp);

    void remove(Languageapp languageapp);

    Languageapp find(Object id);

    List<Languageapp> findAll();

    List<Languageapp> findRange(int[] range);

    int count();
    
}
