package racingcar.service;

import racingcar.domain.Car;
import racingcar.util.RandomNumber;

import java.util.Arrays;
import java.util.List;

public class RacingService {
    public void moveForward(List<Car> carsInfo){
        for(Car car:carsInfo){
            if(RandomNumber.getRandomNumber() >= 4){
                car.setDistance();
            }
        }
    }
    public List<Integer> getWinningDistance(List<Car> carsInfo){
        int maxDistance = -1;
        int winner = 0;
        for(Car car:carsInfo){
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
