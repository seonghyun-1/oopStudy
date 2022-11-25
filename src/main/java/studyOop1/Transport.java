package studyOop1;

public class Transport {
    static int transportNumber=0;
    String transportState;
    String movingState;
    int oilState;
    int speed;
    int speedChange;
    int maxPeople;
    int currentPeopleNum;
    boolean checkFlag;

    public Transport() {
        oilState = 100;
        speed = 0;
    }

    public int setTransportNumber(){
        transportNumber = transportNumber + 1;
        return transportNumber;
    }

    public void stateChange(String state){
        System.out.println(state);
        this.transportState = state;
    }

    public int changeSpeed(){
        return -1;
    }

    public String changeState(String state){
        transportState = state;
        return transportState;
    }

    public void minusOilState(int num){
        if(oilState-num<=0){
            oilState = 0;
        }
        oilState = oilState - num;
    }

    public void plusOilState(int num){
        if(oilState+num>100){
            oilState = 100;
        }
        oilState = oilState + num;
    }

    public void printOilState(){
        System.out.println("기름잔여량:"+oilState);
    }

    public void printTransportState(){
        System.out.println(transportState);
    }


    public int addPeople(int peopleNumber){
        if(currentPeopleNum+peopleNumber>maxPeople){
            System.out.println("총 정원을 초과해서 더 탑승할 수 없습니다.");
            return -1;
        }
//        System.out.println(currentPeopleNum + peopleNumber);
        currentPeopleNum = currentPeopleNum + peopleNumber;
        return currentPeopleNum + peopleNumber;
    }

}
