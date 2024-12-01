package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.RacingConfig;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static racingcar.message.ErrorMessage.*;


public class RacingService {
    //컨트롤러에서 호출되며, 도메인 객체와 상호작용
    public Cars validateAndSplitNames(String input) {
        List<String> names = Arrays.stream(input.split(RacingConfig.COMMA_DELIMITER))
                .map(String::trim)
                .toList();
        checkNameLength(names);
        checkDuplicatedName(names);
        return new Cars(names);
    }

    public int validateCount(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count <= 0) {
                throw new IllegalArgumentException(INVALID_COUNT.getMessage());
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_COUNT.getMessage());
        }
    }

    private void checkNameLength(List<String> cars) {
        for (String car : cars) {
            if (car.length() > RacingConfig.MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(INVALID_LENGTH.getMessage());
            }
        }
    }

    private void checkDuplicatedName(List<String> cars) {
        Set<String> uniqueCars = new HashSet<>(cars);
        if (uniqueCars.size() != cars.size()) {
            throw new IllegalArgumentException(INVALID_DUPLICATE.getMessage());
        }
    }
    public List<Car> moveForward(List<Car> carsInfo){
        for(Car car : carsInfo){
            if(RacingConfig.getRandomNumber() >= RacingConfig.MOVE){
                car.setDistance();
            }
        }
        return carsInfo;
    }
    public List<Integer> getWinningDistance(List<Car> carsInfo){
        int maxDistance = -1;
        int winner = 0;
        for(Car car : carsInfo){
            if(car.getDistance() > maxDistance){
                maxDistance = car.getDistance();
                winner = 1;
            }
            else if(car.getDistance() == maxDistance){
                winner ++;
            }
        }
        return Arrays.asList(maxDistance, winner);
    }
}
