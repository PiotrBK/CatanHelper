package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class EnterScoreController implements Initializable {

	
	public StatisticsModel statsModel = new StatisticsModel();
	private Image enterdice2 = new Image("/application/img/enterdice2.png");
	private Image enterdice3 = new Image("/application/img/enterdice3.png");
	private Image enterdice4 = new Image("/application/img/enterdice4.png");
	private Image enterdice5 = new Image("/application/img/enterdice5.png");	
	private Image enterdice6 = new Image("/application/img/enterdice6.png");
	private Image enterdice7 = new Image("/application/img/enterdice7.png");	
	private Image enterdice8 = new Image("/application/img/enterdice8.png");
	private Image enterdice9 = new Image("/application/img/enterdice9.png");
	private Image enterdice10 = new Image("/application/img/enterdice10.png");
	private Image enterdice11 = new Image("/application/img/enterdice11.png");	
	private Image enterdice12 = new Image("/application/img/enterdice12.png");
	

	@FXML 
	ImageView btnEnter2;
	@FXML 
	ImageView btnEnter3;
	@FXML 
	ImageView btnEnter4;
	@FXML 
	ImageView btnEnter5;
	@FXML 
	ImageView btnEnter6;
	@FXML 
	ImageView btnEnter7;
	@FXML 
	ImageView btnEnter8;
	@FXML 
	ImageView btnEnter9;
	@FXML 
	ImageView btnEnter10;
	@FXML 
	ImageView btnEnter11;
	@FXML 
	ImageView btnEnter12;

	
	
	
	
	
	
	@FXML
	TextField txtLast;
	

	
	@FXML
	public void onBtn2Action(ActionEvent event){
		
		txtLast.setText("2");
		statsModel.insertRoll(2);
	
	}
	
	@FXML
	public void onBtn3Action(ActionEvent event){
		
		txtLast.setText("3");
		statsModel.insertRoll(3);
	
	}
	
	@FXML
	public void onBtn4Action(ActionEvent event){
		
		txtLast.setText("4");
		statsModel.insertRoll(4);
	
	}
	
	@FXML
	public void onBtn5Action(ActionEvent event){
		
		txtLast.setText("5");
		statsModel.insertRoll(5);
	
	}
	
	@FXML
	public void onBtn6Action(ActionEvent event){
		
		txtLast.setText("6");
		statsModel.insertRoll(6);
	
	}
	
	@FXML
	public void onBtn7Action(ActionEvent event){
		
		txtLast.setText("7");
		statsModel.insertRoll(7);
	
	}
	
	@FXML
	public void onBtn8Action(ActionEvent event){
		
		txtLast.setText("8");
		statsModel.insertRoll(8);
	
	}
	
	@FXML
	public void onBtn9Action(ActionEvent event){
		
		txtLast.setText("9");
		statsModel.insertRoll(9);
	
	}
	
	@FXML
	public void onBtn10Action(ActionEvent event){
		
		txtLast.setText("10");
		statsModel.insertRoll(10);
	
	}
	
	@FXML
	public void onBtn11Action(ActionEvent event){
		
		txtLast.setText("11");
		statsModel.insertRoll(11);
	
	}

	@FXML
	public void onBtn12Action(ActionEvent event){
		
		txtLast.setText("12");
		statsModel.insertRoll(12);
	
	}
	
	@FXML
	public void onBtnStatisticsAction(ActionEvent event) throws IOException{
		
		
		Stage primaryStage = new Stage(); 
		Parent root = FXMLLoader.load(getClass().getResource("/application/Statistics.fxml"));
		Scene scene = new Scene(root,500,350);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Statistics");
		primaryStage.show();
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnEnter2.setImage(enterdice2);
		btnEnter3.setImage(enterdice3);
		btnEnter4.setImage(enterdice4);
		btnEnter5.setImage(enterdice5);
		btnEnter6.setImage(enterdice6);
		btnEnter7.setImage(enterdice7);
		btnEnter8.setImage(enterdice8);
		btnEnter9.setImage(enterdice9);
		btnEnter10.setImage(enterdice10);
		btnEnter11.setImage(enterdice11);
		btnEnter12.setImage(enterdice12);
		
	}
	
}
