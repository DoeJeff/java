import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

class Main 
{
    public static void main(String[] args)
    {
        Scanner message = new Scanner(System.in);   // CRÉATION OBJET DE TYPE SCANNER 
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm"); // CRÉATION OBJET "s"  DE TYPE FROMATDATE 
        Traitement.cache(); // METHODE QUI CRÉE LE FICHIER CACHE  OU LE SUPPRIME SI SON POID ET TROP IMPORTANT 
       
        do {  // DO WHILE CAR ON VEUT LANCER LE CODE AU MOINS UNE FOIS 
            System.out.println("Entrez une chaine de charactéres ou 'exit' pour mettre fin au programme : ");
            try
            {    
                String chaine = message.nextLine() ; 
                if (chaine.equals("exit"))   // SI LA SAISIE VAUT "exit"  ON FERME PROPREMENT LE PROGRAMME 
                    System.exit(0);
                if (!Traitement.verificationDepuisCache(chaine))  // SI LA SAISIE N'EST PAS DEJA DANS LE FICHIER  (SI LA METHODE RETURN FALSE)
                {
                    Date date = new Date();   // ON CRÉE UN OBJET "date" DE TYPE DATE POUR AVOIR LA DATE ACTUELLE 
                    int calcul = Traitement.calcul(chaine) ;  // ON CACUL LE NOMBRE DE CHARACTÉRES UNIQUE DANS LA CHAINE 
                    Traitement.ajoutCache(s.format(date), chaine , calcul ); // ON AJOUTE AU FICHIER LES NOUVELLE INFO (DATE , CHAINE , LE RÉSULTAT DU CALCUL)
                    System.out.println(chaine + " contient " +  calcul + " characteres unique "); // ON AFFICHE A L'UTILISATEUR  LA CHAINE SAISIE ET SON NOMBRE DE CHARACTERES UNIQUE
                }
            }
            catch(Exception e )   // CAPTURE DES EXCEPTION GENERAL (C'EST MAL )  EN CAS PROBLEME 
            {
                System.out.println("Erreur .... ");
            }

        } while (true); // TRUE  CAR ON VEUT UNE BOUCLE INFI JUSQU'A CE QUE L'UTILSATEUR TAPE "exit" 
        
    }

}