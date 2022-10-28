package mx.edu.utez.kofexam;

import mx.edu.utez.kofexam.utils.Response;

import java.util.List;

public interface Repository<T> {
        List<T> getAllCharacters();
        Response<T> getById(Long id);
        Response<T> save(T object);
        Response<T> update(T object);
}
