package part1;

import com.sun.media.jfxmediaimpl.platform.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;

public class Controller {
    @FXML
    public TextArea txtArea;
    @FXML
    public TextField txtField;



    public void btnAddOnAction() {
        txtArea.appendText(txtField.getText()+"\n");
        txtField.clear();

    }

    public void txtFieldOnKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode()== KeyCode.ENTER) {
            btnAddOnAction();
        }
    }

}
