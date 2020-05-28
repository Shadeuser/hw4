package part2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;



public class CalcController {

    @FXML
    public TextField txtFieldResult;
    @FXML
    public Button btnDot;
    @FXML
    public Button btnDevision;
    @FXML
    public Button btnMult;
    @FXML
    public Button btnPlus;
    @FXML
    public Button btnMinus;
    @FXML
    public Button btnEqually;
    @FXML
    public TextField txtFieldTransactions;

    boolean afterResult = false;


    public void onActionNumbers(ActionEvent actionEvent) {
        if (afterResult) {
            txtFieldResult.clear();
            afterResult = false;
        }
        Button myButton = (Button) actionEvent.getTarget();
        String s = txtFieldResult.getText();
        if (myButton == btnDot) {
            //СДЕЛАТЬ УДАЛЕНИЕ ВСЕХ ТОЧЕК!!!
            if (s.length() == 0 || (s.length() > 0 && s.charAt(s.length() - 1) != '.')) {
                txtFieldResult.appendText(".");
            }
            return;

        }
        if (s.length() == 1 && s.charAt(s.length() - 1) == '0') {
            return;
        }

        txtFieldResult.appendText(myButton.getText().trim());
    }

    public void onActionOperations(ActionEvent actionEvent) {
        Button myButton = (Button) actionEvent.getTarget();
        String sResult = txtFieldResult.getText();


        String sign =  myButton.getText().trim(); //Знак операции(Плюс, минус и тд)
        if (!sign.equals("=")) {
            System.out.println(getResult(txtFieldTransactions.getText() + sResult));
            txtFieldResult.setText(getResult(txtFieldTransactions.getText() + sResult));
            txtFieldTransactions.appendText(sResult + sign);

        } else {
            txtFieldResult.setText(getResult(txtFieldTransactions.getText() + sResult));
            txtFieldTransactions.clear();
        }
        afterResult = true;



    }

    public String getResult(String inStr) {
        double result = 0.00;
        String newOper = "";

        char sign = ' ';
        char oldSign = ' ';

        for (int i = 0; i <= inStr.length() - 1; i++) {
            char cAt = inStr.charAt(i);
            boolean nextOper = false;
            if (cAt == '+' | cAt == '-' | cAt == '*' | cAt == '/') {
                oldSign = sign;
                sign = cAt;

                nextOper = true;

            } else {
                newOper += cAt;

            }
            if (i >= inStr.length() - 1) {
                oldSign = sign;
                nextOper = true;
            }

            if (nextOper) {
                if (oldSign == ('+')) {
                    result += Double.parseDouble(newOper);
                }
                if (oldSign == ('-')) {
                    result -= Double.parseDouble(newOper);
                }
                if (oldSign == ('*')) {
                    result *= Double.parseDouble(newOper);
                }
                if (oldSign == ('/')) {
                    result /= Double.parseDouble(newOper);
                }
                if (oldSign == ' ') {
                    result = Double.parseDouble(newOper);
                }
                newOper = "";

            }


        }

        return Double.toString(result);
    }

    public void onActionBtnC(ActionEvent actionEvent) {
        txtFieldTransactions.clear();
        txtFieldResult.clear();
    }

    public void onActionBackspace(ActionEvent actionEvent) {
        String s = txtFieldResult.getText();
        if (s.length()>0) {
            txtFieldResult.setText(s.substring(0, s.length()-1));
        }
    }
}
