package numbers.ui;

import numbers.model.BigNumber;

import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class Application extends LocalTextInterface implements Runnable {

    @Override
    public void run() {
        printf("welcome");
        printf("instructions");

        Stream.generate(this::getRequest)
                .takeWhile(not("0"::equals))
                .forEach(this::processRequest);
    }

    private String getRequest() {
        printf("prompt");
        return scanner.nextLine().toLowerCase();
    }

    private void processRequest(final String request) {
        if (BigNumber.isNatural(request)) {
            printProperties(new BigNumber(request));
        } else {
            printf("error");
        }
    }

    private void printProperties(BigNumber number) {
        printf("properties", number);
        BigNumber.numberProperties.keySet().forEach(property ->
                printf("property", property, number.hasProperty(property)));
    }
}
