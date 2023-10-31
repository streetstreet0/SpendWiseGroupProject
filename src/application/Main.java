package application;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.print.DocFlavor.READER;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
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
		vBox1.setAlignment(Pos.CENTER);
		VBox vBox2 = new VBox();
		vBox2.setAlignment(Pos.CENTER);	
			
		//User name horizontal
		HBox hBox11 = new HBox();
		hBox11.setAlignment(Pos.CENTER);
		HBox hBox111= new HBox();
		HBox hBox112 = new HBox();

		vBox1.getChildren().add(hBox11);
		Region region1 = new Region();
		region1.setMinWidth(width*0.01);
		hBox11.getChildren().addAll(hBox111,region1,hBox112);
		Text text1 = new Text();
		TextField textField1 = new TextField();
		hBox111.getChildren().addAll(text1);
		hBox112.getChildren().add(textField1);
		textField1.setPromptText("Email/username");
		textField1.focusTraversableProperty();
		text1.setText("User Name");

		//Password horizontal
		HBox hBox12 = new HBox();
		hBox12.setAlignment(Pos.CENTER);
		HBox hBox121= new HBox();
		HBox hBox122 = new HBox();

		Region region2 = new Region();
		region2.setMinHeight(height*0.01);
		
		vBox1.getChildren().addAll(region2,hBox12);
		Region region3 = new Region();
		region3.setMinWidth(width*0.01);
		hBox12.getChildren().addAll(hBox121,region3,hBox122);
		Text text2 = new Text();
		TextField textField2 = new TextField();
		hBox121.getChildren().addAll(text2);
		hBox122.getChildren().addAll(textField2);
		text2.setText("Password  ");

		//Login button
		

		root.setCenter(vBox1);
		root.setBottom(vBox2);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
