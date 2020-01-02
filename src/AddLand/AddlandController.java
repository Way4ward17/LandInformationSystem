/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddLand;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import landinformationsystem.Javaconnect;

/**
 * FXML Controller class
 *
 * @author Oluwaponmile
 */
public class AddlandController implements Initializable {

    @FXML
    private TextField a;
    @FXML
    private TextField a1;
    @FXML
    private TextField a2;
    @FXML
    private TextField a21;
    @FXML
    private TextField a211;
    @FXML
    private TextField a212;
    @FXML
    private TextField a213;
    @FXML
    private TextField a2131;
    @FXML
    private TextField a2132;
    @FXML
    private TextField a2133;
    @FXML
    private TextField a21331;
    @FXML
    private TextField a213311;
    @FXML
    private TextField a213312;
    @FXML
    private TextField a2133121;
    @FXML
    private TextField a2133122;
    @FXML
    private TextField a2133123;
    @FXML
    private TextField a21331231;
    @FXML
    private TextField a21331232;
    @FXML
    private TextField a21331233;
    @FXML
    private TextField a213312331;
    @FXML
    private TextField a213312332;
    @FXML
    private TextField a213312333;
    @FXML
    private TextField a213312334;
    @FXML
    private TextField a2133123341;
    @FXML
    private TextField a2133123342;
    @FXML
    private TextField a21331233421;
    @FXML
    private TextField a213312334211;
    @FXML
    private DatePicker date;
    @FXML
    private TextField a213312334212;
    @FXML
    private TextField a2133123342121;
    @FXML
    private TextField a21331233421211;
    @FXML
    private TextField a21331233421212;

    
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
    @FXML
    private Text status;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO]\
        conn = Javaconnect.ConnecrDB();
    }    
    
    
    private void insert(){
      try{
        String sql = "INSERT INTO `search`(`guarantorname`, `gurantoraddress`, `guarantoroccupation`, `guaranteename`, `guaranteeaddress`, `guaranteeoccupation`, `location`, `conductedby`, `name`, `address`, `phone`, `sizeofproperty`, `surveypillar`, `plannumber`, `nameandaddress`, `natureofgrant`, `lengthofgrant`, `fromm`, `dateregistered`, `registrationparticular`, `indexnumber`, `sheetnumber`, `filenumber`, `anyecumbrances`, `wheresearchconducted`, `reportpresented`, `designation`, `dateofresearch`, `receiptnumber`, `registraroftitle`, `signature`, `reportcollectedby`) VALUES "
                + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, a.getText());
        pstmt.setString(2, a1.getText());
        pstmt.setString(3, a2.getText());
        pstmt.setString(4, a21.getText());
        pstmt.setString(5, a211 .getText());
        pstmt.setString(6, a212.getText());
        pstmt.setString(7, a213.getText());
        pstmt.setString(8, a2131.getText());
        pstmt.setString(9, a2132.getText());
        pstmt.setString(10, a2133.getText());
        pstmt.setString(11, a21331.getText());
        pstmt.setString(12, a213311.getText());
        pstmt.setString(13, a213312.getText());
        pstmt.setString(14, a2133121.getText());
        pstmt.setString(15, a2133122.getText());
        pstmt.setString(16, a2133123.getText());
        pstmt.setString(17, a21331231.getText()); 
        pstmt.setString(18, a21331232.getText());
        pstmt.setString(19, a21331233.getText());
        pstmt.setString(20, a213312331.getText());
        pstmt.setString(21, a213312332.getText());
        pstmt.setString(22, a213312333.getText());
        pstmt.setString(23, a213312334.getText());
        pstmt.setString(24, a2133123341.getText());
        pstmt.setString(25, a2133123342.getText());
        pstmt.setString(26, a21331233421.getText());
        pstmt.setString(27, a213312334211.getText());
        pstmt.setString(28,((TextField) date.getEditor()).getText());
        pstmt.setString(29, a213312334212.getText());
        pstmt.setString(30, a2133123342121.getText());
        pstmt.setString(31, a21331233421211.getText());
        pstmt.setString(32, a21331233421212.getText());
        pstmt.execute(); 
        status.setText("Data Saved Successfully");
      }catch(Exception e){
          System.out.println(e);
      }
    }
}
