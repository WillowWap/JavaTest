
package sessionBeansPackage;

import EntityPackage.Product;
import java.util.List;
import javax.ejb.Local;
import java.util.ArrayList;


@Local
public interface ProductFacadeLocal {

    void create(Product product);

    void edit(Product product);

    void remove(Product product);

    Product find(Object id);
    
    model_D.Product convertOneToModel (Integer idProduct);

    List<Product> findAll();
    
    List<Product> FindAllProductCat (short idCat); 
    
     public ArrayList<model_D.Product> convertListEntityToListModel(Short idCat);

    List<Product> findRange(int[] range);

    int count();
    
}
