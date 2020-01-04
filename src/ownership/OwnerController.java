/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ownership;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
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
    @FXML
    private Text status;
    @FXML
    private TextField landidsearch;
    @FXML
    private TextField code;
    @FXML
    private JFXButton codee;
    /**
     * Initializes the controller class.
     */
    String otp;
    @FXML
    private JFXButton sendOT;
    @FXML
    private JFXButton save;
    @FXML
    private JFXButton update;
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        conn = Javaconnect.ConnecrDB();
        landid.setText(Random());
        code.setVisible(false);
        codee.setVisible(false);
        sendOT.setVisible(false);
        save.setVisible(false);
        update.setVisible(false);
    }    

 private String Random1(){
        Random rd = new Random();
       String t = ("LAND_"+rd.nextInt(99999999 + 1));
       return t;
    }
    @FXML
    private void searchMethod(ActionEvent event) {
        try{
            String sql = "select * from land where landid = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, landidsearch.getText());
            rs = pstmt.executeQuery();
            if(rs.next()){
                phone.setText(rs.getString(4));
                code.setVisible(true);
                codee.setVisible(true);
                otp = Random1(); 
                System.out.println(otp);
                
          try{
            String sql1 = "insert into code (phonenumber, code) values (?,?)";
            pstmt = conn.prepareStatement(sql1);
            pstmt.setString(1, phone.getText());
            pstmt.setString(2, otp );
            pstmt.execute();
                phone.setText(rs.getString(4));
                landid.setText(rs.getString(12));
                code.setVisible(true);
                codee.setVisible(true);
                sendOT.setVisible(true);
                
                
                
             }catch(Exception e){
            System.out.println(e);
        }
                
            }
        }catch(Exception e){
            System.out.println(e);
        }
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
        status.setText(name.getText()+  " profile was created Successfully");
      }catch(Exception e){
          System.out.println(e);
      }
    }
 private String Random(){
        Random rd = new Random();
       String t = ("LAND_ID"+rd.nextInt(99999999 + 1));
       return t;
    }
    @FXML
    private void updateMethod(ActionEvent event) {
        
         try{
String sql = "UPDATE land SET landaddress ='"+address.getText()+"',landsize= '"+size.getText()+"' , name='"+name.getText()+"' , phone='"+phone.getText()+"', nok = '"+nok.getText()+"', dateofpurchase = '"+((TextField) datebought.getEditor()).getText()+"'"
        + ",parmanentaddress = '"+permanentaddress.getText()+"',localgovernment = '"+localgovernment.getText()+"',"
+ "dob = '"+((TextField) dob.getEditor()).getText()+"',citizen = '"+citizen.getText()+"',occupation = '"+occupation.getText()+"' WHERE landid ='"+landidsearch.getText()+"' ";

                             
     pstmt = conn.prepareStatement(sql);
pstmt.executeUpdate();
status.setText(name.getText()+ "profile was update Successfully");

         }catch(Exception e){
             System.out.println(e);
         }
    }

    
      private void sendMessage(String rec, String message) throws MalformedURLException, IOException{
      URL a = new URL("https://www.smsmobile24.com/index.php?option=com_spc&comm=spc_api&username=Encrypt_File&password=ponmile23&sender=EKITI_Land&recipient="+rec+"&message="+URLEncoder.encode(message, "UTF-8")+"");
        
        URLConnection connect = a.openConnection();
        try(InputStream is = connect.getInputStream()){}
    }
    
    
    @FXML
    private void searchMethod2(ActionEvent event) { 
        
         try{
            String sql = "select * from code where phonenumber = ? AND code = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, phone.getText());
            pstmt.setString(2, code.getText());
            rs = pstmt.executeQuery();
            if(rs.next()){
                
                try{
                String sqll = "select * from land where landid = ?";
                pstmt = conn.prepareStatement(sqll);
                pstmt.setString(1, landidsearch.getText());
                rs = pstmt.executeQuery();
                
                if(rs.next()){
                address.setText(rs.getString(1));
                size.setText(rs.getString(2));
                name.setText(rs.getString(3));
                phone.setText(rs.getString(4));
                nok.setText(rs.getString(5));
                ((TextField) datebought.getEditor()).setText(rs.getString(6));
                permanentaddress.setText(rs.getString(7));
                localgovernment.setText(rs.getString(8));
                ((TextField) dob.getEditor()).setText(rs.getString(9));
                citizen.setText(rs.getString(10));
                occupation.setText(rs.getString(11));
                landid.setText(rs.getString(12));
                
                }       
                save.setVisible(true);
                update.setVisible(true);
                
                }catch(Exception e){
                System.out.println(e);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    private void sendOTP(ActionEvent event) {
    try {           
        System.out.println(otp);
        sendMessage(phone.getText(),otp);
    } catch (IOException ex) {
        System.out.println("Network Failure");
        //Logger.getLogger(OwnerController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
}
