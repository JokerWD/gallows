import Game.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean play = true;
        printWelcomeMessage();
        Game game;
        Scanner scanner = new Scanner(System.in);

        int userChoice = getUserChoice(scanner);
        String inputUser;
        switch (userChoice){
            case 1:
                System.out.println("Введите слова, разделенные пробелами, и нажмите Enter:");
                inputUser = scanner.nextLine().toLowerCase();
                String[] inputWords = inputUser.split("\\s+");
                game = new Game(inputWords);
                break;
            case 2:
                System.out.print("Введите название файла: ");
                inputUser = scanner.nextLine();
                game = new Game(inputUser);
                break;
            default:
                game = new Game();
                break;
        }
        game.loadWinStreakFromFile();
        while (play){
            play = game.play();
        }
        scanner.close();
    }

    private static void printWelcomeMessage(){
        System.out.println("Добро пожаловать в игру Виселица!");
        System.out.println("У вас есть 5 попыток");
        System.out.println("Меню");
        System.out.println("1 - Вы сами вводи слова и после чего с этими словами играете");
        System.out.println("2 - Ввести слова из txt файла");
        System.out.println("3 - Играть с шаблонными словами");
    }
    private static int getUserChoice(Scanner scanner){
        int userChoice = -1;
        boolean validInput = false;
        System.out.print("Введите ваш выбор: ");
        do {
            try {
                userChoice = Integer.parseInt(scanner.nextLine());
                validInput = true;
            }catch (NumberFormatException e){
                System.out.print("Введите число!: ");
            }
        }while (!validInput);

        return userChoice;
    }

}
