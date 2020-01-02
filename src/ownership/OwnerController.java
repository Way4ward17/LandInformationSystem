/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ownership;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import landinformationsystem.Javaconnect;

/**
 * FXML Controller class
 *
 * @author Oluwaponmile
 */
public class OwnerController implements Initializable {
Connection conn;
PreparedStatement pstmt;
ResultSet rs;
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
    private TextField landid;
    @FXML
    private TextField permanentaddress;
    @FXML
    private TextField localgovernment;
    @FXML
    private TextField occupation;
    @FXML
    private TextField citizen;
    @FXML
    private DatePicker dob;
    @FXML
    private DatePicker datebought;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        conn = Javaconnect.ConnecrDB();
    }    

    @FXML
    private void searchMethod(ActionEvent event) {
    }

    @FXML
    private void submitMethod(ActionEvent event) {
   try{  
        String sql = "INSERT INTO `land`(`landaddress`, `landsize`, `name`, `phone`, `nok`, `dateofpurchase`, `parmanentaddress`, `localgovernment`, `dob`, `citizen`, `occupation`, `landid`) VALUES "
                + "(?,?,?,?,?,?,?,?,?,?,?,?)";
        
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,address.getText());
        pstmt.setString(2,size.getText());
        pstmt.setString(3,name.getText());
        pstmt.setString(4,phone.getText());
        pstmt.setString(5,nok.getText());
        pstmt.setString(6,((TextField) datebought.getEditor()).getText());
        pstmt.setString(7,permanentaddress.getText());
        pstmt.setString(8,localgovernment.getText());
        pstmt.setString(9,((TextField) dob.getEditor()).getText());
        pstmt.setString(10,citizen.getText());
        pstmt.setString(11,occupation.getText());
        pstmt.setString(12,landid.getText());
        pstmt.execute();
      }catch(Exception e){
          System.out.println(e);
      }
    }

    @FXML
    private void updateMethod(ActionEvent event) {
        
         try{
String sql = "UPDATE land SET landaddress ='"+address.getText()+"',landsize= '"+size.getText()+"' , name='"+name.getText()+"' , phone='"+phone.getText()+"', nok = '"+nok.getText()+"', dateofpurchase = '"+((TextField) datebought.getEditor()).getText()+"'"
        + ",parmanentaddress = '"+permanentaddress.getText()+"',localgovernment = '"+localgovernment.getText()+"',"
+ "dob = '"+((TextField) dob.getEditor()).getText()+"',citizen = '"+citizen.getText()+"',occupation = '"+occupation.getText()+"' WHERE landid ='"+landid.getText()+"' ";

                             
     pstmt = conn.prepareStatement(sql);
pstmt.executeUpdate();
status.setText(name.getText()+ "profile was update Successfully");

         }catch(Exception e){
             System.out.println(e);
         }
    }
    
}
