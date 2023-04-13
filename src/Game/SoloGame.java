package Game;

import java.util.Random;

public class SoloGame extends Gallows {
    private static final String[] WORDS = {
      "яблоко", "молоко", "пирожок", "масло"
    };
    public void playSolo(){
        Random random = new Random();
        word = WORDS[random.nextInt(WORDS.length)];
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
        scanner.close();
        printResult(isComplete(guessesWord), word);
    }
}
