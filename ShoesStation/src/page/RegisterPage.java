package page;

import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import main.Main;
import page.LoginPage;

public class RegisterPage extends Application {

	private Scene registerPage;
	private Label titleLabel, unameLabel, passLabel, emailLabel, conPassLabel, genderLabel, ageLabel;
	private TextField unameTf, emailTf;
	private PasswordField passField, conPassField;
	private Button registerButton;
	private Hyperlink loginBack;
	private BorderPane borderPane;
	private GridPane gridPane;
	private Spinner<Integer> ageSpinner;
	private RadioButton maleRadio, femaleRadio;
	private ToggleGroup genderGroup;
	private FlowPane flowPane;
	
	Stage secondStage = new Stage();
	
	private void initRegister() {
		borderPane = new BorderPane();
		gridPane = new GridPane();
		flowPane = new FlowPane();	
				
		titleLabel = new Label("Shoes Station");
		unameLabel = new Label("Username");
		emailLabel = new Label("Email");
		passLabel = new Label("Password");
		conPassLabel = new Label("Confirm Password");
		genderLabel = new Label("Gender");
		ageLabel = new Label("Age");
		unameTf = new TextField();
		emailTf = new TextField();
		passField = new PasswordField();
		conPassField = new PasswordField();
		maleRadio = new RadioButton("Male");
		femaleRadio = new RadioButton("Female");
		ageSpinner = new Spinner<>(1,100,11);
		loginBack = new Hyperlink("Back to Login");
		registerButton = new Button("Register");
		genderGroup = new ToggleGroup();
		
		registerPage = new Scene(borderPane,650,550);
	}
	
	private void registerForm() {
		maleRadio.setToggleGroup(genderGroup);
		femaleRadio.setToggleGroup(genderGroup);
		
		SpinnerValueFactory<Integer> ageSpinnerValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,0);
		ageSpinner.setValueFactory(ageSpinnerValue);
		
		gridPane.add(titleLabel, 0,0,2,1);
        GridPane.setHalignment(titleLabel, HPos.CENTER);
        GridPane.setMargin(titleLabel, new Insets(20,0,10,0));
		
		gridPane.add(unameLabel,0,1);
		gridPane.add(unameTf,1,1);
		unameTf.setMaxWidth(300);
		
		gridPane.add(emailLabel,0,2);
		gridPane.add(emailTf,1,2);
		emailTf.setMaxWidth(300);
		
		gridPane.add(passLabel,0,3);
		gridPane.add(passField,1,3);
		passField.setMaxWidth(300);
		
		gridPane.add(conPassLabel,0,4);
		gridPane.add(conPassField,1,4);
		conPassField.setMaxWidth(300);
		
		flowPane.getChildren().add(maleRadio);
		flowPane.getChildren().add(femaleRadio);
		gridPane.add(genderLabel,0,5);
		gridPane.add(flowPane,1,5);
		flowPane.setHgap(10);
		
		gridPane.add(ageLabel,0,6);
		gridPane.add(ageSpinner,1,6);
		ageSpinner.setMaxWidth(75);
		
	    GridPane.setHalignment(registerButton, HPos.CENTER);
	    GridPane.setMargin(registerButton, new Insets(10,0,10,0));
		gridPane.add(registerButton,0,7,2,1);
		registerButton.setPrefSize(100,50);
		
		gridPane.setHgap(20);
		gridPane.setVgap(20);
		gridPane.setAlignment(Pos.CENTER);
		
		borderPane.setPadding(new Insets(0,20,0,50));
		
		borderPane.setTop(gridPane);
		borderPane.setAlignment(gridPane, Pos.CENTER);
		borderPane.setMargin(gridPane, new Insets(20,0,0,0));
		
		borderPane.setBottom(loginBack);
		borderPane.setAlignment(loginBack, Pos.CENTER);
		borderPane.setMargin(loginBack, new Insets(0,0,60,0));
		
	}
	
	private void registerValidation() {
		LoginPage loginPage = new LoginPage();
		Main main = new Main();
		
		registerButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (unameTf.getText().length() < 5 || unameTf.getText().length() > 20) {
					
					main.alert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Register Error!", "Username must be between 5-20 characters!");
					
					return;
				}
				
				if (passField.getText().length() < 5 || passField.getText().length() > 15) {
					main.alert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Register Error!", "Password must be between 5-15 characters!");
					
					return;
				}
				
				if (!conPassField.getText().equals(passField.getText())) {
					main.alert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Register Error!", "Confirm Password must be the same as Password!");
					
					return;
				}
				
				if (emailTf.getText().startsWith("@") || emailTf.getText().startsWith(".")) {
					main.alert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Register Error!", "Email must not start with @ and .");
					
					return;
				}
				
				if (emailTf.getText().endsWith("@") || emailTf.getText().endsWith(".")) {
					main.alert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Register Error!", "Email must not end with @ and .!");
					
					return;
				}
				
//				if (emailTf.getText().contains("@{2}")) {
//					main.alert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Register Error!", "Email must contain exactly one @!");
//					
//					return;
//				}
//				
//				if (!emailTf.getText().contains("@.{1}") || !emailTf.getText().contains(".@{1}")) {
//					main.alert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Register Error!", "Character @ must not be next to . on the email!");
//				}
				
			if (genderGroup.getSelectedToggle() == null) {
					main.alert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Register Error!", "Gender must be selected either Male or Female!");
					
					return;
				}
			
			if (!genderGroup.getSelectedToggle().equals(maleRadio) && !genderGroup.getSelectedToggle().equals(femaleRadio)) {
				main.alert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Register Error!", "Gender must be selected either Male or Female!");
				
				return;
			}
				
//				if (ageSpinner.getValue()) {
//					main.alert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Register Error!", "Age must be choosen between 11 and 100!");
//					
//					return;
//				}
				
				main.alert(Alert.AlertType.INFORMATION, gridPane.getScene().getWindow(), "Registration Successful!", "Welcome" + unameTf.getText());
				
				try {
					
					loginPage.start(secondStage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	
	private void registerPage() {
		initRegister();
		registerForm();
		registerValidation();
	}
	
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		LoginPage loginPage = new LoginPage();
		
		secondStage = primaryStage;
		
		registerPage();
		
		
		loginBack.setOnAction(e -> {
			
			try {	
				loginPage.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		});
		
		primaryStage.setTitle("Shoes Station");
		primaryStage.setScene(registerPage);
		primaryStage.setResizable(false);
		primaryStage.show();
		
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				
				alert.setContentText("Are you sure want to exit?");
				Optional<ButtonType> result = alert.showAndWait();
				
				if (result.get() == ButtonType.CANCEL) {
					event.consume();
				}
			}
		});
		
	}

}
