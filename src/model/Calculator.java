package model;

import control.Controller;

public class Calculator {

    private double num1;
    private double num2;
    private Operation operationChoice;
    private boolean isFirstNumber;
    private boolean equalPressed;

    public Calculator()
    {
        isFirstNumber = true;
    }

    public void setNumber(double n)
    {
        if(isFirstNumber)
            num1 = n;
        else
            num2 = n;
    }

    public void resetNumbers(){

        num1= 0;
        num2= 0;
    }

    public double calculate()
    {
    //double num1;

    switch (operationChoice.getSymbol()) {
        case '+': num1 = num1 + num2; break;
        case '-': num1 = num1 - num2; break;
        case '*': num1 = num1 * num2; break;
        case '/': num1 = (num2 == 0) ? 0 : (num1 / num2); break;
    }
   // resetNumbers();
    isFirstNumber = true;

            return num1;
     }

//--------------------------------------------------
    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public Operation getOperationChoice() {
        return operationChoice;
    }

    public void setOperationChoice(Operation operationChoice) {
        isFirstNumber = !isFirstNumber;
        this.operationChoice = operationChoice;
    }

}
