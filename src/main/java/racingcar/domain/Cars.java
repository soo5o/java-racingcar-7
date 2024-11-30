package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carsInfo = new ArrayList<>();
    public Cars(List<String> cars){
        for(String carName:cars){
            carsInfo.add(new Car(carName,0, ""));
        }
    }

    public List<Car> getCarsInfo() {
        return carsInfo;
    }
}
