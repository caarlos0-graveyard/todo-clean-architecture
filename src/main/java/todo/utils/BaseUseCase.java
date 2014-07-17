package todo.utils;

import todo.persistence.PersistenceAdapter;

public abstract class BaseUseCase<T> {

    protected PersistenceAdapter<T> persistenceAdapter;

    public BaseUseCase(PersistenceAdapter<T> persistenceAdapter) {
        this.persistenceAdapter = persistenceAdapter;
    }
}
