package Game;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WordsFileReader {
    public List<String> readWordsFromFile(String fileName){ // отловить ошибку с файлом если его не возможно найти
        Path filePath = Paths.get(fileName);
        List<String> words = readWordsFromFile(filePath);
        return words;
    }
    private List<String> readWordsFromFile(Path filePath) {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null){
                words.add(line.trim());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return words;
    }
}
