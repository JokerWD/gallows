import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class gallows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        int attempts = 5;
        StringBuilder guessesWord = initializeGuessesWord(word);
        Set<Character> enteredLetters = new HashSet<>();

        while (attempts > 0 && !isComplete(guessesWord)){
            printCurrentState(guessesWord, attempts);
            char letter = getUserInput(scanner);
            if(enteredLetters.contains(letter)){
                System.out.println("----------------------------------------");
                System.out.println("Ты уже вводил эту букву, попробуй другую");
                System.out.println("----------------------------------------");
                continue;
            }

            enteredLetters.add(letter);

            boolean found = checkAndUpdateLatter(word, guessesWord, letter );
            if(!found){
                attempts--;
            }
        }
        printResult(isComplete(guessesWord), word);
    }
    private static StringBuilder initializeGuessesWord(String word){
        StringBuilder guessesWord = new StringBuilder(word.length());
        word.chars().forEach(c -> guessesWord.append('_'));
        return guessesWord;
    }
    private static void printCurrentState(StringBuilder guessesWord, int attempts){
        System.out.println("Текущее состояние слова: " + guessesWord);
        System.out.println("Колличество попыток: " + attempts);
    }
    private static char getUserInput(Scanner scanner){
        System.out.print("Введите букву: ");
        return scanner.next().toLowerCase().charAt(0);
    }
    private static boolean checkAndUpdateLatter(String word, StringBuilder guessesWord, char letter){
        boolean found = false;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == letter && guessesWord.charAt(i) == '_'){
                guessesWord.setCharAt(i, letter);
                found = true;
            }
        }
        return found;
    }
    private static boolean isComplete(StringBuilder guessesWord){
        return !guessesWord.toString().contains("_");
    }
    private static void printResult(boolean isComplete, String word){
        if(isComplete){
            System.out.println("Ты победил! Слово: " + word);
        }else {
            System.out.println("Ты проиграл! Слово: " + word);
        }
    }

}
