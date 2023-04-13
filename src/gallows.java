import java.util.Arrays;
import java.util.Scanner;

public class gallows {
    public static void main(String[] args) {
        String word;
        int attempts = 5;
        try (Scanner scanner = new Scanner(System.in)) {
            word = scanner.nextLine();
        }
        char[] guessesWord = new char[word.length()];
        for (int i = 0; i < guessesWord.length; i++) {
            guessesWord[i] = '_';
        }

        try (Scanner scanner = new Scanner(System.in)) {
            while (attempts > 0 && isComplete(guessesWord)){
                System.out.println("Текущая состояния альфавита " + new String(guessesWord));
                System.out.println("Колличество попыток " + attempts);
                System.out.println("Введите букву: ");
                char letter = scanner.next().toLowerCase().charAt(0);

                boolean found = false;
                for (int i = 0; i < word.length(); i++) {
                    if(word.charAt(i) == letter && guessesWord[i] == '_'){
                        guessesWord[i] = letter;
                        found = true;
                    }
                }
                if(!found){
                    attempts --;
                }
            }
        }

    }
    private static boolean isComplete(char[] guessedWord){
        for (char value: guessedWord){
            if(value == '_'){
                return true;
            }
        }
        return false;
    }
}
