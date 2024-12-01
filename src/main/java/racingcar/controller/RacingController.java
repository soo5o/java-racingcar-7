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
        Cars cars = getCarsName();
        int count = getGameCount();
        getResult(count, cars.getCarsInfo());
    }
    private Cars getCarsName(){
        while(true){
            try{
                outputView.printStart();
                return racingService.validateAndSplitNames(inputView.inputValue());
            }catch (IllegalArgumentException e){
                outputView.printError(e.getMessage());
            }
        }
    }
    private int getGameCount(){
        while(true){
            try{
                outputView.printCount();
                return racingService.validateCount(inputView.inputValue());
            }catch (IllegalArgumentException e){
                outputView.printError(e.getMessage());
            }
        }
    }
    private void getResult(int count, List<Car> carsInfo){
        outputView.printResult();
        while(count > 0){
            outputView.printGameProcess(racingService.moveForward(carsInfo));
            count--;
        }
        outputView.printWinner(racingService.getWinningDistance(carsInfo), carsInfo);
    }
}
