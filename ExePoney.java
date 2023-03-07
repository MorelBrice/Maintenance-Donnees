import java.sql.SQLException;
import java.util.Scanner;

public class ExePoney {

    public static Scanner sc = new Scanner(System.in);

    public static boolean finiPrincipal = false;
    public static boolean finiInsc = false;
    public static boolean finiPoney = false;
    public static boolean finiPersonne = false;
    public static boolean finiEleve = false;
    public static boolean finiMoniteur = false;
    public static boolean finiCours = false;

    public static String nomServer = "localhost";
    public static String base = "SAE_PONEY";
    public static String login;
    public static String mdp;

    public static ConnexionMySQL c;

    public static void main(String[] args) throws SQLException {

        // On demande les info de la base de donneées
        System.out.print("Votre login : ");
        login = sc.nextLine();
        System.out.print("Votre mot de passe : ");
        mdp = sc.nextLine();

        //Connection a la base de données
        c = new ConnexionMySQL(nomServer, base, login, mdp);
        

        while(!finiPrincipal){
            System.out.println(" _____________________________");
            System.out.println("|     Que souhaitez vous ?    |");
            System.out.println("|-----------------------------|");
            System.out.println("| 1. Gérer les Inscriptions   |");
            System.out.println("| 2. Gérer les Poneys         |");
            System.out.println("| 3. Gérer les Personnes      |");
            System.out.println("| 4. Gérer les élèves         |");
            System.out.println("| 5. Gérer les Moniteurs      |");
            System.out.println("| 6. Gérer les Cours          |");
            System.out.println("| 7. Quitter                  |");
            System.out.println("|_____________________________|");
            System.out.print("\n");
            int rep = sc.nextInt();
            switch(rep){
                case 1 :
                    gererInscriptions();
                    break;

                case 2 :
                    gererPoneys();
                    break;

                case 3:
                    gererPersonnes();
                    break;

                case 4:
                    gererEleves();
                    break;

                case 5:
                    gererMoniteurs();
                    break;

                case 6:
                    gererCours();
                    break;

                default : 
                    finiPrincipal = true;
                    sc.close();
                    break;
            }
        }
    }


    public static void gererInscriptions() throws SQLException{

        while(!finiInsc){
            System.out.println(" _____________________________");
            System.out.println("|     Que souhaitez vous ?    |");
            System.out.println("|-----------------------------|");
            System.out.println("| 1. Ajouter une inscription  |");
            System.out.println("| 2. Enlever une inscription  |");
            System.out.println("| 3. Regarder les cours       |");
            System.out.println("| 4. Retour                   |");
            System.out.println("|_____________________________|");
            System.out.print("\n");
            int rep = sc.nextInt();
            switch(rep){
                case 1 :
                    System.out.println("Veuillez rentrer ces informations :"+"\n");

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
                        System.out.println("erreur dans les données saisies"); 
			            System.out.println(e.getMessage());
                    }
                    break;
                case 2 :
                    System.out.println("A quel cours se désinscrire : ");
                    int idc2 = Integer.valueOf(System.console().readLine());
                    System.out.println("id de la personne à désinscrire : ");
                    int idPersonne2 = Integer.valueOf(System.console().readLine());

                    try{
                    AppPoney.desincription(c,idc2, idPersonne2);
                    }
                    catch(SQLException e){
                        System.out.println("erreur dans les données saisies"); 
			            System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    AppPoney.getCours(c);
                    break;

                default : 
                    finiInsc = true;
                    break;
            }
        }
    }

    public static void gererPoneys() throws SQLException{

        while(!finiPoney){
            System.out.println(" _____________________________");
            System.out.println("|     Que souhaitez vous ?    |");
            System.out.println("|-----------------------------|");
            System.out.println("| 1. Lister les Poneys        |");
            System.out.println("| 2. Ajouter un Poney         |");
            System.out.println("| 3. Supprimer un Poney       |");
            System.out.println("| 4. Modifier un Poney        |");
            System.out.println("| 5. Retour                   |");
            System.out.println("|_____________________________|");
            System.out.print("\n");
            int rep = sc.nextInt();
            switch(rep){
                case 1 :
                    break;

                case 2 :
                    break;

                case 3:
                    break;

                case 4:
                    break;

                default : 
                    finiPoney = true;
                    break;
            }
        }
    }

    public static void gererPersonnes() throws SQLException{

        while(!finiPersonne){
        System.out.println(" _____________________________");
        System.out.println("|     Que souhaitez vous ?    |");
        System.out.println("|-----------------------------|");
        System.out.println("| 1. Lister les Personnes     |");
        System.out.println("| 2. Ajouter une Personne     |");
        System.out.println("| 3. Supprimer une Personne   |");
        System.out.println("| 4. Modifier une Personne    |");
        System.out.println("| 5. Retour                   |");
        System.out.println("|_____________________________|");
        System.out.print("\n");
        int rep = sc.nextInt();
        switch(rep){
            case 1 :
                break;

            case 2 :
                break;

            case 3:
                break;

            case 4:
                break;

            default : 
                finiPersonne = true;
                break;
        }
    }
}

    public static void gererEleves() throws SQLException{

            while(!finiEleve){
            System.out.println(" _____________________________");
            System.out.println("|     Que souhaitez vous ?    |");
            System.out.println("|-----------------------------|");
            System.out.println("| 1. Lister les Eleves        |");
            System.out.println("| 2. Ajouter un Eleve         |");
            System.out.println("| 3. Supprimer un Eleve       |");
            System.out.println("| 4. Modifier un Eleve        |");
            System.out.println("| 5. Retour                   |");
            System.out.println("|_____________________________|");
            System.out.print("\n");
            int rep = sc.nextInt();
            switch(rep){
                case 1 :
                    break;

                case 2 :
                    break;

                case 3:
                    break;

                case 4:
                    break;

                default : 
                    finiEleve = true;
                    break;
            }
        }
    }

    public static void gererMoniteurs() throws SQLException{

        while(!finiMoniteur){
            System.out.println(" _____________________________");
            System.out.println("|     Que souhaitez vous ?    |");
            System.out.println("|-----------------------------|");
            System.out.println("| 1. Lister les Moniteurs     |");
            System.out.println("| 2. Ajouter un Moniteur      |");
            System.out.println("| 3. Supprimer un Moniteur    |");
            System.out.println("| 4. Modifier un Moniteur     |");
            System.out.println("| 5. Retour                   |");
            System.out.println("|_____________________________|");
            System.out.print("\n");
            int rep = sc.nextInt();
            switch(rep){
                case 1 :
                    break;

                case 2 :
                    break;

                case 3:
                    break;

                case 4:
                    break;

                default : 
                    finiMoniteur = true;
                    break;
            }
        }
    }

    public static void gererCours() throws SQLException{

        while(!finiCours){
            System.out.println(" _____________________________");
            System.out.println("|     Que souhaitez vous ?    |");
            System.out.println("|-----------------------------|");
            System.out.println("| 1. Lister les Cours         |");
            System.out.println("| 2. Ajouter un Cours         |");
            System.out.println("| 3. Supprimer un Cours       |");
            System.out.println("| 4. Modifier un Cours        |");
            System.out.println("| 5. Retour                   |");
            System.out.println("|_____________________________|");
            System.out.print("\n");
            int rep = sc.nextInt();
            switch(rep){
                case 1 :
                    break;

                case 2 :
                    break;

                case 3:
                    break;

                case 4:
                    break;

                default : 
                    finiCours = true;
                    break;
            }
        }
    }


}