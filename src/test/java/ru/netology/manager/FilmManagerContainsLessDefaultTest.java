package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmItem;

import static org.junit.jupiter.api.Assertions.*;

public class FilmManagerContainsLessDefaultTest {
    private FilmManager manager;
    private FilmItem first = new FilmItem(1, "Бладшот", "боевик");
    private FilmItem second = new FilmItem(2, "Вперёд", "мультфильм");
    private FilmItem third = new FilmItem(3, "Отель «Белград»", "комедия");
    private FilmItem fourth = new FilmItem(4, "Джентльмены", "боевик");
    private FilmItem fifth = new FilmItem(5, "Человек-невидимка", "ужасы");
    private FilmItem sixth = new FilmItem(6, "Тролли. Мировой тур", "мультфильм");
    private FilmItem seventh = new FilmItem(7, "Номер один", "комедия");
    private FilmItem eighth = new FilmItem(8, "Трансформеры", "фантастика");
    private FilmItem ninth = new FilmItem(9, "Дракула", "ужасы");
    private FilmItem tenth = new FilmItem(10, "Побег из Шоушенка", "драма");

    @BeforeEach
    public void setUp() {
        manager = new FilmManager(5);
        manager.filmAdd(first);
        manager.filmAdd(second);
        manager.filmAdd(third);
    }

    @Test
    public void shouldDisplayLastFiveIfFive() {
        manager.filmAdd(fourth);
        manager.filmAdd(fifth);
        FilmItem[] expected = new FilmItem[]{fifth, fourth, third, second, first};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDisplayLastFiveIfMoreFive() {
        manager.filmAdd(sixth);
        manager.filmAdd(seventh);
        manager.filmAdd(eighth);
        manager.filmAdd(ninth);
        manager.filmAdd(tenth);
        FilmItem[] expected = new FilmItem[]{tenth, ninth, eighth, seventh, sixth};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}
