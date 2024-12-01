package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingConfig {
    public static final String COMMA_DELIMITER = ",";
    public static final int MAX_NAME_LENGTH = 5;
    public static final int MOVE = 4;

    public static int getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

}
