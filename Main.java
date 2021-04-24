import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

class Main 
{
    public static void main(String[] args)
    {
        Scanner message = new Scanner(System.in);
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm");
       
        do {
            System.out.println("Entrez une chaine de charactéres ou 'exit' pour mettre fin au programme : ");
            try
            {    
                String chaine = message.nextLine() ; 
                if (chaine.equals("exit"))
                    System.exit(0);
                if (!Traitement.verification(chaine)) 
                {
                    Date date = new Date();
                    int calcul = Traitement.calcul(chaine) ; 
                    Traitement.ajout(s.format(date), chaine , calcul );
                    System.out.println(chaine + " contient "+ calcul +" characteres unique ");
                }
            }
            catch(Exception e ) 
            {
                System.out.println("Erreur .... ");
            }

        } while (true);
    }

}