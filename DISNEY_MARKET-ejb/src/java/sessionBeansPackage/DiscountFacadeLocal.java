
package sessionBeansPackage;

import EntityPackage.Discount;
import java.util.List;
import javax.ejb.Local;


@Local
public interface DiscountFacadeLocal {

    void create(Discount discount);

    void edit(Discount discount);

    void remove(Discount discount);

    Discount find(Object id);

    List<Discount> findAll();

    List<Discount> findRange(int[] range);

    List<Integer> FindAllId ();
            
    int count();
    
}
