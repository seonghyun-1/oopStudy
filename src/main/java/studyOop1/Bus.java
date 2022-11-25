package studyOop1;

public class Bus extends Transport{

    int busNumber;
    int busCharge;
    int currentMoney;
    public Bus(){
        busNumber = setTransportNumber();
        maxPeople = 30;
        transportState = "운행";
        busCharge = 1000;
        currentPeopleNum = 0;
    }

    public void printBusNumber() {
        System.out.println("이 버스의 차 번호는 " + busNumber +"입니다");
    }

    public void printCurrentPeople(){
        System.out.println("현재인원:"+currentPeopleNum);
    }

    public void printRestPeopleSeat(){
        System.out.println("남은좌석:"+(maxPeople-currentPeopleNum));
    }

    public void printBusCharge(){
        System.out.println("버스요금:"+busCharge);
    }

    public void printCurrentMoney(){
        System.out.println("요금:"+currentMoney);
    }

    public void printBusState(){
        System.out.println(" ");
        System.out.println("현재 버스 상태");
        printCurrentPeople();
        printRestPeopleSeat();
        printCurrentMoney();
        System.out.println();
    }

    public void plusChargeByOne(int num){
        currentMoney = currentMoney + busCharge*num;
    }

    public void onBoard(int num){
        int check = addPeople(num);
        if(check != -1) plusChargeByOne(num);
    }


    public static void main(String[] args) {
        Bus b1 = new Bus();
        Bus b2 = new Bus();
        b1.printBusNumber();
        b2.printBusNumber();

        b1.onBoard(2);
        b1.printBusState();

        b1.minusOilState(50);
        b1.printOilState();

        b1.changeState("차고지행");
        b1.plusOilState(10);

        b1.printTransportState();
        b1.printOilState();

        b1.changeState("운행중");
        b1.onBoard(45);

        b1.onBoard(5);
        b1.printBusState();

        b1.minusOilState(55);
        b1.printOilState();
        b1.printTransportState();
    }
}
