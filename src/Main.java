import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class Main {
    public static void main(String[] args) throws Exception {
        // Does the main function functions?
        // System.out.println("Hello World!");
        
        // Create a scanner object
        Scanner sc = new Scanner(System.in);

        System.out.println("Willkommen bei HangmenHD.\nEin Spiel von Team HSS(c).\n\n");
        System.out.print("Name: ");
        String playerName = sc.nextLine();
        System.out.print("Alter: ");
        int playerAge = sc.nextInt();
        if (playerAge < 18)
        {
            System.out.println("Das Spiel enthält nicht jugenfreie Bilder.\nLeider darfst du es nicht spielen.\nTschüss");
            System.exit(1);
        }
        Player player1 = new Player(playerName, playerAge);

        System.out.println("Hallo, " + player1.getName() + "\n");
        System.out.println("Gesucht wird ein Wort aus der Kategorie: ");
        // Create a word list as a test array
        ArrayList<String> words = new ArrayList<String>(Arrays.asList(
            "Mathe",
            "EnGlisSch",
            "Spanisss",
            "Epstein did not kill himself"
        ));
        
        // Pick a random word from the array
        String hidden_word = words.get((int)(Math.random() * words.size()));

        char[] hidden_char = hidden_word.toCharArray();
        
        char[] user_answer = new char[hidden_char.length];
        int points = 0;

        for (int i = 0; i < hidden_char.length; i++)
        {
            // Filler for the array in order to show "_" symbols
            user_answer[i] = '?';
        }
        
        for (int i = 0; i < hidden_char.length; i++)
        {
            System.out.print(hidden_char[i]);
        }

        System.out.println();
        int lives = 6;
        boolean finished = false;
        
        while (finished == false) // start game loop
        {
            if (lives == 6)
            {
                System.out.println("  ________");
                System.out.println("  /");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println(" /|\\\n");
            }
            if (lives == 5)
            {
                System.out.println("  ________");
                System.out.println("  /     o");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println(" /|\\\n");
            }
            if (lives == 4)
            {
                System.out.println("  ________");
                System.out.println("  /     o");
                System.out.println("  |     |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println(" /|\\\n");
            }
            if (lives == 3)
            {
                System.out.println("  ________");
                System.out.println("  /     o");
                System.out.println("  |   --|");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println(" /|\\\n");
            }
            if (lives == 2)
            {
                System.out.println("  ________");
                System.out.println("  /     o");
                System.out.println("  |   --|--");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println(" /|\\\n");
            }
            if (lives == 1)
            {
                System.out.println("  ________");
                System.out.println("  /     o");
                System.out.println("  |   --|--");
                System.out.println("  |    /");
                System.out.println("  |");
                System.out.println(" /|\\\n");
            }


            System.out.println("Leben: " + lives + "\n");
            System.out.print("Gesucht: ");
            for (int i = 0; i < user_answer.length; i++)
            {
                // Print _ if found in the array
                // if letter found, print the letter
                if (user_answer[i] == '?')
                {
                    System.out.print("_ ");
                }
                else
                {
                    System.out.print(user_answer[i] + " ");
                }
            }
            System.out.println();
            
            String input;

            do
            {
                System.out.print("Eingabe: ");
                input = sc.nextLine();
                    if (input.length() != 1 || Character.isDigit(input.charAt(0)))
                    {
                        System.out.println("Error! BEEP BOOP");
                        System.out.println("Nur einzelne Buchstaben sind erlaubt.\n");
                    }
            }
            while (input.length() != 1 || Character.isDigit(input.charAt(0)));
            boolean treffer = false;
            for (int i = 0; i < hidden_char.length; i++) 
            {
                if (input.charAt(0) == hidden_char[i])
                {
                    user_answer[i] = hidden_char[i];
                    treffer = true;
                    points++;
                }
            }

            // winning condition
            if (points == hidden_word.length())
            {
                System.out.println("Gesucht: " + hidden_word + "\n");
                System.out.println("Juhu, du hast gewonnen!");
                finished = true;
            }
            if (!treffer)
            {
                lives--;
            }
            if (lives == 0)
            {
                System.out.println("  ________");
                System.out.println("  /     o");
                System.out.println("  |   --|--");
                System.out.println("  |    / \\");
                System.out.println("  |");
                System.out.println(" /|\\\n");
                System.out.println("Du baummelst in der Schlinge...");
                finished = true;
            }


        } // end game loop


        
    }
}
