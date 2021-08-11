package numbers.ui;

import java.text.MessageFormat;

public interface TextInterface {
    System.Logger LOGGER = System.getLogger("");

    default void print(final String format, final Object... args) {
        System.out.print(MessageFormat.format(format, args));
    }

    default void println() {
        System.out.println();
    }

    default void println(final String format, final Object... args) {
        print(format, args);
        println();
    }

}