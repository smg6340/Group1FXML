/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.List;//copied from the demo source code
import java.util.ResourceBundle;//copied from the demo source code
import java.util.Scanner;//copied from the demo source code
import javafx.collections.FXCollections;//copied from the demo source code
import javafx.collections.ObservableList;//copied from the demo source code
import javafx.event.ActionEvent;//copied from the demo source code
import javafx.fxml.FXML;//copied from the demo source code
import javafx.fxml.Initializable;//copied from the demo source code
import javafx.scene.control.Button;//copied from the demo source code
import javafx.scene.control.Label;//copied from the demo source code
import javax.persistence.EntityManager;//copied from the demo source code
import javax.persistence.Persistence;//copied from the demo source code
import javax.persistence.Query;//copied from the demo source code
import model.Studentx; 

/**
 *
 * @author lorul
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
        @FXML
    private Button buttonCreateStudent;

    @FXML
    private Button buttonRead;

    @FXML
    private Button buttonUpdate;

    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonReadStudentLastName;

    @FXML
    private Button buttonRead2;

    @FXML
    private Button buttonReadStudentID;

    @FXML
    void createStudent(ActionEvent event) {

    }

    @FXML
    void deleteStudent(ActionEvent event) {

    }


    @FXML
    void readStudent(ActionEvent event) {

    }

    @FXML
    void readStudent2(ActionEvent event) {

    }

    @FXML
    void readStudent3(ActionEvent event) {

    }

    @FXML
    void updateStudent(ActionEvent event) {

    }

    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    /*
The following code from lines 103 to lines 231 were copied from the demo source code, this is NOT my own work 
    */
    
    // Create operation
    public void create(Studentx studentx) {
        try {
            // begin transaction
            manager.getTransaction().begin();
            
            // sanity check
            if (student.getId() != null) {
                
                // create student
                manager.persist(studentx);
                
                // end transaction
                manager.getTransaction().commit();
                
                System.out.println(studentx.toString() + " is created");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    // Read Operations
    public List<Studentx> readAll(){
        Query query = manager.createNamedQuery("Studentx.findAll");
        List<Studentx> students = query.getResultList();

        for (Studentx s : students) {
            System.out.println(s.getstudentXID() + " " + s.getstudentxLastName() + " " + s.getStudentXFirstName() + " " + s.getStudentXEmail());
        }
        
        return students;
    }
    
    public Studentx readById(int id){
        Query query = manager.createNamedQuery("Student.findById");
        
        // setting query parameter
        query.setParameter("id", id);
        
        // execute query
        Studentx student = (Studentx) query.getSingleResult();
        if (student != null) {
            System.out.println(s.getstudentXID() + " " + s.getstudentxLastName() + " " + s.getStudentXFirstName() + " " + s.getStudentXEmail());
        }
        
        return student;
    }        
    
    public List<Studentx> readByName(String name){
        Query query = manager.createNamedQuery("Studentx.findByName");
        
        // setting query parameter
        query.setParameter("name", name);
        
        // execute query
        List<Studentx> students =  query.getResultList();
        for (Studentx studentx: students) {
            System.out.println(s.getstudentXID() + " " + s.getstudentxLastName() + " " + s.getStudentXFirstName() + " " + s.getStudentXEmail());
        }
        
        return students;
    }        
    
    public List<Studentx> readByNameAndCGPA(String name, double cpga){
        Query query = manager.createNamedQuery("Studentx.findByNameAndCgpa");
        
        // setting query parameter
        query.setParameter("studentXID", studentXID);
        query.setParameter("studentxLastName", studentxLastName);
        query.setParameter("getStudentXFirstName", getStudentXFirstName);
        query.setParameter("getStudentXEmail", getStudentXEmail);
        
        
        // execute query
        List<Studentx> students =  query.getResultList();
        for (Studentx student: students) {
            System.out.println(s.getstudentXID() + " " + s.getstudentxLastName() + " " + s.getStudentXFirstName() + " " + s.getStudentXEmail());
        }
        
        return students;
    }        
    
    
    // Update operation
    public void update(Studentx model) {
        try {

            Studentx existingStudent = manager.find(studentx.class, model.getId());

            if (existingStudent != null) {
                // begin transaction
                manager.getTransaction().begin();
                
                // update all atttributes
                existingStudent.setName(model.getStudentXLastName());
                existingStudent.setName(model.getStudentXFirstName());
                existingStudent.setName(model.getStudentXEmail());

                
                // end transaction
                manager.getTransaction().commit();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Delete operation
    public void delete(Studentx student) {
        try {
            Studentx existingStudent = manager.find(Studentx.class, Studentx.getstudentXID());

            // sanity check
            if (existingStudent != null) {
                
                // begin transaction
                manager.getTransaction().begin();
                
                //remove student
                manager.remove(existingStudent);
                
                // end transaction
                manager.getTransaction().commit();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
    
}
