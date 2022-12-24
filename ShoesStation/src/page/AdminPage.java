package page;

import java.util.Optional;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import jfxtras.labs.scene.control.window.CloseIcon;
import jfxtras.labs.scene.control.window.MinimizeIcon;
import jfxtras.labs.scene.control.window.Window;
import page.LoginPage;
import model.Product;
import model.ProductType;

public class AdminPage extends Application {
	
	private Scene adminPage;
	private MenuBar adminMenuBar;
	private Menu adminMenu, manageMenu;
	private BorderPane borderPane;
	private MenuItem logOut, manageProduct, manageProductType;
	private Window manageProductWindow, manageProductTypeWindow;
	private TableView<Product> productTable;
	private TableView<ProductType> productTypeTable;
	private ScrollPane productScrollPane, productTypeScrollPane;
	private VBox vBox1, vBox2;
	private GridPane gridPane, gridPane2;
	private HBox hBox, hBox2;
	private Label nameLabel, addStockLabel, typeLabel, priceLabel, PrTypeNameLabel;
	private TextField nameField, priceField, prTypeNameField;
	private Spinner<Integer> addStockSpinner;
	private ComboBox<String> newType;
	private Button removeButton, insertButton, updateButton, removeButton2, insertButton2, updateButton2;
	
	Stage secondStage = new Stage();
	
	private void initAdmin() {
		borderPane = new BorderPane();
		gridPane = new GridPane();
		
		adminMenuBar = new MenuBar();
		adminMenu = new Menu("User");
		manageMenu = new Menu("Manage");
		logOut = new MenuItem("Log Out");
		manageProduct = new MenuItem("Manage Product");
		manageProductType = new MenuItem("Manage Product Type");
		
		adminPage = new Scene(borderPane,750,750);
	}
	
	private void initAdminMenu() {
		adminMenuBar.getMenus().add(adminMenu);
		adminMenuBar.getMenus().add(manageMenu);
		
		adminMenu.getItems().add(logOut);
		
		manageMenu.getItems().add(manageProduct);
		manageMenu.getItems().add(manageProductType);
	}
	
	private void initStage() {
		borderPane.setTop(adminMenuBar);
	}
	
	private void initManageProduct() {
		manageProductWindow = new Window("Manage Product");
		productTable = new TableView<>();
		
		manageProductWindow.getLeftIcons().add(new MinimizeIcon(manageProductWindow));
		manageProductWindow.getRightIcons().add(new CloseIcon(manageProductWindow));
	}
	
	private void setProductTable() {
		productScrollPane = new ScrollPane();
		
		TableColumn<Product, Integer> productIdColumn = new TableColumn<>("Product ID");
		productIdColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productId"));
		productIdColumn.setMinWidth(150);
		
		TableColumn<Product, Integer> productStockColumn = new TableColumn<>("Product Stock");
		productStockColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productStock"));
		productStockColumn.setMinWidth(150);
		
		TableColumn<Product, String> productNameColumn = new TableColumn<>("Product Name");
		productNameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
		productNameColumn.setMinWidth(150);
		
		TableColumn<Product, Integer> productTypeIdColumn = new TableColumn<>("Product Type ID");
		productTypeIdColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productTypeId"));
		productTypeIdColumn.setMinWidth(150);
		
		TableColumn<Product, Integer> productPriceColumn = new TableColumn<>("Product Price");
		productPriceColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productPrice"));
		productPriceColumn.setMinWidth(150);
		
		productTable.getColumns().addAll(productIdColumn, productStockColumn, productNameColumn, productTypeIdColumn, productPriceColumn);
		
		productTable.setPrefHeight(400);
		
		productScrollPane.setContent(productTable);
		productScrollPane.setFitToHeight(true);
	}
	
	private void initManageInput() {
		hBox = new HBox();
		
		nameLabel = new Label("Name");
		addStockLabel = new Label("Add Stock / New Stock");
		typeLabel = new Label("New Type");
		priceLabel = new Label("Price");
		nameField = new TextField();
		priceField = new TextField();
		addStockSpinner = new Spinner<>();
		newType = new ComboBox<>();
		removeButton = new Button("Remove");
		updateButton = new Button("Update");
		insertButton = new Button("Insert");
	}
	
	private void setManageInput() {
		
		SpinnerValueFactory<Integer> addStockSpinnerValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,0);
		addStockSpinner.setValueFactory(addStockSpinnerValue);
		
		newType.getItems().add("Futsal");
		newType.getItems().add("Volleyball");
		newType.getItems().add("Badminton");
		newType.getItems().add("Pinkponk4");
		newType.getSelectionModel().selectFirst();
		
		gridPane.add(nameLabel, 0, 0);
		gridPane.add(nameField, 1, 0);
		
		nameLabel.setFont(Font.font(15));
		nameField.setPrefSize(200, 10);
		
		gridPane.add(addStockLabel, 0, 1);
		gridPane.add(addStockSpinner, 1, 1);
		
		addStockLabel.setFont(Font.font(15));
		addStockSpinner.setPrefSize(200, 10);
		
		gridPane.add(typeLabel, 0, 2);
		gridPane.add(newType, 1, 2);
		
		typeLabel.setFont(Font.font(15));
		newType.setPrefSize(150, 10);
		
		gridPane.add(priceLabel, 0, 3);
		gridPane.add(priceField, 1, 3);
		
		priceLabel.setFont(Font.font(15));
		priceField.setPrefSize(200, 10);
		
		gridPane.setVgap(20);
		gridPane.setHgap(20);
		
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPadding(new Insets(20,0,20,0));
		
		removeButton.setPrefSize(100, 50);
		updateButton.setPrefSize(100, 50);
		insertButton.setPrefSize(100, 50);
		
		hBox.getChildren().addAll(removeButton, updateButton, insertButton);
		hBox.setAlignment(Pos.CENTER);
		hBox.setSpacing(40);
		
		gridPane.add(hBox, 0, 4, 2, 1);
	}
	
	private void setManageProductWindow() {
		vBox1 = new VBox();
		
		vBox1.getChildren().add(productScrollPane);
		vBox1.getChildren().add(gridPane);
		
		manageProductWindow.getContentPane().getChildren().add(vBox1);
		
		borderPane.setCenter(manageProductWindow);
	}
	
	private void initManagProductType() {
		manageProductTypeWindow = new Window("Manage Product Type");
		productTypeTable = new TableView<>();
		
		manageProductTypeWindow.getLeftIcons().add(new MinimizeIcon(manageProductTypeWindow));
		manageProductTypeWindow.getRightIcons().add(new CloseIcon(manageProductTypeWindow));
	}
	
	private void setProductTypeTable() {
		productTypeScrollPane = new ScrollPane();
		
		TableColumn<ProductType, Integer> productTypeIdColumn = new TableColumn<>("Product Type ID");
		productTypeIdColumn.setCellValueFactory(new PropertyValueFactory<ProductType, Integer>("ProductTypeId"));
		productTypeIdColumn.setMinWidth(372);
		
		TableColumn<ProductType, String> productNameColumn = new TableColumn<>("Product Name");
		productNameColumn.setCellValueFactory(new PropertyValueFactory<ProductType, String>("productName"));
		productNameColumn.setMinWidth(372);
		
		productTypeTable.getColumns().addAll(productTypeIdColumn, productNameColumn);
		
		productTypeTable.setPrefHeight(500);
		
		productTypeScrollPane.setContent(productTypeTable);
		productTypeScrollPane.setFitToHeight(true);
	}
	
	private void initPrTypeInput() {
		hBox = new HBox();
		gridPane = new GridPane();
		
		prTypeNameField = new TextField();
		PrTypeNameLabel = new Label("Name");
		
		removeButton = new Button("Remove");
		updateButton = new Button("Update");
		insertButton = new Button("Insert");
	}
	
	private void setPrTypeInput() {
		gridPane.add(PrTypeNameLabel, 0, 0);
		gridPane.add(prTypeNameField, 1, 0);
		
		PrTypeNameLabel.setFont(Font.font(15));
		prTypeNameField.setPrefSize(200, 10);
		
		gridPane.setVgap(20);
		gridPane.setHgap(20);
		
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPadding(new Insets(20,0,20,0));
		
		removeButton.setPrefSize(100, 50);
		updateButton.setPrefSize(100, 50);
		insertButton.setPrefSize(100, 50);
		
		hBox.getChildren().addAll(updateButton, insertButton, removeButton);
		hBox.setAlignment(Pos.CENTER);
		hBox.setSpacing(40);
		
		gridPane.add(hBox, 0, 2, 2, 1);
		
	}
	
	private void setManageProductTypeWindow() {
		vBox1 = new VBox();
		
		vBox1.getChildren().add(productTypeScrollPane);
		vBox1.getChildren().add(gridPane);
		
		manageProductTypeWindow.getContentPane().getChildren().add(vBox1);
		
		borderPane.setCenter(manageProductTypeWindow);
	}
	
	
	private void adminPageButton() {
		LoginPage loginPage = new LoginPage();
		
		logOut.setOnAction(e -> {
			try {
				loginPage.start(secondStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		manageProduct.setOnAction(e -> {
			initManageProduct();
			setProductTable();
			initManageInput();
			setManageInput();
			
			setManageProductWindow();
		});
		
		manageProductType.setOnAction(e -> {
			initManagProductType();
			setProductTypeTable();
			initPrTypeInput();
			setPrTypeInput();
			
			setManageProductTypeWindow();
		});
	}
	
	private void adminPage() {
		initAdmin();
		initAdminMenu();
		adminPageButton();
		initStage();
	}

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		adminPage();
		
		secondStage = primaryStage;
		
		primaryStage.setTitle("Shoes Station");
		primaryStage.setScene(adminPage);
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
