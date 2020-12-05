package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Staff;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

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
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
