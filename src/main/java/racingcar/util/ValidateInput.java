package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static racingcar.message.ErrorMessage.*;

public class ValidateInput {
    private static final String COMMA_DELIMITER = ",";
    private static List<String> cars;
    public static int getCount(String input){
        try {
            int count = Integer.parseInt(input);
            checkNaturalNumber(count);
            return count;
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(INVALID_COUNT.getMessage());
        }
    }
    private static void checkNaturalNumber(int count){
        if (count <= 0) {
            throw new IllegalArgumentException();
        }
    }
    public static List<String> splitNames(String input) {
        cars = Arrays.stream(input.split(COMMA_DELIMITER)).map(String::trim).toList();
        checkNameLength();
        checkDuplicatedName(input);
        return cars;
    }

    private static void checkNameLength() {
        for (String car : cars) {
            if(car.length() > 5){
                throw new IllegalArgumentException(INVALID_LENGTH.getMessage());
            }
        }
    }
    private static void checkDuplicatedName(String input){
        Set<String> setCars = Arrays.stream(input.split(COMMA_DELIMITER)).map(String::trim).collect(Collectors.toSet());
        if (setCars.size() != cars.size()){
            throw new IllegalArgumentException(INVALID_DUPLICATE.getMessage());
        }
    }
}
