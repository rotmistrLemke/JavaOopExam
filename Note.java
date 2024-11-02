import java.time.LocalDate;

/**
 * Представляет собой отдельную заметку с названием и датой.
 */
public class Note {
    private String title;
    private LocalDate date;

    /**
     * Создает новый объект Note.
     *
     * @param title Название заметки
     * @param date  Дата и время, когда была сделана заметка
     */
    public Note(String title, LocalDate date) {
        this.title = title;
        this.date = date;
    }

    // Геттеры и сеттеры
    public String getTitle() { return title; }
    public LocalDate getDate() { return date; }
}
