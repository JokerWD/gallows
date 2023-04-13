import Game.SoloGame;

public class Main {
    public static void main(String[] args) {
        printWelcomeMessage();
        SoloGame soloGame = new SoloGame();
        soloGame.playSolo();
    }

    private static void printWelcomeMessage(){
        System.out.println("Добро пожаловать в игру Виселица!");
        System.out.println("У вас есть 5 попыток");
    }

}
