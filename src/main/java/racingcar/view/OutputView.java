package racingcar.view;

import racingcar.domain.Car;
import java.util.List;
import static racingcar.message.OutputMessage.*;

public class OutputView {
    private static final String COMMA_DELIMITER = ", ";

    public void printStart(){
        System.out.println(START.getMessage());
    }
    public void printCount(){
        System.out.println(COUNT.getMessage());
    }
    public void printResult(){
        System.out.println();
        System.out.println(RESULT.getMessage());
    }
    public void printGameProcess(List<Car> cars){
        for(Car car: cars){ //printf는 c언어에서 사용하는 포맷
            System.out.printf("%s : %s%n", car.getName(), car.getDistanceLine());
        }
        System.out.println();
    }
    public void printWinner(List<Integer> winningInfo, List<Car> cars){
        System.out.print(WINNER.getMessage());
        int winnerCount = winningInfo.get(1);
        for(Car car : cars){
            if(car.getDistance() == winningInfo.get(0)){
                System.out.print(car.getName());
                printDelimiter(winnerCount--);
            }
        }
    }
    private void printDelimiter(int winnerCount){
        if(winnerCount > 1){
            System.out.print(COMMA_DELIMITER);
        }
    }
    public void printError(String e){
        System.out.println(e);
    }
}
