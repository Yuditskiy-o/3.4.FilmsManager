package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmItem;

import static org.junit.jupiter.api.Assertions.*;

public class FilmManagerContainsMoreDefaultTest {
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
    private FilmItem eleventh = new FilmItem(11, "28 дней спустя", "ужасы");
    private FilmItem twelfth = new FilmItem(12,"1+1","драма");
    private FilmItem thirteenth = new FilmItem(13,"Начало","фантастика");
    private FilmItem fourteenth = new FilmItem(14,"Престиж","фантастика");
    private FilmItem fifteenth = new FilmItem(15,"Гладиатор","боевик");
    private FilmItem sixteen = new FilmItem(16,"Отступники","триллер");


    @BeforeEach
    public void setUp() {
        manager = new FilmManager(15);
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
        manager.filmAdd(twelfth);
        manager.filmAdd(thirteenth);
        manager.filmAdd(fourteenth);
        manager.filmAdd(fifteenth);
    }

    @Test
    public void shouldDisplayLastFifteenIfFifteen() {
        FilmItem[] expected = new FilmItem[]{fifteenth, fourteenth, thirteenth, twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDisplayLastFifteenIfMoreFifteen() {
        manager.filmAdd(sixteen);
        FilmItem[] expected = new FilmItem[]{sixteen, fifteenth, fourteenth, thirteenth, twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}










