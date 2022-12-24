package page;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
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
import model.Cart;
import model.Product;
import model.TransactionDetail;
import model.TransactionHistory;

public class UserPage extends Application {
	
	private Scene userPage;
	private MenuBar userMenuBar;
	private Menu userMenu, transactionMenu;
	private BorderPane borderPane;
	private GridPane gridPane, gridPane2, gridPane3;
	private HBox hBox;
	private VBox vBox1, vBox2;
	private MenuItem logOut, buyProduct, viewTransaction;
	private Window buyProductWindow, transactionHistoryWindow;
	private TableView<Product> productTable;
	private TableView<Cart> cartTable;
	private TableView<TransactionHistory> trHistoryTable;
	private TableView<TransactionDetail> trDetailTable;
	private Label idLabel, nameLabel, quantityLabel, stockLabel, typeIdLabel, priceLabel, selectedIdLabel, selectedIdPrintLabel;
	private TextField idField, nameField, stockField, typeIdField, priceField;
	private Button addToCartButton, checkOutButton;
	private Spinner<Integer> quantitySpinner;
	private ScrollPane productScrollPane, cartScrollPane, trHistoryScrollPane, trDetailScrollPane;
	
	
	Stage secondStage = new Stage();
	
	private void initUser() {
		borderPane = new BorderPane();
		
		userMenuBar = new MenuBar();
		userMenu = new Menu("User");
		transactionMenu = new Menu("Transaction");
		logOut = new MenuItem("Log Out");
		buyProduct = new MenuItem("Buy Product");
		viewTransaction = new MenuItem("View Transaction");
		
		userPage = new Scene(borderPane,750,750);
		
	}
	
	private void initUserMenu() {
		userMenuBar.getMenus().add(userMenu);
		userMenuBar.getMenus().add(transactionMenu);
		
		userMenu.getItems().add(logOut);
		
		transactionMenu.getItems().add(buyProduct);
		transactionMenu.getItems().add(viewTransaction);
	}
	
	private void initStage() {
		borderPane.setTop(userMenuBar);
	}
	
	private void initProduct() {
		buyProductWindow = new Window("Buy Product");
		productTable = new TableView<>();
		cartTable = new TableView<>();
		
		buyProductWindow.getLeftIcons().add(new MinimizeIcon(buyProductWindow));
		buyProductWindow.getRightIcons().add(new CloseIcon(buyProductWindow));
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
		
		productTable.setPrefHeight(700);
		
		productScrollPane.setContent(productTable);
		productScrollPane.setFitToHeight(false);
	}
	
	private void initBuyInput() {
		
		gridPane = new GridPane();
		hBox = new HBox();
		
		idLabel = new Label("ID");
		nameLabel = new Label("Name");
		quantityLabel = new Label("Quantity");
		stockLabel = new Label("Stock");
		typeIdLabel = new Label("Type ID");
		priceLabel = new Label("Price");
		idField = new TextField();
		nameField = new TextField();
		stockField = new TextField();
		typeIdField = new TextField();
		priceField = new TextField();
		quantitySpinner = new Spinner<>();
		addToCartButton = new Button("Add to Cart");
	}
	
	private void buyInputLayout() {
		
		SpinnerValueFactory<Integer> quantitySpinnerValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,0);
		quantitySpinner.setValueFactory(quantitySpinnerValue);
		
		gridPane.add(idLabel, 0, 0);
		gridPane.add(idField, 1, 0);
		gridPane.add(stockLabel, 2, 0);
		gridPane.add(stockField, 3, 0);
		
		idField.setPrefSize(200, 10);
		stockField.setPrefSize(200, 10);
		idLabel.setFont(Font.font(15));
		stockLabel.setFont(Font.font(15));
		idField.setEditable(false);
		stockField.setEditable(false);
		
		gridPane.add(nameLabel, 0, 1);
		gridPane.add(nameField, 1, 1);
		gridPane.add(typeIdLabel, 2, 1);
		gridPane.add(typeIdField, 3, 1);
		
		nameField.setPrefSize(200, 10);
		typeIdField.setPrefSize(200, 10);
		nameLabel.setFont(Font.font(15));
		typeIdLabel.setFont(Font.font(15));
		nameField.setEditable(false);
		typeIdField.setEditable(false);
		
		gridPane.add(quantityLabel, 0, 2);
		gridPane.add(quantitySpinner, 1, 2);
		gridPane.add(priceLabel, 2, 2);
		gridPane.add(priceField, 3, 2);
		
		quantitySpinner.setPrefSize(200, 10);
		priceField.setPrefSize(200, 10);
		quantityLabel.setFont(Font.font(15));
		priceLabel.setFont(Font.font(15));
		priceField.setEditable(false);
		
		hBox.getChildren().add(addToCartButton);
		hBox.setAlignment(Pos.CENTER);
		
		gridPane.add(hBox, 0, 3, 5, 1);
		gridPane.setHalignment(hBox, HPos.CENTER);
		
		
		gridPane.setVgap(20);
		gridPane.setHgap(20);
		gridPane.setPadding(new Insets(20,50,20,50));
		gridPane.setAlignment(Pos.TOP_CENTER);
	}
	
	private void setCartTable() {
		
		TableColumn<Cart, Integer> productIdColumn = new TableColumn<>("Product ID");
		productIdColumn.setCellValueFactory(new PropertyValueFactory<Cart, Integer>("productId"));
		productIdColumn.setMinWidth(130);
		
		TableColumn<Cart, String> userIdColumn = new TableColumn<>("User ID");
		userIdColumn.setCellValueFactory(new PropertyValueFactory<Cart, String>("userId"));
		userIdColumn.setMinWidth(130);
		
		TableColumn<Cart, String> productNameColumn = new TableColumn<>("Product Name");
		productNameColumn.setCellValueFactory(new PropertyValueFactory<Cart, String>("productName"));
		productNameColumn.setMinWidth(130);
		
		TableColumn<Cart, String> productTypeColumn = new TableColumn<>("Product Type");
		productTypeColumn.setCellValueFactory(new PropertyValueFactory<Cart, String>("productType"));
		productTypeColumn.setMinWidth(130);
		
		TableColumn<Cart, Integer> quantityColumn = new TableColumn<>("Quantity");
		quantityColumn.setCellValueFactory(new PropertyValueFactory<Cart, Integer>("quantity"));
		quantityColumn.setMinWidth(130);
		
		TableColumn<Cart, Integer> productPriceColumn = new TableColumn<>("Product Price");
		productPriceColumn.setCellValueFactory(new PropertyValueFactory<Cart, Integer>("productPrice"));
		productPriceColumn.setMinWidth(130);
		
		cartTable.getColumns().addAll(productIdColumn, userIdColumn, productNameColumn, productTypeColumn, quantityColumn, productPriceColumn);
		
		cartTable.setPrefHeight(700);
		
		cartScrollPane = new ScrollPane();
		
		cartScrollPane.setContent(cartTable);
		cartScrollPane.setFitToHeight(false);
	}
	
	private void checkOutLayout() {
		gridPane2 = new GridPane();
		checkOutButton = new Button("Check Out");
		
		gridPane2.add(checkOutButton, 0, 0, 2, 1);
		gridPane2.setHalignment(checkOutButton, HPos.CENTER);
		gridPane2.setAlignment(Pos.CENTER);
		gridPane2.setPadding(new Insets(10, 0, 10, 0));
	}
	
	private void setBuyWindow() {
		vBox1 = new VBox();
		
		vBox1.getChildren().add(productScrollPane);
		vBox1.getChildren().add(gridPane);
		vBox1.getChildren().add(cartScrollPane);
		vBox1.getChildren().add(gridPane2);
		
		buyProductWindow.getContentPane().getChildren().add(vBox1);
		
		borderPane.setCenter(buyProductWindow);
	}
	
	private void initHistory() {
		transactionHistoryWindow = new Window("Transaction History");
		trHistoryTable = new TableView<>();
		trDetailTable = new TableView<>();
		
		transactionHistoryWindow.getLeftIcons().add(new MinimizeIcon(transactionHistoryWindow));
		transactionHistoryWindow.getRightIcons().add(new CloseIcon(transactionHistoryWindow));
	}
	
	private void setTrHistoryTable() {
		TableColumn<TransactionHistory, Integer> transactionIdColumn = new TableColumn<>("Transaction ID");
		transactionIdColumn.setCellValueFactory(new PropertyValueFactory<TransactionHistory, Integer>("transactionId"));
		transactionIdColumn.setMinWidth(372);
		
		TableColumn<TransactionHistory, Date> transactionDateColumn = new TableColumn<>("Transaction Date");
		transactionDateColumn.setCellValueFactory(new PropertyValueFactory<TransactionHistory, Date>("transactionDate"));
		transactionDateColumn.setMinWidth(372);
		
		trHistoryTable.getColumns().addAll(transactionIdColumn, transactionDateColumn);
		
		trHistoryTable.setPrefHeight(200);
		
		trHistoryScrollPane = new ScrollPane();
		
		trHistoryScrollPane.setContent(trHistoryTable);
		trHistoryScrollPane.setFitToHeight(false);
		
	}
	
	private void setTrDetailTable() {
		TableColumn<TransactionDetail, Integer> transactionIdColumn = new TableColumn<>("Transaction ID");
		transactionIdColumn.setCellValueFactory(new PropertyValueFactory<TransactionDetail, Integer>("transactionId"));
		transactionIdColumn.setMinWidth(250);
		
		TableColumn<TransactionDetail, Integer> productIdColumn = new TableColumn<>("Product ID");
		productIdColumn.setCellValueFactory(new PropertyValueFactory<TransactionDetail, Integer>("productId"));
		productIdColumn.setMinWidth(250);
		
		TableColumn<TransactionDetail, Integer> quantityColumn = new TableColumn<>("Quantity");
		quantityColumn.setCellValueFactory(new PropertyValueFactory<TransactionDetail, Integer>("quantity"));
		quantityColumn.setMinWidth(250);
		
		trDetailTable.getColumns().addAll(transactionIdColumn, productIdColumn, quantityColumn);
		
		trDetailScrollPane = new ScrollPane();
		
		trDetailScrollPane.setContent(trDetailTable);
		trDetailScrollPane.setFitToHeight(true);
		
	}
	
	private void initSelectedId() {
		
		gridPane3 = new GridPane();
		
		selectedIdLabel = new Label("Current Selected ID: " + trHistoryTable.getSelectionModel().getSelectedItem());
	}
	
	private void setSelectedId() {
		gridPane3.add(selectedIdLabel, 0, 0);
		gridPane3.setAlignment(Pos.CENTER_LEFT);
		gridPane3.setPadding(new Insets(10,10,10,10));
		
		selectedIdLabel.setFont(Font.font(15));
	}
	
	private void setTrHistory() {
		vBox2 = new VBox();
		
		vBox2.getChildren().add(trHistoryScrollPane);
		vBox2.getChildren().add(gridPane3);
		vBox2.getChildren().add(trDetailScrollPane);
		
		transactionHistoryWindow.getContentPane().getChildren().add(vBox2);
		
		borderPane.setCenter(transactionHistoryWindow);
	}
	
	private void userPageButton() {
		LoginPage loginPage = new LoginPage();
		
		logOut.setOnAction(e -> {
			try {
				loginPage.start(secondStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		buyProduct.setOnAction(e -> {
			initProduct();
			setProductTable();
			initBuyInput();
			buyInputLayout();
			setCartTable();
			checkOutLayout();
			setBuyWindow();
		});
		
		viewTransaction.setOnAction(e -> {
			initHistory();
			setTrHistoryTable();
			setTrDetailTable();
			initSelectedId();
			setSelectedId();
			setTrHistory();
//			setItemEvent();
		});
	}
	
	private void userPage() {
		initUser();
		initUserMenu();
		userPageButton();
		initStage();
		
	}

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		userPage();
		
		secondStage = primaryStage;
		
		primaryStage.setTitle("Shoes Station");
		primaryStage.setScene(userPage);
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
