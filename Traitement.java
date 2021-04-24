import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.File;

class Traitement  // CLASSE SANS CONSTRUCTEUR CAR CRÉATION OBJET NON UTILES 
{
    static private  String nomFichier = ".cache" ; // STATIC CAR LIER A AUCUN OBJET  PRIVATE CAR NE DOIT PAS ETRE MODIFIER 

    public static void  ajoutCache(String date , String nom , int nombre  )  // METHODE D'AJOUT AU FICHIER CACHE STATIC CAR NON LIER A UN OBJET 
    {
        try 
        {
            FileWriter fichier = new FileWriter(nomFichier,true);     //  PARAMETTRE TRUE  CAR LE FICHIER EXISTE DEJA 
            fichier.append( date +";"+ nom +";"+ nombre + "\n") ;     // AJOUT DES INFO AU FICHIER  \N  POUR RETOUR A LA LIGNE
            fichier.close();                                         // FERMETURE DU FICHIER POUR L'ENVOIE ENTRE LE FICHIER LOGIQUE ET PHYSIQUE 
                                                                    //  MULTIPLE OUVERTURE ET FERMETURE NON OPTI MAIS OBLIGATOIRE DU SYSTEM.EXIT      
        } 
        catch (Exception e ) 
        {
            System.out.println("Erreur d'ecriture fichier ");
        }    
    }

    public static Boolean verificationDepuisCache(String chaine )  // METHODE QUI VÉRIFIE SI LA CHAINE PASSER EST PRÉSENTE DANS LE FICHIER SI OUI RETOUR TRUE 
    {
        String ligne ; 
        
        try
        {
	        BufferedReader lectureFichier = new BufferedReader(new FileReader(nomFichier));
            while ((ligne = lectureFichier.readLine()) != null)  // PARCOURS FICHIER LIGNE PAR LIGNE 
            {
                String[] elementLigne = ligne.split(";", 3); // SEGMENTATION LIGNE PAR 3 GRACE  AU DÉLIMITEUR ";" ET STOCKAGE DANS UN TABLEAU
  
               if (chaine.equals(elementLigne[1])) // SI LA CHAINE = L'ÉLÉMENT DU TABLEAU  SA VEUT DIRE LA REQUETE A DEJA ETAIS RÉALISER ET LE FICHIER CONTIENT DEJA LES INFOS 
               {
                    System.out.println("calcul effectuer le "+ elementLigne[0] + " retournant le resultat de " + elementLigne[2] +" characteres unique dans la chaine ");
                    lectureFichier.close(); // ON FERME LE FICHIER 
                    return true ;  // ON RETOURNE TRUE CAR LE FICHIER CONTENNER BIEN LES INFOS 
               }
            }
            lectureFichier.close();
        }
        catch(Exception exc)
        {
	        System.out.println("Erreur d'ouverture fichier ");
        }
        
        return false ;  // ON RETOURE FALSE SI LE FICHIER NE CONTIENT PAS LES INFOS 
        
    }

    public static  int calcul(String chaine ) // METHODE QUI PREND EN PARAMETTRE UNE CHAINE ET RETOURNE LE NOMBRE DE CHARACTERE UNIQUE
    {
        ArrayList<Character> liste = new ArrayList<>();  // CRÉATION D'UNE "liste" DE TYPE ARRAYLIST QUI VAS PRENDRE CHAQUE CHARACTERES DE LA CHAINE

        for (int i =0 ; i <chaine.length(); i++) // PARCOUR DE LA CHAINE 
            liste.add(chaine.charAt(i)); // AJOUT DES CHARACTERES DE LA CHAINE A LA LISTE
            int nombre = 0 ;   // COMPTEUR
            for  (Character el1 : liste) // PARCOUR LA LISTE 
            {   
                int i = 0 ;    // COMPTEUR 
                for ( Character el2 : liste ) // PARCOUR LA LISTE 
                { 
                    if (el2.equals(el1))  // SI ÉLÉMENT DE LA 1ER BOUCLE VAUT ÉLÉMENT DE LA 2EME 
                        i++ ;             // INCREMENTE COMPTEUR "i"
                }
               if (i == 1 )             // SI "i" VAUT 1 
                    nombre ++ ;     //INCREMENTE  COMPTEUR "nombre"
            }
            return nombre;       // RETOURNE  "nombre "
    }  
      public static void cache()  // METHODE QUI CRÉE LE FICHIER CACHE  OU LE SUPPRIME SI SON POID ET TROP IMPORTANT 
      {
        File fichier =new File(nomFichier); //APPELLE FICHIER 
        if(fichier.exists()) // VÉRIFICATION SI IL EXISTE 
        {
            double bytes = fichier.length(); // RÉCUPÉRATION DU POIDS EN OCTETS
            double kilobytes = bytes / 1000; // CALCUL DU POIDS EN KILO OCTETS
            if (kilobytes >= 100)  // SI LE POIDS EST SUPPÉRIEUR A 100 KO 
                fichier.delete();  // ON DÉTRUIT LE FICHIER       
        }
        else  // SI LE FICHIER EXISTE PAS 
        {   
            try 
            {
                fichier.createNewFile(); // ON LE CRÉE 
            }
            catch(Exception e )  // CAPTURE DES EXCEPTION LIER A LA CRÉATION DU FICHIER 
            {
                System.out.println("impossible de crée le fichier ");
            }
        }   
       
      }
}