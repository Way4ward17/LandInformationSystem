/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourland;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Way4ward Adefuwa
 */
public class YourlandController implements Initializable {

    @FXML
    private TextField address;
    @FXML
    private TextField size;
    @FXML
    private TextField name;
    @FXML
    private TextField phone;
    @FXML
    private TextField nok;
    @FXML
    private TextField landidsearch;
    @FXML
    private TextField permanentaddress;
    @FXML
    private TextField localgovernment;
    @FXML
    private TextField landid;
    @FXML
    private TextField occupation;
    @FXML
    private TextField citizen;
    @FXML
    private DatePicker dob;
    @FXML
    private JFXButton save;
    @FXML
    private JFXButton update;
    @FXML
    private DatePicker datebought;
    @FXML
    private Text status;
    @FXML
    private TextField code;
    @FXML
    private JFXButton codee;
    @FXML
    private JFXButton sendOT;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void searchMethod(ActionEvent event) {
    }

    @FXML
    private void submitMethod(ActionEvent event) {
    }

    @FXML
    private void updateMethod(ActionEvent event) {
    }

    @FXML
    private void searchMethod2(ActionEvent event) {
    }

    @FXML
    private void sendOTP(ActionEvent event) {
    }
    
}
