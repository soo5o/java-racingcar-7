package racingcar.domain;

public class Car {
    private final String name;
    private int distance; //Static 형 이어야지 되는지?
    //아니어도 될 듯
    private String distanceLine;


    public Car(String name, int distance, String distanceLine) {
        this.name = name;
        this.distance = distance;
        this.distanceLine = distanceLine;
    }
    public void setDistance(){
        distance ++;
        distanceLine += "-";
    }

    public String getName() {
        return name;
    }

    public int getDistance() { //얘는 우승자 가려낼때
        return distance;
    }

    public String getDistanceLine() {
        return distanceLine;
    }
}
