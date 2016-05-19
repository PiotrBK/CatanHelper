package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController{
	
	
	
	private Stage primaryStage = new Stage();
	@FXML
	public void btnDicesClicked(ActionEvent event) throws IOException{
		
		Parent root = FXMLLoader.load(getClass().getResource("/application/Dice.fxml"));
		Scene scene = new Scene(root,500,350);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Roll Dices");
		primaryStage.show();
		
	}
	@FXML
	public void btnEnterScoreClicked(ActionEvent event) throws IOException{
		
		Parent root = FXMLLoader.load(getClass().getResource("/application/EnterScore.fxml"));
		Scene scene = new Scene(root,500,350);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Enter score");
		primaryStage.show();
		
	}
	
	
}
