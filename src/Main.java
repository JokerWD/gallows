import Game.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printWelcomeMessage();
        Game game;
        Scanner scanner = new Scanner(System.in);
        String inputUser = scanner.nextLine();
        if(inputUser.equals("1")){
            System.out.println("Введите слова, разделенные пробелами, и нажмите Enter:");
            inputUser = scanner.nextLine().toLowerCase();
            String[] inputWords = inputUser.split("\\s+");
            game = new Game(inputWords);
        }else if(inputUser.equals("2")){
            System.out.print("Введите название файла: ");
            inputUser = scanner.nextLine();
            game = new Game(inputUser);
        }else {
            game = new Game();
        }
        game.play();
    }

    private static void printWelcomeMessage(){
        System.out.println("Добро пожаловать в игру Виселица!");
        System.out.println("У вас есть 5 попыток");
        System.out.println("Меню");
        System.out.println("1 - Вы сами вводи слова и после чего с этими словами играете");
        System.out.println("2 - Ввести слова из txt файла");
        System.out.println("3 - Играть с шаблонными словами");
    }

}
