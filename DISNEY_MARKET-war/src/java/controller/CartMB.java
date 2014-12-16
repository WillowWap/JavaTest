
package controller;

import EntityPackage.Line;
import EntityPackage.Product;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import sessionBeansPackage.LineFacadeLocal;

@Named(value = "basketMB")
@SessionScoped
public class CartMB implements Serializable {
    @EJB
    private LineFacadeLocal lineFacade;
    private HashMap<Integer,model_D.Line> basket = new HashMap<Integer,model_D.Line>();
    private static int idLine; 
    private Short quantity = 0;
    private model_D.Line line;
    
    public CartMB() {

    }


    public HashMap<Integer, model_D.Line> getBasket() {
        return basket;
    }

    public void setBasket(HashMap<Integer, model_D.Line> basket) {
        this.basket = basket;
    }

    public static int getIdLine() {
        return idLine;
    }

    public static void setIdLine(int idLine) {
        CartMB.idLine = idLine;
    }

    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

    public model_D.Line getLine() {
        return line;
    }

    public void setLine(model_D.Line line) {
        this.line = line;
    }
    
    
    public void addToBasket (model_D.Product product)
    {
        Double p = product.getPrice().doubleValue() * quantity.doubleValue();
        
        BigDecimal price = new BigDecimal(p);
        model_D.Line line = new model_D.Line();
        
        line.setProdctRef(product);
        line.setQuantity(quantity);
        line.setIdLigne(1);
        line.setPrice(price);
        
        
        basket.put(1, line);

    }
    
    public void GetTheBasket ()
    {
//        ArrayList<model_D.Line> listLine = new ArrayList<model_D.Line>();
//        for(model_D.Line line : basket.values())
//        {
//            listLine.add(line);
//            
//        }
        line = basket.get(1);
    }
    
}
