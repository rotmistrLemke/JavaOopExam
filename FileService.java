import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Предоставляет методы сохранения и загрузки заметок из/в файл.
 */
public class FileService {
    private static final String FILE_NAME = "notes.txt";

    /**
     * Сохраняет все заметки в файл.
     *
     * @param notes Список заметок для сохранения
     * @throws IOException при возникновении ошибки ввода-вывода
     */
    public static void saveNotesToFile(List<Note> notes) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Note note : notes) {
                writer.write(note.getTitle() + "," + note.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + "\n");
            }
        }
    }

    /**
     * Загружает заметки из файла.
     *
     * @return Список загруженных заметок
     * @throws IOException при возникновении ошибки ввода-вывода
     */
    public static List<Note> loadNotesFromFile() throws IOException {
        List<Note> notes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String title = parts[0];
                    String dateString = parts[1];
                    notes.add(new Note(title, LocalDate.parse(dateString.substring(0, 10), DateTimeFormatter.ISO_LOCAL_DATE)));

                }
            }
        }
        return notes;
    }
}
