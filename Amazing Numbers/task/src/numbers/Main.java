package numbers;

import numbers.model.BigNumber;
import numbers.ui.Application;

import java.math.BigInteger;

import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;

public class Main {
    static {
        final var SEVEN = new BigNumber("7");
        BigNumber.addProperty("even", number -> number.mod(BigInteger.TWO).equals(BigInteger.ZERO));
        BigNumber.addProperty("odd", number -> number.mod(BigInteger.TWO).equals(BigInteger.ONE));
        BigNumber.addProperty("buzz", number -> number.mod(TEN).equals(SEVEN) || number.mod(SEVEN).equals(ZERO));
        BigNumber.addProperty("duck", number -> number.toString().indexOf('0') > -1);
        BigNumber.addProperty("palindromic", number ->
                new StringBuilder(number.toString()).reverse().toString().equals(number.toString()));
    }

    public static void main(String[] args) {
        new Application().run();
    }

}
