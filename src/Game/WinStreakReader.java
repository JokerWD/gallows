package Game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WinStreakReader {

    private static final String WIN_STREAK_FILE = "win_streak.txt";
    public int loadWinStreak(){
        Path filePath = Paths.get(WIN_STREAK_FILE);
        try {
            if(Files.exists(filePath)){
                String content = Files.readString(filePath);
                return Integer.parseInt(content.trim());
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Ошибка заргрузки файла" + e.getMessage());
        }
        return  0;
    }
    public void saveWinStreak(int winStreak){
        Path filePath = Paths.get(WIN_STREAK_FILE);
        try {
            Files.writeString(filePath, Integer.toString(winStreak));
        } catch (IOException e) {
            System.err.println("Ошибка при сохранение файла " + e.getMessage());
        }
    }
}
