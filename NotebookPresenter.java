import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Управляет взаимодействием между моделью (Notebook) и представлением (NotebookView).
 */
public class NotebookPresenter {
    Notebook model;
    private NotebookView view;

    /**
     * Создает новый объект NotebookPresenter.
     *
     * @param model   Модель записной книжки
     * @param view    отображение записной книжки
     */
    public NotebookPresenter(Notebook model, NotebookView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Добавляет новую заметку в блокнот и отображает ее.
     *
     * @param title Название заметки
     * @param dateString Строка даты в формате "yyyy-MM-dd"
     */
    public void addNote(String title, String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        model.addNote(new Note(title, date));
        view.displayNote(model.getNotes().get(model.getNotes().size() - 1));
    }




    
    /**
     * Отображает все заметки в записной книжке.
     */
    public void displayAllNotes() {
        List<Note> notes = model.getNotes();
        view.displayNotebook(notes);
    }

    /**
     * Отображает заметки за определенный день.
     *
     * @param dateString 
     */
    public void displayNotesForDay(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        List<Note> notes = model.getNotesForDay(date);
        if (notes.isEmpty()) {
            view.displayNoNotes();
        } else {
            view.displaySortedNotes(notes);
        }
    }

    /**
     * Отображает заметки за текущую неделю.
     */
    public void displayNotesForWeek() {
        List<Note> notes = model.getNotesForWeek();
        if (notes.isEmpty()) {
            view.displayNoNotes();
        } else {
            view.displaySortedNotes(notes);
        }
    }

    /**
     * Сортирует заметки по дате и отображает их.
     */
    public void sortNotesByDate() {
        model.sortNotesByDate();
        view.displaySortedNotes(model.getNotes());
    }

    /**
     * Сортирует заметки по названию и отображает их на экране.
     */
    public void sortByTitle() {
        model.sortByTitle();
        view.displaySortedNotes(model.getNotes());
    }
}
