import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean playAgain = false;
        String repeat;

        do {

            Scanner keyboard = new Scanner(System.in);

            System.out.println("please enter a word or phrase, and i will remove any duplicate characters:");
            String input = keyboard.nextLine();

            unrepeated(input);

            // menu
            System.out.println("would you like to play again? (yes/no)");
            do {
                repeat = keyboard.nextLine();
                if (repeat.equals("yes")) {
                    playAgain = true;
                } else if (!repeat.equals("no")) {
                    System.out.println("sorry, please enter a valid input (yes/no):");
                }
            } while (!repeat.equals("yes") && !repeat.equals("no"));

        }
        while (playAgain);
    }

    /*
     - array of characters
     - check through all letters in the word/phrase and see if they are in char array
     - if they already exist, ignore and move on to next char
     - else, add the letter to the array
     - variable for how many letters have been changed in the array (to not print out empty spaces)
     - variable to remember where you are in the char array / what values have been changed

     */

    public static void unrepeated(String word) {

        int length = word.length();
        int printnum = length-1;
        int counter = 0;

        char[] usedchars = new char[length];

        // goes through each letter individually in the word/phrase
        for (int i = 0; i < length; i++) {


            // resets boolean value to false for each letter, otherwise it will still be true from the last duplicate letter
            boolean used = false;

            // checks if word(i) has already been used (looks through chars in char array)
            for (int j  = 0; j < length; j++) {


                if (word.charAt(i) == usedchars[j]) {

                    //changing the amount of values which will be printed from the already used array (the chars at the end are empty spaces or 0's and should be printed)
                    printnum--;
                    used = true;

                    if (word.charAt(i) == ' ') {
                        if (word.charAt(i-1) != ' ') {
                            used = false;
                            printnum++;
                        }
                    }

                    break;
                }
            }
            // adds the new characters to the already used array
            if (!used) {
                usedchars[counter] = word.charAt(i);
                counter++;
            }
        }

        // printing everything
        for (int i = 0; i<= printnum; i++) {
            if (usedchars[i] == ' ' && usedchars[i-1] == ' ') {
                continue;
            }
            System.out.print(usedchars[i]);
        }

        System.out.println();


    }

}