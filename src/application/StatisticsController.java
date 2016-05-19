package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class StatisticsController implements Initializable {

	@FXML
	private ProgressBar bar2;	
	@FXML
	private ProgressBar bar3;
	@FXML
	private ProgressBar bar4;	
	@FXML
	private ProgressBar bar5;
	@FXML
	private ProgressBar bar6;	
	@FXML
	private ProgressBar bar7;
	@FXML
	private ProgressBar bar8;	
	@FXML
	private ProgressBar bar9;
	@FXML
	private ProgressBar bar10;	
	@FXML
	private ProgressBar bar11;
	@FXML
	private ProgressBar bar12;
	@FXML
	private TextField field2;
	@FXML
	private TextField field3;	
	@FXML
	private TextField field4;	
	@FXML
	private TextField field5;
	@FXML
	private TextField field6;
	@FXML
	private TextField field7;	
	@FXML
	private TextField field8;	
	@FXML
	private TextField field9;	
	@FXML
	private TextField field10;
	@FXML
	private TextField field11;	
	@FXML
	private TextField field12;
	
    private Connection conn;
    private Statement stat;
    
    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:stats.db";
	private int numberOfRolls;
	private int numberOf2;
	private int numberOf3;
	private int numberOf4;
	private int numberOf5;
	private int numberOf6;
	private int numberOf7;
	private int numberOf8;
	private int numberOf9;
	private int numberOf10;
	private int numberOf11;
	private int numberOf12;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		  try {
	            Class.forName(StatisticsModel.DRIVER);
	        } catch (ClassNotFoundException e) {
	            System.err.println("Brak sterownika JDBC");
	            e.printStackTrace();
	        }
	 
	        try {
	            conn = DriverManager.getConnection(DB_URL);
	            stat = conn.createStatement();
	            
	        } catch (SQLException e) {
	            System.err.println("Problem z otwarciem polaczenia");
	            e.printStackTrace();
	        }
	        
	        List<Roll>rollList = selectRoll();
	        for(int i=0; i<rollList.size();i++){
	        	Roll bestRoll = rollList.get(i);
	        	int bestScore = bestRoll.getScore();
	        	numberOfRolls++;
	        	if(bestScore==2)
	        		numberOf2++;
	        	if(bestScore==3)
	        		numberOf3++;
	        	if(bestScore==4)
		        	numberOf4++;
	        	if(bestScore==5)
		        	numberOf5++;
	        	if(bestScore==6)
		        	numberOf6++;
	        	if(bestScore==7)
		        	numberOf7++;
	        	if(bestScore==8)
		        	numberOf8++;
	        	if(bestScore==9)
		        	numberOf9++;
	        	if(bestScore==10)
		        	numberOf10++;
	        	if(bestScore==11)
		        	numberOf11++;
	        	if(bestScore==12)
		        	numberOf12++;
	        	
	        }
	        
	        int calosc = 10;
	        
	        if((numberOfRolls >= 20) & (numberOfRolls < 40)){
	        calosc = 12;
	        }
	        if((numberOfRolls >= 40) & (numberOfRolls < 60)){
	        calosc = 20;
			}
	        if(numberOfRolls >= 60){
	        calosc = 45;
	        }
	        
	        double value2 =  (double) numberOf2 / calosc;
	        double value3 = (double)  numberOf3 / calosc;
	        double value4 =  (double) numberOf4 / calosc;
	        double value5 = (double)  numberOf5 / calosc;
	        double value6 = (double)  numberOf6 / calosc;
	        double value7 = (double)  numberOf7 / calosc;
	        double value8 =  (double) numberOf8 / calosc;
	        double value9 = (double) numberOf9 / calosc;
	        double value10 =  (double) numberOf10 / calosc;
	        double value11 =  (double) numberOf11 / calosc;
	        double value12 = (double)  numberOf12 / calosc;
	       
	         
	        
	        bar2.setProgress(value2);
	        bar3.setProgress(value3);
	        bar4.setProgress(value4);
	        bar5.setProgress(value5);
	        bar6.setProgress(value6);
	        bar7.setProgress(value7);
	        bar8.setProgress(value8);
	        bar9.setProgress(value9);
	        bar10.setProgress(value10);
	        bar11.setProgress(value11);
	        bar12.setProgress(value12);
	        
	        field2.setText(Integer.toString(numberOf2));
	        field3.setText(Integer.toString(numberOf3));
	        field4.setText(Integer.toString(numberOf4));
	        field5.setText(Integer.toString(numberOf5));
	        field6.setText(Integer.toString(numberOf6));
	        field7.setText(Integer.toString(numberOf7));
	        field8.setText(Integer.toString(numberOf8));
	        field9.setText(Integer.toString(numberOf9));
	        field10.setText(Integer.toString(numberOf10));
	        field11.setText(Integer.toString(numberOf11));
	        field12.setText(Integer.toString(numberOf12));
	        
	        
	}
	
	
    public List<Roll> selectRoll() {
        List<Roll> rollList  = new LinkedList<Roll>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM statistics");
            int id;
            int score;
            while(result.next()) {
                id = result.getInt("id_roll");
                score = result.getInt("score");
             
               rollList.add(new Roll(id, score));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return rollList;
        
        
    }


}
