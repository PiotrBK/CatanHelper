package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class DiceController implements Initializable{

	private DiceModel model1 = new DiceModel();
	private DiceModel model2 = new DiceModel();
	private DiceEngine engine = new DiceEngine();
	private Image image1 = new Image("/application/img/diceOne.png");
	private Image image2 = new Image("/application/img/diceTwo.png");
	private Image image3 = new Image("/application/img/diceThree.png");
	private Image image4 = new Image("/application/img/diceFour.png");
	private Image image5 = new Image("/application/img/diceFive.png");
	private Image image6 = new Image("/application/img/diceSix.png");
	public StatisticsModel statsModel = new StatisticsModel();
	private int score;

	
	@FXML
	ImageView dice1;
	
	@FXML
	ImageView dice2;
	
	@FXML
	public void diceClicked(ActionEvent event){
		int value1 = engine.rollDices();
		int value2 = engine.rollDices();
		model1.setValue(value1);
		model2.setValue(value2);
		if(model1.getValue() == 1)
		dice1.setImage(image1);
		
		if(model1.getValue() == 2)
		dice1.setImage(image2);	
		
		if(model1.getValue() == 3)
		dice1.setImage(image3);	
		
		if(model1.getValue() == 4)
		dice1.setImage(image4);	
		
		if(model1.getValue() == 5)
		dice1.setImage(image5);	
		
		if(model1.getValue() == 6)
		dice1.setImage(image6);	
		
		score = model1.getValue();
		
		if(model2.getValue() == 1)
		dice2.setImage(image1);
				
		if(model2.getValue() == 2)
		dice2.setImage(image2);	
				
		if(model2.getValue() == 3)
		dice2.setImage(image3);	
				
		if(model2.getValue() == 4)
		dice2.setImage(image4);	
				
		if(model2.getValue() == 5)
		dice2.setImage(image5);	
				
		if(model2.getValue() == 6)
		dice2.setImage(image6);				
			
		score = score + model2.getValue();
		statsModel.insertRoll(score);
		score = 0;

		
	}
	

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		model1.setValue(0);
		model2.setValue(0);
		model1.integerProperty().addListener(new ChangeListener<Object>() {
			
			@Override
			public synchronized void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				
			}
		});
		
		model2.integerProperty().addListener(new ChangeListener<Object>() {

			@Override
			public synchronized void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				
				
				
				
				
			}
						
		});
		
		
		

	}
	
	@FXML
	public void btnStatisticsAction(ActionEvent event) throws IOException{
		
		
		Stage primaryStage = new Stage(); 
		Parent root = FXMLLoader.load(getClass().getResource("/application/Statistics.fxml"));
		Scene scene = new Scene(root,500,350);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Statistics");
		primaryStage.show();
		
	}
	
}
