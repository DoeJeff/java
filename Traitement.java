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
            FileWriter fichierCsv = new FileWriter(nomFichier,true); 
            fichierCsv.append( date +";"+ nom +";"+ nombre + "\n") ;  
            fichierCsv.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Erreur fichier ");
        }    
    }

    public static void verification(String nom )
    {
        String ligne ; 
        
        try
        {
	        BufferedReader lecteurAvecBuffer = new BufferedReader(new FileReader(nomFichier));
        }
        catch(Exception exc)
        {
	        System.out.println("Erreur d'ouverture");
        }
        while ((ligne = lecteurAvecBuffer.readLine()) != null)
        {
            System.out.println(ligne);
        }
        lecteurAvecBuffer.close();
        
    }

    public static  int calcul(String data )
    {
        ArrayList<Character> liste = new ArrayList<>();

        for (int i =0 ; i <data.length(); i++)
            liste.add(data.charAt(i));
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