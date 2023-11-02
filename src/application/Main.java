package application;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URISyntaxException;
import java.util.Optional;

import backend.Date;
import backend.Transaction;
import backend.TransactionCategory;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Javadoc comment
 */

public class Main extends Application {
	private Screen screen;

	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension size = kit.getScreenSize();
	int width = (int) size.getWidth();
	int height = (int) size.getHeight();

	@Override
	public void start(Stage stage) {
		stage.setWidth(width * 0.9);
		stage.setHeight(height * 0.9);
		this.loginScene(stage);
		stage.setTitle("Spend Wise");
		stage.show();

	}

	public void loginScene(Stage stage) {
		screen = Screen.LOGIN;
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		VBox vBox1 = new VBox();
		vBox1.setAlignment(Pos.CENTER);
		VBox vBox2 = new VBox();
		vBox2.setAlignment(Pos.CENTER);

		// User name horizontal
		HBox hBox11 = new HBox();
		hBox11.setAlignment(Pos.CENTER);
		HBox hBox111 = new HBox();
		HBox hBox112 = new HBox();

		vBox1.getChildren().add(hBox11);
		Region region1 = new Region();
		region1.setMinWidth(width * 0.01);
		hBox11.getChildren().addAll(hBox111, region1, hBox112);
		Text text1 = new Text();
		TextField textField1 = new TextField();
		hBox111.getChildren().addAll(text1);
		hBox112.getChildren().add(textField1);
		textField1.setPromptText("Email/username");
		textField1.focusTraversableProperty();
		text1.setText("User Name");

		// Password horizontal
		HBox hBox12 = new HBox();
		hBox12.setAlignment(Pos.CENTER);
		HBox hBox121 = new HBox();
		HBox hBox122 = new HBox();

		Region region2 = new Region();
		region2.setMinHeight(height * 0.01);

		vBox1.getChildren().addAll(region2, hBox12);
		Region region3 = new Region();
		region3.setMinWidth(width * 0.01);
		hBox12.getChildren().addAll(hBox121, region3, hBox122);
		Text text2 = new Text();
		PasswordField passwordField = new PasswordField();
		hBox121.getChildren().addAll(text2);
		hBox122.getChildren().addAll(passwordField);
		text2.setText("Password  ");
		passwordField.setPromptText("Password");

		// Login button
		HBox hBox21 = new HBox(), hBox22 = new HBox();
		hBox21.setAlignment(Pos.CENTER);
		hBox22.setAlignment(Pos.CENTER);
		Button logiButton = new Button();
		Region region4 = new Region();
		Region region5 = new Region();
		region4.setMinHeight(height * 0.01);
		region5.setMinHeight(height * 0.2);
		vBox2.getChildren().addAll(hBox21, region4, hBox22, region5);
		hBox21.getChildren().addAll(logiButton);
		logiButton.setMinHeight(height * 0.03);
		logiButton.setMinWidth(width * 0.05);
		logiButton.setText("Login");
		Text text3 = new Text();
		hBox22.getChildren().setAll(text3);
		text3.setText("Create account");
		text3.setOnMouseEntered(e -> {
			text3.setFill(Color.BLACK);
		});
		text3.setOnMouseExited(e -> {

			text3.setFill(Color.BLUE);
		});
		text3.setFill(Color.BLUE);

		stage.requestFocus();

		root.setCenter(vBox1);
		root.setBottom(vBox2);

		logiButton.setOnAction(e -> {
			// Next home page method

			this.homePage(stage);

		});
	}

	public Boolean alert(String question) {
		Alert al = new Alert(AlertType.CONFIRMATION);

		al.setHeaderText(question);

		Optional<ButtonType> result = al.showAndWait();

		if (result.isPresent() && result.get() == ButtonType.OK) {
			return true;
		} else {
			return false;
		}

	}

	public void homePage(Stage stage) {
		screen = Screen.HOME;
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root);
		stage.setScene(scene);

		Image backgroundImage = null;
		try {
			backgroundImage = new Image(getClass().getResource("/images/homepage.jpeg").toURI().toString());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false,
				false, true);
		BackgroundImage backgroundImg = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
		root.setBackground(new Background(backgroundImg));

		VBox vBox3 = new VBox();
		vBox3.setSpacing(20); // button spacing
		vBox3.setPrefWidth(170);
		vBox3.setTranslateX(40); // vBox position on stage
		vBox3.setTranslateY(300);
		vBox3.setAlignment(Pos.TOP_LEFT);

		Button viewTransaction = new Button("View Transaction");
		Button categoriseTransaction = new Button("Categorise Transaction");
		Button spendingReport = new Button("Detailed Spending Report");
		Button settingsButton = new Button("Settings");
		// home Buttons width all set to vBox width
		viewTransaction.setMaxWidth(vBox3.getPrefWidth());
		categoriseTransaction.setMaxWidth(vBox3.getPrefWidth());
		spendingReport.setMaxWidth(vBox3.getPrefWidth());
		settingsButton.setMaxWidth(vBox3.getPrefWidth());

		// home Buttons height size
		double buttonHeight = 40;
		viewTransaction.setPrefHeight(buttonHeight);
		categoriseTransaction.setPrefHeight(buttonHeight);
		spendingReport.setPrefHeight(buttonHeight);
		settingsButton.setPrefHeight(buttonHeight);

		// home Buttons font size
		Font buttonFont = new Font(14);
		viewTransaction.setFont(buttonFont);
		categoriseTransaction.setFont(buttonFont);
		spendingReport.setFont(buttonFont);
		settingsButton.setFont(buttonFont);

		Button back = new Button("Back");

		vBox3.getChildren().addAll(viewTransaction, spendingReport, settingsButton);
		// , categoriseTransaction

		GridPane mainBox = new GridPane();
		mainBox.getChildren().add(vBox3);
		GridPane.setColumnIndex(mainBox, 0);
		mainBox.getColumnConstraints().add(new ColumnConstraints(200));
		root.setCenter(mainBox);

		viewTransaction.setOnAction(e -> {
			if (screen != Screen.VIEWTRANSACTION) {
				screen = Screen.VIEWTRANSACTION;
				VBox VBOXX = showTransactions();

				VBOXX.getChildren().add(back);
				VBOXX.getChildren().add(categoriseTransaction);
				mainBox.getChildren().add(VBOXX);
				GridPane.setColumnIndex(VBOXX, 1);
				mainBox.getColumnConstraints().add(new ColumnConstraints(1000));
				back.setOnAction(ei -> {
					mainBox.getChildren().remove(VBOXX);
					screen = Screen.HOME;
				});
			}
		});
	}

	public VBox showTransactions() {

		VBox vb = new VBox();

		TableView<Transaction> table = new TableView<Transaction>();
		table.setPrefWidth(vb.getWidth());

		table.setPrefHeight(1900);
		table.setPrefWidth(1800);

		TableColumn<Transaction, String> firstColumn = new TableColumn<>("Date");
		firstColumn.setCellValueFactory(n -> n.getValue().generateTransactionVisual().getDate());
		TableColumn<Transaction, String> SecondColumn = new TableColumn<>("Transaction Detail");
		SecondColumn.setCellValueFactory(n -> n.getValue().generateTransactionVisual().getTransactionTitle());
		TableColumn<Transaction, String> thirdColumn = new TableColumn<>("Amount");
		thirdColumn.setCellValueFactory(n -> n.getValue().generateTransactionVisual().getAmount());
		TableColumn<Transaction, String> fourthColumn = new TableColumn<>("type");
		fourthColumn.setCellValueFactory(n -> n.getValue().generateTransactionVisual().getPurchase());
		TableColumn<Transaction, String> fifthColumn = new TableColumn<>("category");
		fifthColumn.setCellValueFactory(n -> n.getValue().generateTransactionVisual().getCategory());

		vb.getChildren().addAll(table);

		table.setEditable(true);

		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		table.getColumns().addAll(firstColumn, SecondColumn, thirdColumn, fourthColumn, fifthColumn);

		ObservableList<Transaction> items1 = FXCollections
				.observableArrayList((new Transaction("food", new Date(1, 1, 1), 30, true, TransactionCategory.NONE)));

		table.getItems().addAll(items1);
		return vb;

	}

	public static void main(String[] args) {
		launch(args);
	}
}
