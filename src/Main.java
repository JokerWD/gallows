import Game.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printWelcomeMessage();
        Game game = null;
        Scanner scanner = new Scanner(System.in);
        String inputUser = scanner.nextLine();
        if(inputUser.equals("1")){
            System.out.println("Введите слова, разделенные пробелами, и нажмите Enter:");
            inputUser = scanner.nextLine().toLowerCase();
            String[] inputWords = inputUser.split("\\s+");
            game = new Game(inputWords);
        }else{
            game = new Game();
        }
        game.play();
    }

    private static void printWelcomeMessage(){
        System.out.println("Добро пожаловать в игру Виселица!");
        System.out.println("У вас есть 5 попыток");
        System.out.println("Хотите ли вы задать список слов? 1 - да, 0 - нет ");
    }

}
