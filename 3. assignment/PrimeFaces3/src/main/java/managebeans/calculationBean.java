/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managebeans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author julia
 */
@Named(value = "calculationBean")
@RequestScoped
public class calculationBean {
    private Integer firstNumber;
    private Integer secondNumber;
    private Integer result;

    public void calculate() {
        result = firstNumber + secondNumber;
        
        String op = firstNumber.toString() + " + " + secondNumber.toString() + " = " + result.toString();
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage msg = new FacesMessage(op);
        context.addMessage("growl", msg);
        
    }
    
    public String getCurrentDateTime(){
        return new java.util.Date().toString();
    }
    
    /**
     * @return the firstNumber
     */
    public Integer getFirstNumber() {
        return firstNumber;
    }

    /**
     * @param firstNumber the firstNumber to set
     */
    public void setFirstNumber(Integer firstNumber) {
        this.firstNumber = firstNumber;
    }

    /**
     * @return the secondNumber
     */
    public Integer getSecondNumber() {
        return secondNumber;
    }

    /**
     * @param secondNumber the secondNumber to set
     */
    public void setSecondNumber(Integer secondNumber) {
        this.secondNumber = secondNumber;
    }

    /**
     * @return the result
     */
    public Integer getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(Integer result) {
        this.result = result;
    }
}
