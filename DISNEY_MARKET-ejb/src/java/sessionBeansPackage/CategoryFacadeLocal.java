/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeansPackage;

import EntityPackage.Category;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CategoryFacadeLocal {

    void create(Category category);

    void edit(Category category);

    void remove(Category category);

    Category find(Object id);

    List<Category> findAll();
    
    public ArrayList<model_D.Category> convertToModel ();

    List<Category> findRange(int[] range);

    int count();
    
}
