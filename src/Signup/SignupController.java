/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Signup;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import landinformationsystem.Javaconnect;

/**
 * FXML Controller class
 *
 * @author Oluwaponmile
 */
public class SignupController implements Initializable {
Connection conn;
PreparedStatement pstmt;
ResultSet rs;
    @FXML
    private JFXTextField adminid;
    @FXML
    private JFXPasswordField admincode;
    @FXML
    private JFXButton loginButon;
    @FXML
    private Text status;
    @FXML
    private AnchorPane spalsh;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        conn = Javaconnect.ConnecrDB();
    }    

    @FXML
    private void submitAction(ActionEvent event) {
        
        String username = adminid.getText();
        String password = admincode.getText();
        
      
        String sql = "Insert into user (username,password) values (?,?)";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            pstmt.execute();
            status.setText("Account created successfully");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    private void backHome(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/landinformationsystem/Home.fxml"));
        Stage stage = new Stage(); 
        Scene scene = new Scene(root);
      
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        spalsh.getScene().getWindow().hide();
    }
    
    
    
    
}
