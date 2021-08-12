package numbers.ui;

import java.util.ResourceBundle;
import java.util.Scanner;

abstract class LocalTextInterface {
    static final System.Logger LOGGER = System.getLogger("");
    static final Scanner scanner = new Scanner(System.in);
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");

    void printf(final String key, final Object... args) {
        System.out.printf(getString(key), args);
    }

    String format(final String key, final Object... args) {
        return String.format(getString(key), args);
    }

    String getString(final String key) {
        return resourceBundle.containsKey(key) ? resourceBundle.getString(key) : key;
    }
}