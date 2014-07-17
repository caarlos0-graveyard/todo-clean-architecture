package todo.utils;

import todo.entities.Todo;

public class Strings {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
