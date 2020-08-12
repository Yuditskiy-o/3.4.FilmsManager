package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.FilmItem;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class FilmManager {
    private FilmItem[] films = new FilmItem[0];
    private int defaultFilmCount = 10;
    private int filmCount;

    public FilmManager(int filmCount) {
        this.filmCount = filmCount;
    }

    public void filmAdd(FilmItem film) {
        int length = films.length + 1;
        FilmItem[] tmp = new FilmItem[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public FilmItem[] getAll() {
        int requestedFilms = films.length;

        if (filmCount == 0) {
            if (defaultFilmCount < films.length) {
                requestedFilms = defaultFilmCount;
            }
        } else {
            if (filmCount < films.length) {
                requestedFilms = filmCount;
            }
        }
        FilmItem[] result = new FilmItem[requestedFilms];
        for (int f = 0; f < result.length; f++) {
            int index = films.length - f - 1;
            result[f] = films[index];
        }
        return result;
    }
}
