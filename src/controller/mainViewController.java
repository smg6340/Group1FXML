package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Staff;

public class mainViewController implements Initializable {

    @FXML
    private Label titleLabel;

    @FXML
    private Button createButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button showDetailsInPlaceButton;

    @FXML
    private Label searchLabel;

    @FXML
    private TextField searchTextField;

    @FXML
    private Button searchAdvancedButton;

    @FXML
    private TableView<Staff> staffTable;

    @FXML
    private TableColumn<Staff, String> staffLastname;
    
    @FXML
    private TableColumn<Staff, Integer> staffId;

    @FXML
    private TableColumn<Staff, String> staffCourse;

    @FXML
    private TableColumn<Staff, String> staffAssignments;
    
    @FXML
    private Button sleepSuggestionsButton;
    
    
    private ObservableList<Staff> staffData;
        
    public void setTableData(List<Staff> staffList) {

        // initialize the staffData variable
        staffData = FXCollections.observableArrayList();

        // add the staff objects to an observable list object for use with the GUI table
        staffList.forEach(s -> {
            staffData.add(s);
        });

        // set the the table items to the data in studentData; refresh the table
        staffTable.setItems(staffData);
        staffTable.refresh();
    }

    @FXML
    public void createEntry(ActionEvent event) throws IOException {
        Staff selectedStaff = staffTable.getSelectionModel().getSelectedItem();

        
        //  ---------------------------------- This block will load the enter info window (also add the part that says throws excption above) ----------------------------------
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/sleepInfo2.fxml"));
        // load the ui elements
        Parent sleepInfo2 = loader.load();
        // load the scene
        Scene tableViewScene = new Scene(sleepInfo2);
        //access the detailedControlled and call a method
        SleepInfoController2 sleepControlled2 = loader.getController();
        sleepControlled2.initData(selectedStaff);
        // pass current scene to return
        Scene currentScene = ((Node) event.getSource()).getScene();
        sleepControlled2.setPreviousScene(currentScene);
        //This line gets the Stage information
        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(tableViewScene);
        stage.show();
        //  ---------------------------------- This is the end of the block that will load the enter info window ----------------------------------
        
        

        System.out.println("taking you to next page");
    }

    @FXML
    void deleteEntry(ActionEvent event) throws IOException {
        Staff selectedStaff = staffTable.getSelectionModel().getSelectedItem();

        
        //  ---------------------------------- This block will load the enter info window (also add the part that says throws excption above) ----------------------------------
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/sleepInfo2.fxml"));
        // load the ui elements
        Parent sleepInfo2 = loader.load();
        // load the scene
        Scene tableViewScene = new Scene(sleepInfo2);
        //access the detailedControlled and call a method
        SleepInfoController2 sleepControlled2 = loader.getController();
        sleepControlled2.initData(selectedStaff);
        // pass current scene to return
        Scene currentScene = ((Node) event.getSource()).getScene();
        sleepControlled2.setPreviousScene(currentScene);
        //This line gets the Stage information
        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(tableViewScene);
        stage.show();
   
    }
    
    
        @FXML
    void updateEntry(ActionEvent event) throws IOException {
        Staff selectedStaff = staffTable.getSelectionModel().getSelectedItem();

        
        //  ---------------------------------- This block will load the enter info window (also add the part that says throws excption above) ----------------------------------
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/sleepInfo2.fxml"));
        // load the ui elements
        Parent sleepInfo2 = loader.load();
        // load the scene
        Scene tableViewScene = new Scene(sleepInfo2);
        //access the detailedControlled and call a method
        SleepInfoController2 sleepControlled2 = loader.getController();
        sleepControlled2.initData(selectedStaff);
        // pass current scene to return
        Scene currentScene = ((Node) event.getSource()).getScene();
        sleepControlled2.setPreviousScene(currentScene);
        //This line gets the Stage information
        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(tableViewScene);
        stage.show();
       
    }
        

    @FXML
    void searchAdvanced(ActionEvent event) {
        String lastname = searchTextField.getText();

        // calling a db read operation, readByNameAdvanced
        List<Staff> allStaff = readByNameAdvanced(lastname);

        // setting table data
        //setTableData(allStaff);
        // add an alert
        if (allStaff == null || allStaff.isEmpty()) {

            // show an alert to inform user 
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog Box");// line 2
            alert.setHeaderText("ERROR");// line 3
            alert.setContentText("No staff member matches that query");// line 4
            alert.showAndWait(); // line 5
        } else {
            // setting table data
            setTableData(allStaff);
        }
    }

        
    @FXML
    void sleepSuggestions(ActionEvent event) throws IOException {
        Staff selectedStaff = staffTable.getSelectionModel().getSelectedItem();

        
        // fxml loader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/sleepInfo.fxml"));
        // load the ui elements
        Parent sleepInfo = loader.load();
        // load the scene
        Scene tableViewScene = new Scene(sleepInfo);
        //access the detailedControlled and call a method
        SleepInfoController sleepControlled = loader.getController();
        sleepControlled.initData(selectedStaff);
        // pass current scene to return
        Scene currentScene = ((Node) event.getSource()).getScene();
        sleepControlled.setPreviousScene(currentScene);
        //This line gets the Stage information
        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(tableViewScene);
        stage.show();
    }
    
    @FXML
    void showDetailsInPlace(ActionEvent event) throws IOException {
        Staff selectedStaff = staffTable.getSelectionModel().getSelectedItem();

        
        // fxml loader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DetailedModelView.fxml"));

        // load the ui elements
        Parent detailedModelView = loader.load();

        // load the scene
        Scene tableViewScene = new Scene(detailedModelView);

        //access the detailedControlled and call a method
        DetailedModelViewController detailedControlled = loader.getController();


        detailedControlled.initData(selectedStaff);

        // pass current scene to return
        Scene currentScene = ((Node) event.getSource()).getScene();
        detailedControlled.setPreviousScene(currentScene);

        //This line gets the Stage information
        Stage stage = (Stage) currentScene.getWindow();

        stage.setScene(tableViewScene);
        stage.show();
    }

    public List<Staff> readByNameAdvanced(String lastname) {
        Query query = manager.createNamedQuery("Staff.findByNameAdvanced");

        // setting query parameter
        query.setParameter("lastname", lastname);

        // execute query
        List<Staff> allStaff = query.getResultList();
        for (Staff staff : allStaff) {
            System.out.println(staff.getId() + " " + staff.getLastname()+ " " + staff.getCourse() + " " + staff.getAssignments());
        }

        return allStaff;
    }    
    EntityManager manager;

    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        manager = (EntityManager) Persistence.createEntityManagerFactory("Group1FXMLPU").createEntityManager();
        
        staffLastname.setCellValueFactory(new PropertyValueFactory<>("Lastname"));
        staffId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        staffCourse.setCellValueFactory(new PropertyValueFactory<>("Course"));
        staffAssignments.setCellValueFactory(new PropertyValueFactory<>("Assignments"));

        staffTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    } 
}
