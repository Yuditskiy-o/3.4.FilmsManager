package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.FilmItem;
import ru.netology.repository.FilmRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FilmManagerContainsLessDefaultTest {
    @Mock
    private FilmRepository repository;
    @InjectMocks
    private FilmManager manager = new FilmManager(repository);
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
        manager = new FilmManager(repository, 5);
    }

    @Test
    public void shouldDisplayLastFiveIfFive() {
        FilmItem[] returned = new FilmItem[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{fifth, fourth, third, second, first};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldDisplayLastFiveIfMoreFive() {
        FilmItem[] returned = new FilmItem[]{sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{tenth, ninth, eighth, seventh, sixth};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }
}
