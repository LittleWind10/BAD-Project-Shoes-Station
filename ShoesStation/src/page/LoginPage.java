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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import main.Main;
import page.RegisterPage;
import page.SelectRolePage;

public class LoginPage extends Application {
	
	private Scene loginPage;
	private Label titleLabel, unameLabel, passLabel;
	private TextField unameTf;
	private PasswordField passField;
	private Button loginButton;
	private Hyperlink registerLink;
	private BorderPane borderPane;
	private GridPane gridPane;
	
	Stage secondStage = new Stage();

	private void initLogin() {
		borderPane = new BorderPane();
		gridPane = new GridPane();
		
		unameTf = new TextField();
		passField = new PasswordField();
		titleLabel = new Label("Shoes Station");
		unameLabel = new Label("Username");
		passLabel = new Label("Password");
		loginButton = new Button("Login");
		registerLink = new Hyperlink("Register Here");
		
		loginPage = new Scene(borderPane, 500,500);
	}
	
	private void loginForm() {
		gridPane.add(unameLabel, 0, 0);
		gridPane.add(unameTf, 1, 0);
		
		gridPane.add(passLabel, 0, 1);
		gridPane.add(passField, 1, 1);
		
	    GridPane.setHalignment(loginButton, HPos.CENTER);
	    GridPane.setMargin(loginButton, new Insets(10,0,10,0));
		gridPane.add(loginButton, 0, 2, 2, 1);
		loginButton.setPrefSize(100, 50);
//		loginButton.setDefaultButton(true);
		
		gridPane.setHgap(20);
		gridPane.setVgap(20);
		gridPane.setAlignment(Pos.CENTER);
		
		borderPane.setTop(titleLabel);
		borderPane.setAlignment(titleLabel, Pos.CENTER);
		borderPane.setMargin(titleLabel, new Insets(30,0,100,0));
		
		borderPane.setCenter(gridPane);
		borderPane.setAlignment(gridPane, Pos.CENTER);
		
		borderPane.setBottom(registerLink);
		borderPane.setAlignment(registerLink, Pos.CENTER);
		borderPane.setMargin(registerLink, new Insets(0,0,125,0));
	}
	
	private void loginValidation() {
		Main main = new Main();
		SelectRolePage rolePage = new SelectRolePage();
		
		loginButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				if(unameTf.getText().isEmpty()) {
					main.alert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Login Error!", "Please enter your username!");
                    return;
                }
                if(passField.getText().isEmpty()) {
                	main.alert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Login Error!", "Please enter your password!");
                    return;
				
                }
                main.alert(Alert.AlertType.INFORMATION, gridPane.getScene().getWindow(), "Login Successful!", "Welcome " + unameTf.getText());
                
                try {
					rolePage.start(secondStage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void loginPage() {
		initLogin();
		loginForm();
		loginValidation();
	}
	

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		RegisterPage registerPage = new RegisterPage();
		
		secondStage = primaryStage;
		
		loginPage();
		
		registerLink.setOnAction(e -> {
			try {
				registerPage.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		primaryStage.setTitle("Shoes Station");
		primaryStage.setScene(loginPage);
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
