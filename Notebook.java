import java.time.DayOfWeek;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Представляет собой записную книжку, содержащую несколько заметок.
 */
public class Notebook {
    private List<Note> notes;

    /**
     * Создает новый объект записной книжки.
     */
    public Notebook() {
        this.notes = new ArrayList<>();
    }

    /**
     * Добавляет новую заметку в блокнот.
     *
     * @param note заметка для добавления
     */
    public void addNote(Note note) {
        notes.add(note);
    }

    /**
     * Получает все заметки за определенный день.
     *
     * @param date Дата, по которой следует фильтровать заметки
     * @return Список заметок за указанный день
     */
    public List<Note> getNotesForDay(LocalDate date) {
        return notes.stream()
                .filter(n -> n.getDate().equals(date))
                .sorted((n1, n2) -> n1.getDate().compareTo(n2.getDate()))
                .collect(Collectors.toList());
    }

    /**
     * Получает все заметки за текущую неделю.
     *
     * @return Список заметок за текущую неделю
     */
    public List<Note> getNotesForWeek() {
        LocalDate now = LocalDate.now();
        LocalDate startOfWeek = now.with(DayOfWeek.MONDAY).minusDays(now.getDayOfWeek().getValue() - 1);
        LocalDate endOfWeek = startOfWeek.plusWeeks(1);

        return notes.stream()
                .filter(n -> n.getDate().isAfter(startOfWeek) && n.getDate().isBefore(endOfWeek))
                .sorted((n1, n2) -> n1.getDate().compareTo(n2.getDate()))
                .collect(Collectors.toList());
    }

    /**
     * Сортирует заметки по дате в порядке возрастания.
     */
    public void sortNotesByDate() {
        Collections.sort(notes, Comparator.comparing(n -> n.getDate()));
    }

    /**
     * Сортирует заметки по названию в порядке возрастания.
     */
    public void sortByTitle() {
        Collections.sort(notes, Comparator.comparing(n -> n.getTitle()));
    }

    /**
     * Получает все заметки
     *
     * @return Список заметок
     */
    public List<Note> getNotes() {
        return new ArrayList<>(notes); 
    }
}
