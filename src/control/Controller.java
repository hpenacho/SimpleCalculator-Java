package control;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import model.Calculator;
import model.Operation;


public class Controller {

    public static boolean signalPressed = false;

    @FXML
    private TextField tb_window;

    private Calculator calc;
    private boolean startCalc = true;

    @FXML
    private void initialize() {
        calc = new Calculator();
    }

    private boolean isSymbol(String text) //metodo que devolve true caso o texto passado como parametro tenha algum simbolo aritmetico
    {
        return (text.equals('+') || text.equals('-') || text.equals('/') || text.equals('*'));
     }

     @FXML
     private void click_C_Btn (ActionEvent event)
     {
         Button btn = (Button)event.getSource();
         tb_window.clear();
         calc.resetNumbers();
         tb_window.setPromptText("Memory has been reset");
         signalPressed = false;
     }

     @FXML
     private void clickDelButton (ActionEvent event)
     {
         if(tb_window.getText().length() == 1)
         {
             tb_window.clear();
             calc.setNum1(0);
             tb_window.setPromptText("Last digit was erased");

         }
            else if(tb_window.getText().length() > 1) {
                String text = tb_window.getText(0, tb_window.getText().length() - 1);
                tb_window.setText(text);
                calc.setNum1(Double.parseDouble(text));
            }
     }

     @FXML
    private void clickBtn (ActionEvent event)
     {
         //comma = false;
         Button btn = (Button)event.getSource();
         double num = Double.parseDouble(btn.getText());
         if(isSymbol (tb_window.getText()) || startCalc)
             tb_window.clear();
         tb_window.setText(tb_window.getText() + btn.getText());
         calc.setNumber(Double.parseDouble(tb_window.getText()));
         startCalc = false;
     }

    @FXML
    private void clickComma (ActionEvent event) {

      if(!tb_window.getText().contains("."))
      {
          tb_window.setText(tb_window.getText() + ".");
      }
    }

    @FXML
    private void clickOperation(ActionEvent event)
     {
         Button btn = (Button) event.getSource();
         Operation op = Operation.valueOf(btn.getId().substring(4).toUpperCase());
         if (!(btn.getText().equals("="))){

             calc.setOperationChoice(op);
             tb_window.setText(btn.getText());

             tb_window.clear();
             tb_window.setPromptText(btn.getText());
             signalPressed = true;

             return;
         }  //o return acima encerra o metodo, portanto o código abaixo é equivalente a um "else"

         if (!signalPressed)
         {
             tb_window.setText (((Double.toString(calc.getNum1()))));
         }

         else {
             tb_window.setText(Double.toString(calc.calculate()));
             startCalc = true;
         }
     }

     @FXML
    private void clickExponential(ActionEvent event)
     {
         tb_window.clear();
         tb_window.setText(Double.toString(calc.getNum1()* calc.getNum1()));
         startCalc = true;
     }

    @FXML
    private void clickSquareRoot(ActionEvent event)
    {
        tb_window.clear();
        tb_window.setText(Double.toString(Math.sqrt(calc.getNum1())));
        startCalc = true;
    }

    @FXML
    private void clickOneDivNum(ActionEvent event)
    {
        tb_window.clear();
        tb_window.setText(Double.toString( 1 / (calc.getNum1())));
        startCalc = true;
    }

    @FXML
    private void clickInvertSignal(ActionEvent event)
    {
        tb_window.clear();

        if ( calc.getNum1() < 0)
        {
            String text = Double.toString(calc.getNum1());
            text.replaceAll("-","");
            tb_window.setText(text);
            calc.setNum1(Double.parseDouble(text));
        }

        tb_window.setText(Double.toString ( -1 * (calc.getNum1())));
        calc.setNum1(-1 * (calc.getNum1()));
        startCalc = true;
    }
}

