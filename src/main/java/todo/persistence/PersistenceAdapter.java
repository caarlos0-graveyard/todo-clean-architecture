package todo.persistence;

import java.util.List;

public interface PersistenceAdapter<T> {
    T persist(T todo);
    T update(T todo);
    List<T> list();
}
