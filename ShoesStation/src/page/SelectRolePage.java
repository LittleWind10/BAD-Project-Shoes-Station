package page;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import page.AdminPage;
import page.UserPage;

public class SelectRolePage extends Application {
	
	private Scene rolePage;
	private Label titleLabel;
	private Button userButton;
	private Button adminButton;
	private GridPane gridPane;
	private BorderPane borderPane;
	
	Stage secondStage = new Stage();
	
	private void initChoose() {
		gridPane = new GridPane();
		borderPane = new BorderPane();
		
		titleLabel = new Label("Choose Your Roles");
		userButton = new Button("User");
		adminButton = new Button("Admin");
		
		rolePage = new Scene(borderPane,300,300);
	}
	
	private void chooseForm() {
		
		gridPane.add(titleLabel, 0,0,2,1);
        GridPane.setHalignment(titleLabel, HPos.CENTER);
        GridPane.setMargin(titleLabel, new Insets(20,0,50,0));
        
        gridPane.add(userButton, 0, 1);
		gridPane.add(adminButton, 1, 1);
		
		userButton.setPrefSize(100, 50);
		adminButton.setPrefSize(100, 50);
		
		gridPane.setHgap(20);
		gridPane.setAlignment(Pos.CENTER);
		
		borderPane.setCenter(gridPane);
	}
	
	private void chooseValidation() {
		AdminPage adminPage = new AdminPage();
		UserPage userPage = new UserPage();
		
		userButton.setOnAction(e -> {
			try {
				userPage.start(secondStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		adminButton.setOnAction(e -> {
			try {
				adminPage.start(secondStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
	}
	
	private void choosePage() {
		initChoose();
		chooseForm();
		chooseValidation();
	}

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		choosePage();
		
		secondStage = primaryStage;
		
		primaryStage.setTitle("Shoes Station");
		primaryStage.setScene(rolePage);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}

}
