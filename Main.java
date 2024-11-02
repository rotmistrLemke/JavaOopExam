import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * Основной класс, который запускает приложение notebook.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Notebook model = new Notebook();
        ConsoleNotebookView view = new ConsoleNotebookView();
        NotebookPresenter presenter = new NotebookPresenter(model, view);

        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить запись");
            System.out.println("2. Отобразить все записи");
            System.out.println("3. Отобразить записи для дня");
            System.out.println("4. Отобразить записи для недели");
            System.out.println("5. Сортировка по дате");
            System.out.println("6. Сортировка по названию");
            System.out.println("7. Сохранить в файл");
            System.out.println("8. Загрузить из файла");
            System.out.println("9. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очищаем входной буфер после чтения числа

            switch (choice) {
                case 1:
                    System.out.print("Введите заголовок записи: ");
                    String title = scanner.nextLine();
                    System.out.print("Введите дату (формат yyyy-MM-dd): ");
                    String dateString = scanner.nextLine();
                    presenter.addNote(title, dateString);
                    break;
                case 2:
                    presenter.displayAllNotes();
                    break;
                case 3:
                    System.out.print("Введите дату (формат yyyy-MM-dd): ");
                    String dayString = scanner.nextLine();
                    presenter.displayNotesForDay(dayString);
                    break;
                case 4:
                    presenter.displayNotesForWeek();
                    break;
                case 5:
                    presenter.sortNotesByDate();
                    break;
                case 6:
                    presenter.sortByTitle();
                    break;
                case 7:
                    FileService.saveNotesToFile(presenter.model.getNotes());
                    System.out.println("Записи сохранены в файл.");
                    break;
                case 8:
                    try {
                        List<Note> loadedNotes = FileService.loadNotesFromFile();
                        for (Note note : loadedNotes) {
                            presenter.addNote(note.getTitle(), note.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                        }
                        System.out.println("Записи загружены из файла.");
                    } catch (IOException e) {
                        System.err.println("Ошибка при загрузке из файла: " + e.getMessage());
                    }
                    break;
                case 9:
                    System.out.println("Всего хорошего! До свидания!");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }

            // Проверка наличия записей перед отображением
            if (presenter.model.getNotes().isEmpty()) {
                view.displayNoNotes();
            }
        }
    }
}
