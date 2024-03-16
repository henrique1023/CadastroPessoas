package com.cadastro.pessoas.cadastropessoas.bean.validation;

import com.cadastro.pessoas.cadastropessoas.utils.Cast;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
@Named
@RequestScoped
public class BeanValidations implements Serializable {
    public void validateNumberType(FacesContext facesContext, UIComponent uiComponent, Object o)
            throws ValidatorException {
            String numero = Cast.toString(o);
            if(!numero.matches("\\d+")){
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "O campo só aceita numeros", "");
                throw new ValidatorException(message);
            }
    }
}
