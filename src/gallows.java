import java.util.Arrays;
import java.util.Scanner;

public class gallows {
    public static void main(String[] args) {
        String word;
        int attempts = 5;
        Scanner scanner = new Scanner(System.in);
        word = scanner.nextLine();

        char[] guessesWord = new char[word.length()];
        for (int i = 0; i < guessesWord.length; i++) {
            guessesWord[i] = '_';
        }

        while (attempts > 0 && !isComplete(guessesWord)){
            System.out.println("Текущая состояния альфавита " + String.valueOf(guessesWord));
            System.out.println("Колличество попыток " + attempts);
            System.out.print("Введите букву: ");
            char letter = scanner.next().toLowerCase().charAt(0);

            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if(word.charAt(i) == letter && guessesWord[i] == '_'){
                    guessesWord[i] = letter;
                    found = true;
                }
            }
            if(!found){
                attempts--;
            }
        }

        scanner.close();
    }

    private static boolean isComplete(char[] guessesWord) {
        for (char c : guessesWord) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }
}
