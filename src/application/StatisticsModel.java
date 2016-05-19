package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class StatisticsModel {

	
    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:stats.db";
 
    private Connection conn;
    private Statement stat;
	
	
	public StatisticsModel(){
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
	 
	        createTables();

		
	}

	
	public boolean createTables(){
		String removeTables = "DROP TABLE IF EXISTS statistics;";
		String createStatistics = "CREATE TABLE IF NOT EXISTS statistics (id_roll INTEGER PRIMARY KEY AUTOINCREMENT, score INTEGER);";
		   try {
	            stat.execute(removeTables);
	            stat.execute(createStatistics);
	           
	        } catch (SQLException e) {
	            System.err.println("Error creating table.");
	            e.printStackTrace();
	            return false;
	        }
	        return true;
		
	}

	public boolean insertRoll(int wynik){
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into statistics values (NULL, ?);");
            prepStmt.setInt(1, wynik);
            prepStmt.execute();
            
        
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu czytelnika");
            e.printStackTrace();
            return false;
        }
		
		return true;
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
