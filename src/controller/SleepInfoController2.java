package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Staff;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SleepInfoController2 implements Initializable {
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    

    @FXML
    private Text textChange;

    @FXML
    private TextField enterIdField;

    @FXML
    private TextField enterNameField;

    @FXML
    private TextField enterCourseField;

    @FXML
    private TextField enterAssignmentsField;

    @FXML
    private Button backButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button enterButton;
    
     @FXML
    private Button deleteButton;

    @FXML
    private Label deleteIDLabel;

    @FXML
    private TextField deleteIDField;
    
    @FXML
    private TextField enterOfficeHoursField;

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
    
        // ----------------------------------- below this line is stuff needed to make add when the enter button is pressed --------------------------------
    @FXML
    public void enter(ActionEvent event) {
        
      int id = Integer.parseInt(enterIdField.getText());
        
      String course = enterCourseField.getText();
        
      String lastname = enterNameField.getText();
        
      String assignments = enterAssignmentsField.getText();
      
      String officehours = enterOfficeHoursField.getText();
        
        // create a staff instance
        Staff staff = new Staff();
        
        // set properties
        staff.setId(id);
        staff.setCourse(course);
        staff.setLastname(lastname);
        staff.setAssignments(assignments);
        staff.setOfficehours(officehours);
        // save this staff to database by calling Create operation        
        create(staff);
        
       
    }
    
    @FXML
    void enterDelete(ActionEvent event) {
        
        int id = Integer.parseInt(deleteIDField.getText());
        
        Staff s = readById(id);
        System.out.println("we are deleting this staff member: "+ s.toString());
        delete(s);

    }

    @FXML
    void enterUpdate(ActionEvent event) {
      int id = Integer.parseInt(enterIdField.getText());
        
      String course = enterCourseField.getText();
        
      String lastname = enterNameField.getText();
        
      String assignments = enterAssignmentsField.getText();
      
      String officehours = enterOfficeHoursField.getText();
       
        // create a staff instance
        Staff staff = new Staff();
       
        // set properties
       staff.setId(id);
       staff.setCourse(course);
       staff.setLastname(lastname);
       staff.setAssignments(assignments);
       staff.setOfficehours(officehours);
      //  save this staff to database by calling Create operation        
        update(staff);
    }
 // -------------------------------------------------------------------------------------------------------------------------------------
   
    public void create(Staff staff) {
        try {
            // begin transaction
            manager.getTransaction().begin();
            
            // sanity check
            if (staff.getId() != null) {
                
                // create student
                manager.persist(staff);
                
                // end transaction
                manager.getTransaction().commit();
                
                System.out.println(staff.toString() + " is created");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void update(Staff model) {
        try {

            Staff existingStaff = manager.find(Staff.class, model.getId());

            if (existingStaff != null) {
                // begin transaction
                manager.getTransaction().begin();
                
                // update all atttributes
                existingStaff.setCourse(model.getCourse());
                existingStaff.setLastname(model.getLastname());
                existingStaff.setAssignments(model.getAssignments());
                existingStaff.setOfficehours(model.getOfficehours());
                // end transaction
                manager.getTransaction().commit();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
        public Staff readById(int id){
        Query query = manager.createNamedQuery("Staff.findById");
        
        // setting query parameter
        query.setParameter("id", id);
        
        // execute query
        Staff staff = (Staff) query.getSingleResult();
        if (staff != null) {
            System.out.println(staff.getId() + " " + staff.getLastname()+ " " + staff.getCourse() + " " + staff.getAssignments() + " " + staff.getOfficehours());
        }
        
        return staff;
    }
        
    public void delete(Staff staff) {
        try {
            Staff existingStaff = manager.find(Staff.class, staff.getId());

            // sanity check
            if (existingStaff != null) {
                
                // begin transaction
                manager.getTransaction().begin();
                
                //remove student
                manager.remove(existingStaff);
                
                // end transaction
                manager.getTransaction().commit();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void initData(Staff model) {
        selectedModel = model;
    }
    
    EntityManager manager;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        manager = (EntityManager) Persistence.createEntityManagerFactory("Group1FXMLPU").createEntityManager();
    }    
}
