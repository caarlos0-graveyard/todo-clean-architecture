package todo.useCases;

public class InvalidTodoException extends RuntimeException {
    public InvalidTodoException() {
        super("Invalid TODO. Please fill all required fields.");
    }
}
