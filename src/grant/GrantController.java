/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grant;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import landinformationsystem.Javaconnect;

/**
 * FXML Controller class
 *
 * @author Oluwaponmile
 */
public class GrantController implements Initializable {
String application;
    @FXML
    private TextField a;
    @FXML
    private TextField b;
    @FXML
    private TextField d;
    @FXML
    private TextField e;
    @FXML
    private TextField g;
    @FXML
    private TextField g1;
    @FXML
    private TextField g11;
    @FXML
    private TextField g111;
    @FXML
    private TextField g1111;
    @FXML
    private TextField g1112;
    @FXML
    private TextField g11121;
    @FXML
    private TextField g1112111;
    @FXML
    private TextField g11121111;
    @FXML
    private TextField g111211111;
    @FXML
    private TextField g11121111111;
    @FXML
    private TextField g111211111111;
    @FXML
    private TextField g1112111111111;
    @FXML
    private TextField g11121111111111;
Connection conn;
PreparedStatement pstmt;
ResultSet rs;
    @FXML
    private DatePicker c;
    @FXML
    private RadioButton yes;
    @FXML
    private ToggleGroup ddd;
    @FXML
    private RadioButton no;
    @FXML
    private ComboBox<?> sizeofland;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conn = Javaconnect.ConnecrDB();
        if(yes.isSelected()){
            application = "yes";
        }else{
            application = "no";
        }
    }    
    
    
    
    
    private void insert(){
        
        try{
        String sql = "INSERT INTO `act`(`nameoftown`, `nameofapplicant`, `age`, `dob`, `hometown`, `lga`, `soo`, `postaladdress`, `permanentaddress`, `phonenumber`, `occupationofapplicant`, `registrationparticulars`,`isthisapplication`, `statewhether`, `statetheexact`, `statetheterm`, `approximate`, `evidenceofpropose`, `statewhetherpro`, `haveyouever`, `ifyes`) VALUES"
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
        
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,a.getText());
        pstmt.setString(2,b.getText());
        pstmt.setString(3,d.getText());
        pstmt.setString(4,((TextField) c.getEditor()).getText());
        pstmt.setString(5,e.getText());
        pstmt.setString(6,g.getText());
        pstmt.setString(7,g1.getText());
        pstmt.setString(8,g11.getText());
        pstmt.setString(9,g111.getText());
        pstmt.setString(10,g1111.getText());
        pstmt.setString(11,g1112.getText());
        pstmt.setString(12,g11121.getText());
        pstmt.setString(13,g1112111.getText());
        pstmt.setString(14, application);
        pstmt.setString(15,g11121111.getText());
        pstmt.setString(16,g111211111.getText());
        pstmt.setString(17,(String)sizeofland.getSelectionModel().getSelectedItem());
        pstmt.setString(18,g11121111111.getText());
        pstmt.setString(19,g111211111111.getText());
        pstmt.setString(20,g1112111111111.getText());
        pstmt.setString(21,g11121111111111.getText());
        pstmt.execute();
        
        }catch(Exception e){
            
        }
    }

    @FXML
    private void submit(ActionEvent event) {
        insert();
    }
    
}
