package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import page.LoginPage;
import page.RegisterPage;

public class Main extends Application {
	
	private Scene mainScene;
	private BorderPane borderPane;
	private Stage mainStage;
	
//	private void initialize() {
//		borderPane = new BorderPane();
//		
//		mainScene = new Scene(borderPane, 500, 500);
//	}
//	
//	public void hyperLogin() {
//		mainStage = new Stage();
//		LoginPage loginPage = new LoginPage();
//		
//			try {
//				loginPage.start(mainStage);
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//			
//	}
	
	public void alert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
//		initialize();
//		
//		mainStage = primaryStage;
//		
//		primaryStage.setTitle("Shoes Station");
//		primaryStage.setScene(mainScene);
//		primaryStage.setResizable(false);
//		primaryStage.show();
		
	}

}
