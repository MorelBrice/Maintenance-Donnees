import java.sql.*;

public class ConnexionMySQL {
	Connection mysql=null;
    boolean connecte=false;
	String serveur = "jdbc:mysql://localhost:3306/SAE_PONEY?useSSL=true&serverTimezone=CET";
    
	public ConnexionMySQL(String nomServeur, String nomBase, String nomLogin, String motDePasse) {
		try {
			// mysql = DriverManager.getConnection(
			// 		"jdbc:mysql://"+nomServeur+":3306/"+nomBase, nomLogin, motDePasse);

			mysql = DriverManager.getConnection(
				serveur, nomLogin, motDePasse);

			connecte=true;
		} catch (SQLException e) {
			System.out.println("Echec de connexion!"); 
			System.out.println(e.getMessage());
			mysql=null;
			return;
		}
	}
    public Connection getConnexion(){
        return this.mysql;
    }
    public boolean getConnecte(){
        return this.connecte;
    }
	
}
