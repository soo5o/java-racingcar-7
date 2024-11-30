package racingcar.message;

public enum ErrorMessage {
    INVALID_LENGTH("[ERROR] 자동차 이름은 5글자 이하여야 합니다."),
    INVALID_DUPLICATE("[ERROR] 자동차 이름은 중복될 수 없습니다."),
    INVALID_COUNT("[ERROR] 자연수 값을 넣어주십시오.");
    final String message;
    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
