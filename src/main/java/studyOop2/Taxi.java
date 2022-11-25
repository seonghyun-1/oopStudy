package studyOop2;

public class Taxi extends Transport{
//    static int transportNumber;
//    int transportOilState;
//    int transportSpeed;
//    int transportSpeedChange;
//
//    // 운행 관련 필드 추가
//    String transportState;// 운행상태 ( 운행시 : "운행", 종료시 : "차고지행" )
//
//    // 승객 관련 필드
//    int peopleMaxSeat; // 최대승객수

    int taxiNumber; // taxi 번호

    String taxiDestination;


    // 택시 거리
    int taxiBasicDistance; //택시기본거리

    int taxiDistanceToDestination; //목적지까지의 거리

    // 요금관련필드
    int taxiChargeBasic;
    int taxiChargeByDistance;
    int taxiTotalCharge;
    int taxiTodayEarnMoney;

    // 택시상태관련필드
    String taxiState;

    // 목적지 설정
    public void setTaxiDestination(String taxiDestination) {
        this.taxiDestination = taxiDestination;
    }


    // * 생성자
    public Taxi(){
        peopleMaxSeat = 4;
        peopleCurrentNumber = 0;
        taxiChargeBasic = 3000;
        taxiChargeByDistance = 1000;
        taxiTotalCharge=0;
        taxiBasicDistance = 1;
        transportOilState = 100;
        transportState = "일반";
        transportSpeed = 0;
        taxiNumber = updateTransportNumber();
    }

    // * 메소드
    // # 운행시작
    @Override
    public void movingStart(){
        if(transportOilState < 10) {
            System.out.println("오일이 10미만이라서 운행불가");
            transportState = "운행불가";
        } else {
            transportState = "운행";
        }
    }

    // # 승객탑승 및 하차
    @Override
    public void getPeople(int added){
        if(transportState!="일반"){
            System.out.println("지금은 탑승할 없습니다.");
            return;
        }
        if( (peopleCurrentNumber + added) > peopleMaxSeat ){
            System.out.println("최대 승객 수 초과");
            return;
        }
        peopleCurrentNumber = peopleCurrentNumber + added;
        transportState = "운행 중";
    }

    public void customerBoarding(int added, String destination, int km){
        if(peopleCurrentNumber + added > peopleMaxSeat) {
            System.out.println("최대 승객 수 초과");
            return;
        }
        getPeople(added);
        setTaxiDestination(destination);
        setTaxiDistanceToDestination(km);
        caculateCharge();
    }


    public void dropPeople(){
        if(transportState != "운행중"){
            System.out.println("승객이 타고 있지 않습니다.");
            return;
        }
        peopleCurrentNumber = 0;
        transportState = "일반";
    }

    // # 목적지까지 세팅
    public void setTaxiDistanceToDestination(int taxiDistanceToDestination) {
        this.taxiDistanceToDestination = taxiDistanceToDestination;
    }

    // # 요금계산
    public void caculateCharge() {
        if(taxiDistanceToDestination > taxiBasicDistance){
            taxiTotalCharge = taxiChargeBasic + ( taxiChargeByDistance * taxiDistanceToDestination) - (taxiChargeByDistance * taxiBasicDistance);
        } else {
            taxiTotalCharge = taxiChargeBasic;
        }
    }

    // # 택시 상태 출력
    public void printTaxiBusinessState(){
        System.out.println("---출력 택시---");
        System.out.println("탑승 승객 수 = "+peopleCurrentNumber);
        System.out.println("잔여 승객 수 = "+(peopleMaxSeat-peopleCurrentNumber));
        System.out.println("기본 요금 확인 = "+taxiChargeBasic);
        System.out.println("목적지 = "+taxiDestination);
        System.out.println("목적지까지 거리 = "+taxiDistanceToDestination+"km");
        System.out.println("지불할 요금 = "+taxiTotalCharge);
        System.out.println("상태 = "+transportState);
    }

    public void printTaxiState(){
        System.out.println("---출력 택시---");
        System.out.println("주유량 = "+transportOilState);
        System.out.println("누적 요금 = "+taxiTodayEarnMoney);
        checkTransportOilState();
    }

    // # 오일 상태 변경
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
            if(transportOilState - oilNumber <=0){
                transportOilState = 0;
                return;
            }
            transportOilState = transportOilState - oilNumber;
            return;
        }
        System.out.println("action이 올바르게 입력되지 않았습니다.");
    }

    // # 요금 결제 메소드
    public void printTotalCharge(){
        System.out.println("---요금 결제---");
        peopleMaxSeat = 4;
        peopleCurrentNumber = 0;
        transportState = "일반";
        taxiTodayEarnMoney = taxiTodayEarnMoney + taxiTotalCharge;
        System.out.println("최종요금: "+taxiTotalCharge);
        taxiTotalCharge = 0;
    }

    // # 검사 메소드
    public void checkTransportOilState(){
        if(transportOilState<10){
            System.out.println("---알럿---");
            System.out.println("주유 필요");
        }
    }

    public static void main(String[] args) {
        Taxi t1 = new Taxi();
        Taxi t2 = new Taxi();
        if(t1.taxiNumber != t2.taxiNumber){
            System.out.println("차 번호가 같지 않습니다.");
            System.out.println("");
        } else {
            System.out.println("차 번호가 같습니다.");
            System.out.println("");
        }
        t1.printTransportOilState();
        t2.printTransportOilState();
        t1.printTransportState();
        t2.printTransportState();

        t1.customerBoarding(2,"서울역",2);
        t1.printTaxiBusinessState();

        t1.changeTransportOilState("minus",80);
        t1.printTotalCharge();

        t1.getPeople(5);
        t1.customerBoarding(3,"구로디지털단지역",12);

        t1.printTaxiBusinessState();
        t1.changeTransportOilState("minus",20);
        t1.printTotalCharge();
        t1.printTaxiState();
    }

}
