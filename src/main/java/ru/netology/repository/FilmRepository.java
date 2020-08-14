package ru.netology.repository;

import ru.netology.domain.FilmItem;

public class FilmRepository {
    private FilmItem[] films = new FilmItem[0];

    public FilmItem[] findAll() {
        return films;
    }

    public void save(FilmItem film) {
        int length = films.length + 1;
        FilmItem[] tmp = new FilmItem[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public FilmItem findById(int id) {
        for (FilmItem film : films) {
            if (film.getId() == id) {
                return film;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = films.length - 1;
        FilmItem[] tmp = new FilmItem[length];
        int index = 0;
        for (FilmItem film : films) {
            if (film.getId() != id) {
                tmp[index] = film;
                index++;
            }
        }
        films = tmp;
    }

    public void removeAll() {
        films = new FilmItem[0];
    }
}
