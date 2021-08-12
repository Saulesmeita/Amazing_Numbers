package numbers;

import numbers.property.*;
import numbers.ui.Application;

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
                        .put(new Happy())
                        .put(new Sad())
                        .add("even", "odd")
                        .add("sunny", "square")
                        .add("spy", "duck")
                        .add("happy", "sad")
                        .add("-even", "-odd")
                        .add("-happy", "-sad")
        ).run();
    }

}
