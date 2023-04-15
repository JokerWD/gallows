package Game;
import java.util.Random;

public class Game extends Gallows {
    private static  String[] words;
    public Game(){
        words = new String[]{
                "яблоко", "молоко", "пирожок", "масло"
        };
    }
    public Game(String[] words){
        this.words = words;
    }
    public Game(String fileName){
        WordsFileReader file = new WordsFileReader();
        words = file.readWordsFromFile(fileName).toArray(new String[0]);
    }
    public boolean play(){
        Random random = new Random();
        word = words[random.nextInt(words.length)];
        guessesWord = initializeGuessesWord(word);

        while (attempts > 0 && !isComplete(guessesWord)){
            printCurrentState(guessesWord, attempts);
            letter = getUserInput(scanner);
            if(enteredLetters.contains(letter)){
                printLetterInEntered();
                continue;
            }

            enteredLetters.add(letter);

            found = checkAndUpdateLatter(word, guessesWord, letter);
            if(!found){
                attempts--;
            }
        }
        printResult(isComplete(guessesWord), word);
        System.out.print("Хотите сыграть ещё раз?(y or n): ");
        String userInput = scanner.next();
        if(userInput.equals("y")){
            resetGame();
            return true;
        }else {
            scanner.close();
            return false;
        }

    }
}
