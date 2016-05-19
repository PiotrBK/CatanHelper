package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	
	public StatisticsModel stats = new StatisticsModel();
	
	@Override
	public void start(Stage primaryStage) {
		try {			
			Parent root = FXMLLoader.load(getClass().getResource("/application/MainMenu.fxml"));
			Scene scene = new Scene(root,500,350);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Catan Helper");
			primaryStage.show();		
		    
			
		    
		} catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	
	public static void main(String[] args) {
		launch(args);
	}


}
