import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {
        // Does the main function functions?
        System.out.println("Hello World!");
        
        // Create a scanner object
        Scanner sc = new Scanner(System.in);

        // Create a word list as a test array
        ArrayList<String> words = new ArrayList<String>(Arrays.asList(
            "Mathe",
            "Englisch",
            "IT",
            "Spanisss"
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

        while (finished == false)
        {
            System.out.print("Gesucht: ");
            for (int i = 0; i < user_answer.length; i++)
            {
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
            System.out.println("Leben: " + lives);
            String input;

            do
            {
                System.out.print("Eingabe: ");
                input = sc.nextLine();
                    if (input.length() != 1 || Character.isDigit(input.charAt(0)))
                    {
                        System.out.println("Error! Wrong input.");
                        System.out.println("Only single letters are allowed.\n");
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
                System.out.println("You've won the game.");
                // TO DO:
                // show the whole word
                finished = true;
            }
            // declare a variable with length of word
            // increment with every hit
            // if variable is equal to length of word, finish

            if (!treffer)
            {
                lives--;
            }

            if (lives == 0)
            {
                finished = true;
            }

        }
    }
}
