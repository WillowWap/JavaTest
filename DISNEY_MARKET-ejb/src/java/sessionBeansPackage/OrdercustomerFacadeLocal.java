/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeansPackage;

import EntityPackage.Ordercustomer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aude
 */
@Local
public interface OrdercustomerFacadeLocal {

    void create(Ordercustomer ordercustomer);

    void edit(Ordercustomer ordercustomer);

    void remove(Ordercustomer ordercustomer);

    Ordercustomer find(Object id);

    List<Ordercustomer> findAll();

    List<Ordercustomer> findRange(int[] range);

    int count();
    
}
