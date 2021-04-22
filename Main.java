
import java.util.HashMap;
import java.util.Scanner;


// todo   methode vérification saisie 
class Main 
{
    public static void main(String[] args)
    {
        Scanner message = new Scanner(System.in);
        HashMap <String ,Integer>liste = new HashMap();
        

        do {
            
            System.out.println("Entrez une chaine de charactéres ou 'exit' pour mettre fin au programme : ");
            try
            {    String chaine  = message.nextLine() ; 
                if (chaine.equals("exit"))
                    System.exit(0);
                
                liste.put(chaine,Traitement.calcul(chaine));
                System.out.println(liste);
                Traitement.ajout();
            
            }
            catch(Exception e ) 
            {
                System.out.println("Erreur .... ");
            }
        } while (true);

       
    }

}