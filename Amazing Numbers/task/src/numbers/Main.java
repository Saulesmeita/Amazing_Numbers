package numbers;

import numbers.property.*;
import numbers.ui.Application;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        new Application(
                new Properties()
                        .put(new Even())
                        .put(new Odd())
                        .put(new Buzz())
                        .put(new Duck())
                        .put(new Palindromic())
                        .put(new Gapful())
                        .put(new Spy())
                        .put(new Jumping())
                        .put(new Square())
                        .put(new Sunny())
                        .add(Set.of("even", "odd"))
                        .add(Set.of("sunny", "square"))
                        .add(Set.of("spy", "duck"))
        ).run();
    }

}
