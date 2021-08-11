package numbers.ui;

import java.util.ResourceBundle;
import java.util.Scanner;

public abstract class LocalTextInterface implements TextInterface {
    protected static final Scanner scanner = new Scanner(System.in);
    protected static final ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");

    @Override
    public void print(final String key, final Object... args) {
        TextInterface.super.print(getString(key), args);
    }

    public void printf(final String key, final Object... args) {
        System.out.printf(getString(key), args);
    }

    public String format(final String key, final Object... args) {
        return String.format(getString(key), args);
    }

    public String getString(final String key) {
        return resourceBundle.containsKey(key) ? resourceBundle.getString(key) : key;
    }
}