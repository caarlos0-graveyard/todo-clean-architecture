package todo.utils;

import todo.persistence.PersistenceAdapter;

public abstract class BaseSingleUseCase<T> extends BaseUseCase<T> {
    public BaseSingleUseCase(PersistenceAdapter<T> persistenceAdapter) {
        super(persistenceAdapter);
    }

    public abstract T exec(T t);
}
