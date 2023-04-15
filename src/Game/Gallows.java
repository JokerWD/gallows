package Game;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public abstract class Gallows {
    private WinStreakReader winStreakReader = new WinStreakReader();
    private int winStreak = 0;
    protected Scanner scanner = new Scanner(System.in);
    protected String word;
    protected int attempts = 5;
    protected StringBuilder guessesWord;
    protected char letter;
    protected boolean found;
    protected Set<Character> enteredLetters =  new HashSet<>();


    public void loadWinStreakFromFile(){
        winStreak = winStreakReader.loadWinStreak();
    }
    protected  StringBuilder initializeGuessesWord(String word){
        return new StringBuilder("_".repeat(word.length()));
    }
    protected  void printCurrentState(StringBuilder guessesWord, int attempts){
        System.out.println("Текущее состояние слова: " + guessesWord);
        System.out.println("Колличество попыток: " + attempts);
    }
    protected void printLetterInEntered(){
        System.out.println("----------------------------------------");
        System.out.println("Ты уже вводил эту букву, попробуй другую");
        System.out.println("----------------------------------------");
    }
    protected  char getUserInput(Scanner scanner){
        System.out.print("Введите букву: ");
        return scanner.next().toLowerCase().charAt(0);
    }
    protected  boolean checkAndUpdateLatter(String word, StringBuilder guessesWord, char letter){
        boolean found = false;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == letter && guessesWord.charAt(i) == '_'){
                guessesWord.setCharAt(i, letter);
                found = true;
            }
        }
        return found;
    }
    protected  boolean isComplete(StringBuilder guessesWord){

        return !guessesWord.toString().contains("_");
    }
    protected  void printResult(boolean isComplete, String word){
        if(isComplete){
            System.out.println("Ты победил! Слово: " + word);
            winStreak++;
        }else {
            System.out.println("Ты проиграл! Слово: " + word);
            winStreak = 0;
        }
        winStreakReader.saveWinStreak(winStreak);
        System.out.println("Текущая серия побед: " + winStreak);
    }
    protected void resetGame(){
        attempts = 5;
        enteredLetters = new HashSet<>();
    }
}
