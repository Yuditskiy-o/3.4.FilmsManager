package ru.netology.manager;

import ru.netology.domain.FilmItem;
import ru.netology.repository.FilmRepository;

public class FilmManager {
    private FilmRepository repository;
    private int defaultFilmCount = 10;
    private int filmCount;

    public FilmManager(FilmRepository repository) {
        this.repository = repository;
    }

    public FilmManager(FilmRepository repository, int filmCount) {
        this.repository = repository;
        this.filmCount = filmCount;
    }

    public void filmAdd(FilmItem film) {
        repository.save(film);
    }

    public FilmItem[] getAll() {
        FilmItem[] filmsInRepository = repository.findAll();
        int requestedFilms = filmsInRepository.length;

        if (filmCount == 0) {
            if (defaultFilmCount < filmsInRepository.length) {
                requestedFilms = defaultFilmCount;
            }
        } else {
            if (filmCount < filmsInRepository.length) {
                requestedFilms = filmCount;
            }
        }

        FilmItem[] result = new FilmItem[requestedFilms];
        for (int f = 0; f < result.length; f++) {
            int index = filmsInRepository.length - f - 1;
            result[f] = filmsInRepository[index];
        }
        return result;
    }
}
