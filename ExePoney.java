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
            System.out.println("| 6. Quitter                  |");
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
            System.out.println("| 3. Lister les Cours         |");
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

                case 3 :
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
                    AppPoney.getPoney(c);
                    break;

                case 2 :
                    System.out.println("Veuillez remplir ces informations :"+"\n");

                    System.out.println("Nom du Poney : ");
                    String nomP = String.valueOf(System.console().readLine());

                    System.out.println("La robe du Poney : ");
                    String robe = String.valueOf(System.console().readLine());

                    System.out.println("La date de naissance du Poney (YYYY-MM-DD) : ");
                    String DDNP = String.valueOf(System.console().readLine());

                    System.out.println("La discipline du Poney : ");
                    String disciplineP = String.valueOf(System.console().readLine());

                    System.out.println("Le nombre d'années de service du Poney : ");
                    int anneService = Integer.valueOf(System.console().readLine());

                    try{
                        AppPoney.addPoney(c, nomP, robe, DDNP, disciplineP, anneService);
                    }
                    catch(SQLException e){
                        System.out.println("Erreur :/"); 
			            System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Entrer l'identifiant du Poney à supprimer (min=100): ");
                    int idp = Integer.valueOf(System.console().readLine());

                    try{
                        AppPoney.remPoney(c, idp);
                    }
                    catch(SQLException e){
                        System.out.println("Erreur :/"); 
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Entrer l'identifiant du Poney à modifier (min=100): ");
                    int ModIdp = Integer.valueOf(System.console().readLine());

                    System.out.println("Nom du Poney : ");
                    String NewNomP = String.valueOf(System.console().readLine());

                    System.out.println("La robe du Poney : ");
                    String NewRobe = String.valueOf(System.console().readLine());

                    System.out.println("La date de naissance du Poney (YYYY-MM-DD) : ");
                    String NewDDNP = String.valueOf(System.console().readLine());

                    System.out.println("La discipline du Poney : ");
                    String NewDisciplineP = String.valueOf(System.console().readLine());

                    System.out.println("Le nombre d'années de service du Poney : ");
                    int NewAnneService = Integer.valueOf(System.console().readLine());

                    try{
                        AppPoney.modifPoney(c,ModIdp, NewNomP, NewRobe, NewDDNP, NewDisciplineP, NewAnneService);
                    }
                    catch(SQLException e){
                        System.out.println("Erreur :/"); 
			            System.out.println(e.getMessage());
                    }
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
                AppPoney.getPersonne(c);
                break;

            case 2 :
                    System.out.println("Veuillez remplir ces informations :"+"\n");

                    System.out.println("Nom de la Personne : ");
                    String nom = String.valueOf(System.console().readLine());

                    System.out.println("Prenom de la Personne : ");
                    String prenom = String.valueOf(System.console().readLine());

                    System.out.println("La date de naissance de la Personne (YYYY-MM-DD) : ");
                    String DDN = String.valueOf(System.console().readLine());

                    try{
                        AppPoney.addPersonne(c, nom, prenom, DDN);
                    }
                    catch(SQLException e){
                        System.out.println("Erreur :/"); 
			            System.out.println(e.getMessage());
                    }
                break;

            case 3:
                    System.out.println("Entrer l'identifiant de la personne à supprimer (min=1): ");
                    int idPersonne = Integer.valueOf(System.console().readLine());

                    try{
                        AppPoney.remPersonne(c, idPersonne);
                    }
                    catch(SQLException e){
                        System.out.println("Erreur :/"); 
                        System.out.println(e.getMessage());
                    }
                break;

            case 4:
                System.out.println("Entrer l'identifiant de la personne à modifier (min=1): ");
                int ModidPersonne = Integer.valueOf(System.console().readLine());

                System.out.println("Nom de la Personne : ");
                String NewNom = String.valueOf(System.console().readLine());

                System.out.println("prenom de la Personne : ");
                String NewPrenom = String.valueOf(System.console().readLine());

                System.out.println("La date de naissance de la Personne (YYYY-MM-DD) : ");
                String NewDDN = String.valueOf(System.console().readLine());

                try{
                    AppPoney.modifPersonne(c, ModidPersonne, NewNom, NewPrenom, NewDDN);
                }
                catch(SQLException e){
                    System.out.println("Erreur :/"); 
                    System.out.println(e.getMessage());
                }
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
                    AppPoney.getEleve(c);
                    break;

                case 2 :
                    System.out.println("Veuillez remplir ces informations :"+"\n");

                    System.out.println("Identifiant de la Personne : ");
                    int idPersonne = Integer.valueOf(System.console().readLine());

                    System.out.println("Poids de l'Eleve (kg) : ");
                    int poids = Integer.valueOf(System.console().readLine());

                    System.out.println("galop de l'Eleve : ");
                    int galop = Integer.valueOf(System.console().readLine());

                    System.out.println("taille de l'Eleve (cm) : ");
                    int taille = Integer.valueOf(System.console().readLine());

                    try{
                        AppPoney.addEleve(c, idPersonne, poids, galop, taille);
                    }
                    catch(SQLException e){
                        System.out.println("Erreur :/"); 
			            System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Entrer l'identifiant de l'Eleve à supprimer (min=1000): ");
                    int ide = Integer.valueOf(System.console().readLine());

                    try{
                        AppPoney.remPersonne(c, ide);
                    }
                    catch(SQLException e){
                        System.out.println("Erreur :/"); 
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Entrer l'identifiant de l'Eleve à modifier (min=1000): ");
                    int Modide = Integer.valueOf(System.console().readLine());

                    System.out.println("Identifiant de l'Eleve : ");
                    int NewIdPersonne = Integer.valueOf(System.console().readLine());

                    System.out.println("Poids de l'Eleve (kg) : ");
                    int NewPoids = Integer.valueOf(System.console().readLine());

                    System.out.println("galop de l'Eleve : ");
                    int NewGalop = Integer.valueOf(System.console().readLine());

                    System.out.println("taille de l'Eleve (cm) : ");
                    int NewTaille = Integer.valueOf(System.console().readLine());

                    try{
                        AppPoney.modifEleve(c, Modide, NewIdPersonne, NewPoids, NewGalop, NewTaille);
                    }
                    catch(SQLException e){
                        System.out.println("Erreur :/"); 
                        System.out.println(e.getMessage());
                    }
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
                    AppPoney.getMoniteur(c);
                    break;

                case 2 :
                    System.out.println("Veuillez remplir ces informations :"+"\n");

                    System.out.println("Identifiant de la Personne : ");
                    int idPersonne = Integer.valueOf(System.console().readLine());

                    System.out.println("License du Moniteur : ");
                    String license = String.valueOf(System.console().readLine());

                    System.out.println("Description du Moniteur : ");
                    String descriptionM = String.valueOf(System.console().readLine());

                    try{
                        AppPoney.addMoniteur(c, idPersonne, license, descriptionM);
                    }
                    catch(SQLException e){
                        System.out.println("Erreur :/"); 
			            System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Entrer l'identifiant du Moniteur à supprimer (min=200): ");
                    int idm = Integer.valueOf(System.console().readLine());

                    try{
                        AppPoney.remMoniteur(c, idm);
                    }
                    catch(SQLException e){
                        System.out.println("Erreur :/"); 
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Entrer l'identifiant du Moniteur à modifier (min=1000): ");
                    int Modidm = Integer.valueOf(System.console().readLine());

                    System.out.println("Identifiant de la Personne : ");
                    int NewIdPersonne = Integer.valueOf(System.console().readLine());

                    System.out.println("License du Moniteur : ");
                    String NewLicense = String.valueOf(System.console().readLine());

                    System.out.println("Description du Moniteur : ");
                    String NewDescriptionM = String.valueOf(System.console().readLine());


                    try{
                        AppPoney.modifMoniteur(c, Modidm, NewIdPersonne, NewLicense, NewDescriptionM);
                    }
                    catch(SQLException e){
                        System.out.println("Erreur :/"); 
                        System.out.println(e.getMessage());
                    }
                    break;

                default : 
                    finiMoniteur = true;
                    break;
            }
        }
    }
}
