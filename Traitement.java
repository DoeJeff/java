import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

class Traitement
{
    private String data ;
    private ArrayList liste = new ArrayList<>() ; 
    private Date date = new Date();

    
    public static void  ajout( )
    {
        try 
        {
            FileWriter fichierCsv = new FileWriter(".cache.csv"); 
            fichierCsv.append("date "+ "lorenzo" + 12 + "\n") ;   
            fichierCsv.close();

        } 
        catch (Exception e) 
        {
            System.out.println("Erreur fichier ");
        } 
       
           
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