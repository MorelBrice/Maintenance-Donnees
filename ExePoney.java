import java.sql.SQLException;
import java.util.Scanner;

// commande à executer :

//java -cp .:/usr/share/java/mariadb-java-client.jar TestJDBC
// le serveur est "servinfo-mariadb"


public class ExePoney {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        // On demande les info de la base de donneées
        System.out.print("Veuillez donner le nom du serveur : ");
        String nomServer = sc.nextLine();
        System.out.print("Le nom de la base choisit : ");
        String base = sc.nextLine();
        System.out.print("Votre login : ");
        String login = sc.nextLine();
        System.out.print("Votre mot de passe : ");
        String mdp = sc.nextLine();

        //Connection a la base de données
        ConnexionMySQL c = new ConnexionMySQL(nomServer, base, login, mdp);
        boolean fini = false;
        while(!fini){
            System.out.println(" _____________________________");
            System.out.println("|     Que souhaiter vous ?    |");
            System.out.println("|-----------------------------|");
            System.out.println("| 1. Ajouter une inscription  |");
            System.out.println("| 2. Enlever une inscription  |");
            System.out.println("| 3. Regarder les cours       |");
            System.out.println("| 4. Quitter                  |");
            System.out.println("|_____________________________|");
            System.out.print("\n");
            int rep = sc.nextInt();
            switch(rep){
                case 1 :
                    System.out.println("Veuillez renter ces informations :"+"\n");

                    System.out.println("Numero du cours : ");
                    int idc = Integer.valueOf(System.console().readLine());

                    System.out.println("Numero de la personne qui participe : ");
                    int idPersonne = Integer.valueOf(System.console().readLine());

                    System.out.println("numero du poney que vous voulez : ");
                    int idp = Integer.valueOf(System.console().readLine());
                    

                    try{
                        AppPoney.inscription(c,idc,idPersonne, idp);
                    }
                    catch(SQLException e){
                        System.out.println("erreur dans les données à rentrer"); 
			            System.out.println(e.getMessage());
                    }
                    break;
                case 2 :
                    System.out.println("A quel cour se désinscrire : ");
                    int idc2 = Integer.valueOf(System.console().readLine());
                    System.out.println("id de la personne à désinscrire : ");
                    int idPersonne2 = Integer.valueOf(System.console().readLine());

                    try{
                    AppPoney.desincription(c,idc2, idPersonne2);
                    }
                    catch(SQLException e){
                        System.out.println("erreur dans les données à rentrer"); 
			            System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    AppPoney.getCours(c);
                    break;

                default : 
                    fini = true;
                    sc.close();
                    break;
            }
        }
    }
}
