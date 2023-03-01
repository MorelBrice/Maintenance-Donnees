import java.sql.*;


public class AppPoney {


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
        ResultSet rs = s.executeQuery("select * from COURS");
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
}
