package calc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int splitAndSum(String rawString) {
        if (rawString == null || rawString.isEmpty()) {
            return 0;
        }
        List<Integer> integerNumbers = parseIntegerNumbers(split(rawString));
        return sum(integerNumbers);
    }

    private static List<Integer> parseIntegerNumbers(String[] numbers) {
        List<Integer> integerNumbers = new ArrayList<>();

        for(String number : numbers) {
            integerNumbers.add(Integer.parseInt(number));
        }

        return integerNumbers;
    }

    private static Integer sum(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    private static String[] split(String rawString) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(rawString);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return rawString.split("[,:]");
    }
}
