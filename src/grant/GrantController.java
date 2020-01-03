/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grant;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import landinformationsystem.Javaconnect;
import landinformationsystem.dialogbox;

/**
 * FXML Controller class
 *
 * @author Oluwaponmile
 */
public class GrantController implements Initializable {
    
    
    
     ObservableList<String> C = FXCollections.observableArrayList("High Density 18m * 30m","Medium Density 30m * 30m","Low Density 30m * 30m");
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
    private ComboBox<String> sizeofland;
    /**
     * Initializes the controller class.
     */
    
    String path = System.getProperty("user.home");
private Image image;
private File file;
private File CopyFile;
dialogbox dialog = new dialogbox();
    @FXML
    private ImageView imageView;
    @FXML
    private StackPane stick;
    @FXML
    private TextField ref;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        sizeofland.setItems(C);
        conn = Javaconnect.ConnecrDB();
        stick.setVisible(false);
    
    }    
    
    
    
     @FXML
    private void update(){
        if(yes.isSelected()){
            application = "yes";
        }else{
            application = "no";
        }
        try{
        String sql = "update `act` set `nameoftown` = ?, `nameofapplicant`= ?, `age`= ?, `dob`= ?, `hometown`= ?, `lga`= ?, `soo`= ?, `postaladdress`= ?, `permanentaddress`= ?, `phonenumber`= ?, `occupationofapplicant`= ?, `registrationparticulars`= ?,`isthisapplication`=?, `statewhether`= ?, `statetheexact`= ?, `statetheterm`= ?, `approximate`= ?, `evidenceofpropose`= ?, `statewhetherpro`= ?, `haveyouever`= ?, `ifyes`= ?, `image`= ? "
                + "where ref = '"+ref.getText()+"' ";
        
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
        pstmt.setString(22,copyImage());
       
        pstmt.executeUpdate();
        dialog.msg(stick, "update", "Data saved successfully");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    private void insert(){
        if(yes.isSelected()){
            application = "yes";
        }else{
            application = "no";
        }
        try{
        String sql = "INSERT INTO `act`(`nameoftown`, `nameofapplicant`, `age`, `dob`, `hometown`, `lga`, `soo`, `postaladdress`, `permanentaddress`, `phonenumber`, `occupationofapplicant`, `registrationparticulars`,`isthisapplication`, `statewhether`, `statetheexact`, `statetheterm`, `approximate`, `evidenceofpropose`, `statewhetherpro`, `haveyouever`, `ifyes`, `image`) VALUES"
                + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
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
        pstmt.setString(22,copyImage());
        pstmt.execute();
        dialog.msg(stick, "Success", "Data saved successfully");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    private void submit(ActionEvent event) {
        insert();
    }
    
    
     private String copyImage() {
        if (file != null) {
            
            CopyFile = new File(path + "\\Documents\\Land\\"  + file.getName());
        } else {
            return null;
        }
        System.out.println(CopyFile.getPath());
        try {
            Files.copy(Paths.get(file.getPath()), Paths.get(CopyFile.getPath()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(GrantController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return CopyFile.getName();

    }
 
  private void upload() {
        FileChooser filechooser = new FileChooser();
  //  filechooser = new FileChooser();
        filechooser.getExtensionFilters().addAll(
         new FileChooser.ExtensionFilter("images","*.jpg","*.png"),
                  new FileChooser.ExtensionFilter("Text files","*.txt"));
     file = filechooser.showOpenDialog(null);
 if(file != null){
   //  JOptionPane.showMessageDialog(null, ""+ file.getAbsolutePath());
     image  = new Image(file.getAbsoluteFile().toURI().toString());
     imageView.setImage(image);     
 }  
}

    @FXML
    private void openImage(MouseEvent event) {
        upload();
    }


    @FXML
    private void fetch(ActionEvent event) {
        
        try{
            String sql = "select * from act where ref = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ref.getText());
            rs = pstmt.executeQuery();
            if(rs.next()){
        a.setText(rs.getString(1));
        b.setText(rs.getString(2));
        d.setText(rs.getString(3));
        ((TextField) c.getEditor()).setText(rs.getString(4));
        e.setText(rs.getString(5));
        g.setText(rs.getString(6));
        g1.setText(rs.getString(7));
        g11.setText(rs.getString(8));
        g111.setText(rs.getString(9));
        g1111.setText(rs.getString(10));
        g1112.setText(rs.getString(11));
        g11121.setText(rs.getString(12));
        g1112111.setText(rs.getString(13));
        application = rs.getString(14);
        if(application == "yes"){
            yes.setSelected(true);
            no.setSelected(false);
        }else{
            no.setSelected(true);
            yes.setSelected(false);
        }
        g11121111.setText(rs.getString(15));
        g111211111.setText(rs.getString(16));
        sizeofland.setValue(rs.getString(17));
        g11121111111.setText(rs.getString(18));
        g111211111111.setText(rs.getString(19));
        g1112111111111.setText(rs.getString(20));
        g11121111111111.setText(rs.getString(21));

            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
