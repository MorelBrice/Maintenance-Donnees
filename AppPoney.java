import java.sql.*;


public class AppPoney {

// ----------------------------------------------------------------------Cours----------------------------------------------------------------------

    public static void inscription(ConnexionMySQL c, int idc,int ide, int idp) throws SQLException{
        //Fonction qui permet de faire une inscription a un cour 
        PreparedStatement s = c.getConnexion().prepareStatement("insert into RESERVER values (?,?)");
        PreparedStatement s2 = c.getConnexion().prepareStatement("insert into PARTICIPER values (?,?)");
        s.setInt(1, idc);
        s.setInt(2, ide);
        s2.setInt(1, idc);
        s2.setInt(2, idp);
        s.executeUpdate();
        s2.executeUpdate();
    }

    public static void desincription(ConnexionMySQL c, int idc, int ide) throws SQLException{
        //fonction qui enlève une inscription
        PreparedStatement sidp = c.getConnexion().prepareStatement("select idp from PARTICIPER where idc = ?");
        sidp.setInt(1, idc);
        int idp = sidp.executeQuery().getInt(1);

        PreparedStatement s = c.getConnexion().prepareStatement("DELETE from RESERVER where idc = ? and ide = ?");
        s.setInt(1, idc);
        s.setInt(2, ide);
        PreparedStatement s2 = c.getConnexion().prepareStatement("DELETE from PARTICIPER where idc = ? and idp = ?");
        s2.setInt(1, idc);
        s2.setInt(2, idp);
        s.executeUpdate();
        s2.executeUpdate();
    
        
    }

    public static void getCours(ConnexionMySQL c) throws SQLException{
        //fonction qui affiche les scéances de cours prévu
        java.sql.Statement s = c.getConnexion().createStatement();
        ResultSet rs = s.executeQuery("select idc,nomC,dateC,heureDeb,heureFin,idPersonne,idm from COURS");
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }
    }



// ----------------------------------------------------------------------Poney----------------------------------------------------------------------

    public static void getPoney(ConnexionMySQL c) throws SQLException{
        //fonction qui affiche les scéances de cours prévu
        java.sql.Statement s = c.getConnexion().createStatement();
        ResultSet rs = s.executeQuery("select idp,nomP,robe,DDNP,disciplineP,anneeService from PONEY");
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }
    }


    public static void addPoney(ConnexionMySQL c, String nomP, String robe, String DDNP, String disciplineP, int anneService) throws SQLException{
        PreparedStatement s = c.getConnexion().prepareStatement("insert into PONEY values (?,?,?,?,?)");
        s.setString(1, nomP);
        s.setString(2, robe);
        s.setString(3, DDNP);
        s.setString(4, disciplineP);
        s.setInt(5, anneService);

        s.executeUpdate();
    }

    public static void remPoney(ConnexionMySQL c, int idp) throws SQLException{
        //fonction qui enlève une inscription
        PreparedStatement sidp = c.getConnexion().prepareStatement("DELETE from PONEY where idp = ?");
        sidp.setInt(1, idp);
    
        sidp.executeUpdate();   
    }

    public static void modifPoney(ConnexionMySQL c, int idp, String nomP, String robe, String DDNP, String disciplineP, int anneService) throws SQLException{
        
        
        PreparedStatement s = c.getConnexion().prepareStatement("UPDATE PONEY SET nomP=?,robe=?,DDNP=?,disciplineP=?,anneService=? where idp=?");
        s.setString(1, nomP);
        s.setString(2, robe);
        s.setString(3, DDNP);
        s.setString(4, disciplineP);
        s.setInt(5, anneService);
        s.setInt(6, idp);

        s.executeUpdate();
    }

// ----------------------------------------------------------------------Personne----------------------------------------------------------------------


    public static void getPersonne(ConnexionMySQL c) throws SQLException{
        //fonction qui affiche les scéances de cours prévu
        java.sql.Statement s = c.getConnexion().createStatement();
        ResultSet rs = s.executeQuery("select idPersonne,nom,prenom,DDN from PERSONNE");
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }
    }

    public static void addPersonne(ConnexionMySQL c, String nom, String prenom, String DDN) throws SQLException{
        PreparedStatement s = c.getConnexion().prepareStatement("insert into Personne values (?,?,?)");
        s.setString(1, nom);
        s.setString(2, prenom);
        s.setString(3, DDN);

        s.executeUpdate();
    }

    public static void remPersonne(ConnexionMySQL c, int idPersonne) throws SQLException{
        //fonction qui enlève une inscription
        PreparedStatement sidPersonne = c.getConnexion().prepareStatement("DELETE from Personne where idPersonne=?");
        sidPersonne.setInt(1, idPersonne);
    
        sidPersonne.executeUpdate();   
    }

    public static void modifPersonne(ConnexionMySQL c, int idPersonne, String nom, String prenom, String DDN) throws SQLException{
        
        
        PreparedStatement s = c.getConnexion().prepareStatement("UPDATE Personne SET nom=?,prenom=?,DDN=? where idPersonne=?");
        s.setString(1, nom);
        s.setString(2, prenom);
        s.setString(3, DDN);
        s.setInt(4, idPersonne);

        s.executeUpdate();
    }

// ----------------------------------------------------------------------Moniteur----------------------------------------------------------------------


    public static void getMoniteur(ConnexionMySQL c) throws SQLException{
        //fonction qui affiche les scéances de cours prévu
        java.sql.Statement s = c.getConnexion().createStatement();
        ResultSet rs = s.executeQuery("select idPersonne,idm,license,descriptionM from MONITEUR");
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }
    }

    public static void addMoniteur(ConnexionMySQL c, int idPersonne, String license, String descriptionM) throws SQLException{
        PreparedStatement s = c.getConnexion().prepareStatement("insert into Moniteur values (?,?,?)");
        s.setInt(1, idPersonne);
        s.setString(2, license);
        s.setString(3, descriptionM);

        s.executeUpdate();
    }

    public static void remMoniteur(ConnexionMySQL c, int idm) throws SQLException{
        //fonction qui enlève une inscription
        PreparedStatement sidm = c.getConnexion().prepareStatement("DELETE from Moniteur where idm=?");
        sidm.setInt(1, idm);
    
        sidm.executeUpdate();   
    }

    public static void modifMoniteur(ConnexionMySQL c, int idm, int idPersonne, String license, String descriptionM) throws SQLException{
        
        
        PreparedStatement s = c.getConnexion().prepareStatement("UPDATE Moniteur SET idPersonne=?,license=?,descriptionM=? where idm=?");
        s.setInt(1, idPersonne);
        s.setInt(2, idm);
        s.setString(3, license);
        s.setString(4, descriptionM);

        s.executeUpdate();
    }

// ----------------------------------------------------------------------Eleve----------------------------------------------------------------------

    public static void getEleve(ConnexionMySQL c) throws SQLException{
        //fonction qui affiche les scéances de cours prévu
        java.sql.Statement s = c.getConnexion().createStatement();
        ResultSet rs = s.executeQuery("select idPersonne,ide,poids,galop,taille from ELEVE");
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }
    }


    public static void addEleve(ConnexionMySQL c, int idPersonne, int poids, int galop, int taille) throws SQLException{
        PreparedStatement s = c.getConnexion().prepareStatement("insert into Eleve values (?,?,?)");
        s.setInt(1, idPersonne);
        s.setInt(2, poids);
        s.setInt(3, galop);
        s.setInt(4, taille);

        s.executeUpdate();
    }

    public static void remEleve(ConnexionMySQL c, int ide) throws SQLException{
        //fonction qui enlève une inscription
        PreparedStatement side = c.getConnexion().prepareStatement("DELETE from Eleve where ide=?");
        side.setInt(1, ide);
    
        side.executeUpdate();   
    }

    public static void modifEleve(ConnexionMySQL c, int ide, int idPersonne, int poids, int galop, int taille) throws SQLException{
        
        
        PreparedStatement s = c.getConnexion().prepareStatement("UPDATE Eleve SET idPersonne=?,poids=?,galop=?,taille=? where ide=?");
        s.setInt(1, idPersonne);
        s.setInt(2, poids);
        s.setInt(3, galop);
        s.setInt(4, taille);
        s.setInt(5, ide);
        

        s.executeUpdate();
    }
}
