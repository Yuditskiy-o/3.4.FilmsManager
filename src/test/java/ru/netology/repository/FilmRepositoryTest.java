package ru.netology.repository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmItem;

import static org.junit.jupiter.api.Assertions.*;

class FilmRepositoryTest {
    FilmRepository repository = new FilmRepository();
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

    @Test
    public void shouldFindAllFilms() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);
        FilmItem[] expected = new FilmItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        FilmItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyIfNoFilms() {
        FilmItem[] expected = new FilmItem[]{};
        FilmItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveFilms() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        FilmItem[] expected = new FilmItem[]{first, second, third, fourth, fifth};
        FilmItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindIfFilmExists() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        int requestedId = 4;
        repository.findById(requestedId);
        FilmItem expected = fourth;
        FilmItem actual = repository.findById(requestedId);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNullIfFilmNotExists() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        int requestedId = 6;
        repository.findById(requestedId);
        FilmItem expected = null;
        FilmItem actual = repository.findById(requestedId);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfExists() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        int removeId = 5;
        repository.removeById(removeId);
        FilmItem[] actual = repository.findAll();
        FilmItem[] expected = new FilmItem[]{first, second,third, fourth};
        assertArrayEquals(expected, actual);
    }

    @Disabled
    @Test
    public void shouldNotRemoveIfNotExists() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        int removeId = 6;
        repository.removeById(removeId);
        FilmItem[] expected = new FilmItem[]{first, second,third, fourth, fifth};
        FilmItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.removeAll();
        FilmItem[] expected = new FilmItem[]{};
        FilmItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}