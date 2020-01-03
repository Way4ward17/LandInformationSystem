/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package landinformationsystem;

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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Way4ward
 */
public class HomeController implements Initializable {
    
    private Label label;
    @FXML
    private JFXTextField adminid;
    @FXML
    private JFXPasswordField admincode;
    @FXML
    private JFXButton loginButon;
    @FXML
    private JFXButton loginButon1;
    @FXML
    private AnchorPane spalsh;
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
    @FXML
    private Text status;
 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = Javaconnect.ConnecrDB();
        // TODO
    }    

    @FXML
    private void loginMethod(ActionEvent event) {
        String sql = "select * from user where username=? AND password=?";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adminid.getText());
            pstmt.setString(2, admincode.getText());
            rs = pstmt.executeQuery();
            if(rs.next()){
          Parent root = FXMLLoader.load(getClass().getResource("/Home/addland.fxml"));
         Stage stage = new Stage(); 
        Scene scene = new Scene(root);
      
      //  stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        spalsh.getScene().getWindow().hide();
            }else{
               status.setText("Invalid username or password");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    private void registerMethod(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("/Signup/Signup.fxml"));
         Stage stage = new Stage(); 
        Scene scene = new Scene(root);
      
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        spalsh.getScene().getWindow().hide();
    }
    
}
