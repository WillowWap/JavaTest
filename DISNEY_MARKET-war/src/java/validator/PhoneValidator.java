/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator ("PhoneValidator")
public class PhoneValidator implements Validator{
     @Override
    public void validate (FacesContext context, UIComponent component, Object value)
            throws ValidatorException
    {
        String entry = String.valueOf(value);
                    if(! entry.matches("^[0-9]+$"))
                    {
                        FacesMessage ErrorMail = new FacesMessage ("the phone number can containe / . or + juste Number.");
                        throw new ValidatorException(ErrorMail);
                    }
    }
    
}
