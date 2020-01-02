/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Way4ward
 */
public class AddlandController implements Initializable {

    @FXML
    private AnchorPane splashAnchor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void searchland(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AddLand/addland.fxml"));
        Stage stage  = new Stage(); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Search Form");
        stage.show();
    }

    @FXML
    private void addland(ActionEvent event) {
    }

    @FXML
    private void grantform(ActionEvent event) {
    }

    @FXML
    private void exit(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/landinformationsystem/Home.fxml"));
        Stage stage  = new Stage(); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Home");
        stage.show();
        splashAnchor.getScene().getWindow().hide();
    }
    
}
