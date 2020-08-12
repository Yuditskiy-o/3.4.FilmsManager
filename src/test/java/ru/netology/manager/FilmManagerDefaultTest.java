package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmItem;

import static org.junit.jupiter.api.Assertions.*;

public class FilmManagerDefaultTest {
    private FilmManager manager;
    private FilmItem first = new FilmItem(1, "Бладшот", "боевик");
    private FilmItem second = new FilmItem(2, "Вперёд", "мультфильм");
    private FilmItem third = new FilmItem(3, "Отель «Белград»", "комедия");
    private FilmItem fourth = new FilmItem(4, "Джентльмены", "боевик");
    private FilmItem fifth = new FilmItem(5, "Человек-невидимка", "ужасы");
    private FilmItem sixth = new FilmItem(6, "Тролли. Мировой тур", "мультфильм");
    private FilmItem seventh = new FilmItem(7, "Номер один", "комедия");
    private FilmItem eighth = new FilmItem(8, "Трансформеры", "фантастика");
    private FilmItem ninth = new FilmItem(9, "Дракула","ужасы");
    private FilmItem tenth = new FilmItem(10,"Побег из Шоушенка","драма");
    private FilmItem eleventh = new FilmItem(11, "28 дней спустя","ужасы");

    @BeforeEach
    public void setUp() {
        manager = new FilmManager();
    }

    @Test
    public void shouldAddFilms() {
        manager.filmAdd(first);
        manager.filmAdd(second);
        manager.filmAdd(third);
        manager.filmAdd(fourth);
        manager.filmAdd(fifth);
        manager.filmAdd(sixth);
        manager.filmAdd(seventh);
        manager.filmAdd(eighth);
        manager.filmAdd(ninth);
        manager.filmAdd(tenth);
        FilmItem[] expected = new FilmItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        FilmItem[] actual = manager.getFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMoreDefault() {
        manager.filmAdd(first);
        manager.filmAdd(second);
        manager.filmAdd(third);
        manager.filmAdd(fourth);
        manager.filmAdd(fifth);
        manager.filmAdd(sixth);
        manager.filmAdd(seventh);
        manager.filmAdd(eighth);
        manager.filmAdd(ninth);
        manager.filmAdd(tenth);
        manager.filmAdd(eleventh);
        FilmItem[] expected = new FilmItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        FilmItem[] actual = manager.getFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDisplayLastTenIfTen() {
        manager.filmAdd(first);
        manager.filmAdd(second);
        manager.filmAdd(third);
        manager.filmAdd(fourth);
        manager.filmAdd(fifth);
        manager.filmAdd(sixth);
        manager.filmAdd(seventh);
        manager.filmAdd(eighth);
        manager.filmAdd(ninth);
        manager.filmAdd(tenth);
        FilmItem[] expected = new FilmItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDisplayLastTenIfMore() {
        manager.filmAdd(first);
        manager.filmAdd(second);
        manager.filmAdd(third);
        manager.filmAdd(fourth);
        manager.filmAdd(fifth);
        manager.filmAdd(sixth);
        manager.filmAdd(seventh);
        manager.filmAdd(eighth);
        manager.filmAdd(ninth);
        manager.filmAdd(tenth);
        manager.filmAdd(eleventh);
        FilmItem[] expected = new FilmItem[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDisplayOneIfOne() {
        manager.filmAdd(first);
        FilmItem[] expected = new FilmItem[]{first};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotDisplayFilmsIfNoFilms() {
        FilmItem[] expected = new FilmItem[]{};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDisplayTenByDefaultIfZero() {
        manager = new FilmManager(0);
        manager.filmAdd(first);
        manager.filmAdd(second);
        manager.filmAdd(third);
        manager.filmAdd(fourth);
        manager.filmAdd(fifth);
        manager.filmAdd(sixth);
        manager.filmAdd(seventh);
        manager.filmAdd(eighth);
        manager.filmAdd(ninth);
        manager.filmAdd(tenth);
        FilmItem[] expected = new FilmItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}