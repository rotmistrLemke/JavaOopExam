import java.util.List;

/**
 * Реализует интерфейс NotebookView для консольного вывода.
 */
public class ConsoleNotebookView implements NotebookView {
    private NotebookPresenter presenter;

/**
     * Создает новый объект ConsoleNotebookView без презентера.
     */
    public ConsoleNotebookView() {
        this.presenter = new NotebookPresenter(new Notebook(), this);
    }

    /**
     * Создает новый объект ConsoleNotebookView.
     *
     * @param presenter Презентер записной книжки
     */
    public ConsoleNotebookView(NotebookPresenter presenter) {
        this.presenter = presenter;
    }


   

    @Override
    public void displayNotebook(List<Note> notes) {
        System.out.println("Ваша записная книжка:");
        System.out.println("------------------");
        for (Note note : notes) {
            System.out.println(note.getTitle());
        }
     }
    

    @Override
    public void displayNote(Note note) {
        System.out.println("Добавлена новая запись:");
        System.out.println("------------------------");
        System.out.println(note.getTitle());
    }

    @Override
    public void displayNoNotes() {
        System.out.println("В заметочнике пока нет записей.");
    }

    @Override
    public void displaySortedNotes(List<Note> sortedNotes) {
        System.out.println("\nСортировка завершена:");
        System.out.println("---------------------");
        for (Note note : sortedNotes) {
            System.out.println(note.getTitle());
        }
    }

    @Override
    public void displayFilteredNotes(List<Note> filteredNotes) {
        System.out.println("\nФильтрация завершена:");
        System.out.println("-------------------");
        for (Note note : filteredNotes) {
            System.out.println(note.getTitle());
        }
    }
}
