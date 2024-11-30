package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.List;

public class RacingController {
    private final OutputView outputView;
    private final InputView inputView;
    private final RacingService racingService;
    public RacingController(){
        outputView = new OutputView();
        inputView = new InputView();
        racingService = new RacingService();
    }
    public void run(){
        //input 에 대한 값 검증은 기존처럼 해야될지
        //아니면 service 에서 하는 것 일지
        Cars cars = new Cars(getCarsName());
        int count = getGameCount();
        getResult(count, cars.getCarsInfo());
    }
    private List<String> getCarsName(){
        while(true){
            try{
                outputView.printStart();
                return inputView.inputName();
            }catch (IllegalArgumentException e){
                outputView.printError(e.getMessage());
            }
        }
    }
    private int getGameCount(){
        while(true){
            try{
                outputView.printCount();
                return inputView.inputCount();
            }catch (IllegalArgumentException e){
                outputView.printError(e.getMessage());
            }
        }
    }
    private void getResult(int count, List<Car> carsInfo){
        outputView.printResult();
        while(count > 0){
            racingService.moveForward(carsInfo);
            outputView.printGameProcess(carsInfo);
            count--;
        }
        outputView.printWinner(racingService.getWinningDistance(carsInfo), carsInfo);
    }
}
