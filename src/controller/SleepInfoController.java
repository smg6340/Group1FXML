/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Staff;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
/**
 * FXML Controller class
 *
 * @author ljp5342
 */
public class SleepInfoController implements Initializable {
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;





    @FXML
    void backToMain(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        //  option 2: get current stage -- from backbutton        
        // Stage stage = (Stage)backButton.getScene().getWindow();
        
        if (previousScene != null) {
            stage.setScene(previousScene);
        }
    }
    
    Staff selectedModel;
    Scene previousScene;
    
    public void setPreviousScene(Scene scene) {
        previousScene = scene;
        //backToMainButton.setDisable(false);

    }
    
    public void initData(Staff model) {
        selectedModel = model;
        //staffIdLabel.setText(model.getId().toString());
        //staffLastnameLabel.setText(model.getLastname());

    //    try {
            // path points to /resource/images/
    //        String imagename = "/resource/images/" + model.getLastname() + ".png";
    //        Image profile = new Image(getClass().getResourceAsStream(imagename));
            //profileImage.setImage(profile);

    //    } catch (Exception ex) {
    //        System.out.println(ex.getMessage());
    //    }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //backToMainButton.setDisable(true);
    }    
    
}
