package todo.useCases;

public class UnsavedTodoException extends RuntimeException {
    public UnsavedTodoException() {
        super("Only persisted TODOs can be changed.");
    }
}
