package application;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Main extends Application {

	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension size = kit.getScreenSize();
	int width = (int) size.getWidth();
	int height = (int) size.getHeight();

	@Override
	public void start(Stage stage) {
		stage.setWidth(width*0.9);
		stage.setHeight(height*0.9);
		this.loginScene(stage);
		stage.setTitle("Spend Wise");
		stage.show();

		

	}
	public void loginScene(Stage stage){
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		VBox vBox1 = new VBox();
		VBox vBox2 = new VBox();
		HBox hBox11 = new HBox();
		HBox hBox111= new HBox();
		HBox hBox112 = new HBox();
		
		vBox1.getChildren().add(hBox11);
		hBox11.getChildren().addAll(hBox111,hBox112);
		Text text = new Text();
		TextField textField = new TextField();
		hBox111.getChildren().addAll(text);
		hBox112.getChildren().add(textField);
		text.setText("User Name");
		root.setCenter(vBox1);
		root.setBottom(vBox2);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
