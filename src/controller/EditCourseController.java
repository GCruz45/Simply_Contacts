package controller;

/**
 * Sample Skeleton for 'EditContact.fxml' Controller Class
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Agenda;
import model.Course;

public class EditCourseController {

    private Stage stage;


    private Course course;
    private Agenda agenda;
    private MainScreenController mainController;

    @FXML // fx:id="courseNameLabel"
            Label courseNameLabel; // Value injected by FXMLLoader

    @FXML // fx:id="nameTF"
    private TextField nameTF; // Value injected by FXMLLoader

    @FXML // fx:id="creditsTF"
    private TextField creditsTF; // Value injected by FXMLLoader

    @FXML // fx:id="nrcTF"
    private TextField nrcTF; // Value injected by FXMLLoader

    @FXML
    private TextArea descriptionTA;

    @FXML
    void initialize() {
        course = null;
    }

    @FXML
    void returnToMainScreen(ActionEvent e) {
        final Node source = (Node) e.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void saveCourse(ActionEvent e) {
        Course courseToAdd = new Course(nameTF.getText(), creditsTF.getText(), nrcTF.getText(), descriptionTA.getText());

        if (course == null)
            agenda.getCourses().add(courseToAdd);
        else
            agenda.getCourses().set(agenda.getCourses().indexOf(course), courseToAdd);

        returnToMainScreen(e);
        mainController.loadStudent();
    }

    public void setup(MainScreenController mainController) {
        this.mainController = mainController;
        if (course != null) {
            nameTF.setText(course.getName());
            creditsTF.setText(String.valueOf(course.getCredits()));
            nrcTF.setText(String.valueOf(course.getNRC()));
            descriptionTA.setText(course.getDescription());
        }

    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
