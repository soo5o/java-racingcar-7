package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.ValidateInput;

import java.util.List;

public class InputView {
    public List<String> inputName(){
        return ValidateInput.splitNames(Console.readLine());
    }
    public int inputCount(){
        return ValidateInput.getCount(Console.readLine());
    }
}
