import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

class Traitement
{
    static private  String nomFichier = ".cache" ; 

    public static void  ajout(String date , String nom , int nombre  )
    {
        try 
        {
            FileWriter fichier = new FileWriter(nomFichier,true); 
            fichier.append( date +";"+ nom +";"+ nombre + "\n") ;  
            fichier.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Erreur ecriture fichier ");
        }    
    }

    public static Boolean verification(String chaine ) 
    {
        String ligne ; 
        
        try
        {
	        BufferedReader lectureFichier = new BufferedReader(new FileReader(nomFichier));
            while ((ligne = lectureFichier.readLine()) != null)
            {
                String[] elementLigne = ligne.split(";", 3);
  
               if (chaine.equals(elementLigne[1]))
               {
                    System.out.println("calcul effectuer le "+ elementLigne[0] + " retournant le resultat de " + elementLigne[2] +" characteres unique dans la chaine ");
                    lectureFichier.close();
                    return true ; 
               }
            }
            lectureFichier.close();
        }
        catch(Exception exc)
        {
	        System.out.println("Erreur d'ouverture fichier ");
        }
        
        return false ; 
        
    }

    public static  int calcul(String chaine )
    {
        ArrayList<Character> liste = new ArrayList<>();

        for (int i =0 ; i <chaine.length(); i++)
            liste.add(chaine.charAt(i));
            int nombre = 0 ;
            for  (Character el1 : liste)
            {   
                int i = 0 ;
                for ( Character el2 : liste )
                { 
                    if (el2.equals(el1))
                        i++ ; 
                }
               if (i == 1 )
                    nombre ++ ; 
            }
            return nombre;
    }  
      
}