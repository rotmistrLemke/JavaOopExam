import java.util.List;

/**
 * Определяет методы отображения данных записной книжки.
 */
public interface NotebookView {
    /**
     * Отображает все содержимое записной книжки.
     */
    void displayNotebook(List<Note> notes);

    /**
     * Отображает одну заметку.
     *
     * @param note заметка для отображения
     */
    void displayNote(Note note);

    /**
     * Отображает сообщение, если заметок нет.
     */
    void displayNoNotes();

    /**
     * Отображает отсортированные заметки.
     *
     * @param sortedNotes Список отсортированных заметок
     */
    void displaySortedNotes(List<Note> sortedNotes);

    /**
     * Отображает отфильтрованные заметки.
     *
     * @param filteredNotes Список отфильтрованных заметок
     */
    void displayFilteredNotes(List<Note> filteredNotes);
}
