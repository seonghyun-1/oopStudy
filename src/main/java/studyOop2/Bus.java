package studyOop2;

public class Bus extends Transport{
    // * 필드
    // 버스 고유번호 필드
    int busTransportNumber;
    // 요금 관련 필드
    int busCharge;
    int busTotalMoney;



    // * 생성자
    public Bus(){
        busCharge = 1000;
        peopleCurrentNumber = 0;
        busTotalMoney = 0;
        peopleMaxSeat = 30;
        busTransportNumber = updateTransportNumber();
        transportState = "운행";
    }

    // * 메소드
    // 출력관련메소드
    // busTransportNumber 출력메소드
    public int printBusTransportNumber() {
        return busTransportNumber;
    }

    // 버스 상태/주유량 출력
    public void printBusState(){
        System.out.println("상태 = "+ transportState);
        System.out.println("주유량 = "+transportOilState);
    }

    // bus 탑승승객수/잔여승객수/요금확인
    public void printBusCurrentBusiness(){
        System.out.println("");
        System.out.println("탑승 승객 수: "+peopleCurrentNumber);
        System.out.println("잔여 승객 수: "+(peopleMaxSeat-peopleCurrentNumber));
        System.out.println("요금 확인: "+busTotalMoney);
        System.out.println("");
    }

    // 승객 탑승 관련 메소드
    @Override
    public void getPeople(int num){
        if(transportState!="운행") {
            System.out.println("버스가 운행중이지 않아서 탑승할 수 없습니다.");
            return;
        }
        if(peopleCurrentNumber + num > peopleMaxSeat){
            System.out.println("alert: 최대 승객 수 초과");
            return;
        }
        peopleCurrentNumber = peopleCurrentNumber + num;
        busTotalMoney = busTotalMoney + (num*busCharge);
    }

    //
    @Override
    public void changeTransportOilState(String action, int oilNumber){
        if(action == "plus"){
            if(transportOilState+oilNumber>=100){
                transportOilState=100;
                return;
            }
            transportOilState = transportOilState + oilNumber;
            return;
        }
        if(action == "minus"){
            if(transportOilState - oilNumber < 10){
                System.out.println("주유가 필요합니다");
                transportOilState = transportOilState - oilNumber;
                transportState = "차고지행";
                return;
            }
            transportOilState = transportOilState - oilNumber;
            return;
        }
        System.out.println("action이 올바르게 입력되지 않았습니다.");
    }

    public static void main(String[] args) {
        Bus b1 = new Bus();
        Bus b2 = new Bus();
        if(b1.printBusTransportNumber() == b2.printBusTransportNumber()) System.out.println("차 번호가 같습니다.");
        else System.out.println("차 번호가 다릅니다.");

        b1.getPeople(2);
        b1.printBusCurrentBusiness();

        b1.changeTransportOilState("minus",50);
        b1.printTransportOilState();

        b1.changeTransportState("차고지행");
        b1.changeTransportOilState("plus",10);
        b1.printBusState();

        b1.changeTransportState("운행중");
        b1.getPeople(45);
        b1.getPeople(5);
        b1.printBusCurrentBusiness();

        b1.changeTransportOilState("minus",55);
        b1.printBusState();

    }
}
