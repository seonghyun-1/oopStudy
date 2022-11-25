package studyOop2;

public class Transport {
    // * 필드
    // 운송수단 관련 필드
    static int transportNumber;
    int transportOilState;
    int transportSpeed;
    int transportSpeedChange;

    // 승객 관련 필드
    int peopleCurrentNumber; // 현재 승객수

    // 운행 관련 필드 추가
    String transportState;// 운행상태 ( 운행시 : "운행", 종료시 : "차고지행" )

    // 승객 관련 필드
    int peopleMaxSeat; // 최대승객수


    // * 생성자
    public Transport(){
        transportOilState = 100;
        transportSpeed = 0;
    }

    // * 메소드
    // #운행 관련 메소드
    // 운행 시작
    public void movingStart(){

    }
    // 속도변경
    public void changeTransportSpeed(String updateState, int addedSpeed){
        if(transportOilState < 10) {
            System.out.println("경고 : 주유량을 확인해주세요");
            return;
        }
        if(updateState == "plus"){
            transportSpeed = transportSpeed + addedSpeed;
        } else if(updateState == "minus"){
            if(transportSpeed - addedSpeed <= 0){
                transportSpeed = 0;
            }
            transportSpeed = transportSpeed - addedSpeed;
        } else {
            System.out.println("plus나 minus를 입력해주세요");
        }
    }

    // # 상태변경메소드
    public void changeTransportState(String state){
        transportState = state;
    }

    public void printTransportState(){
        System.out.println("상태 = "+transportState);
        System.out.println("");
    }

    // # 인원 관련 메소드
    // 승객 탑승 관련 메소드
    public void getPeople(int num){}

    // # 자동차 번호 변경 메소드
    public int updateTransportNumber(){
        transportNumber = transportNumber + 1;
        return transportNumber;
    }

    // # 오일 관련 메소드
    // 오일상태변경
    public void changeTransportOilState(String action, int oilNumber){}
    // 오일출력
    public void printTransportOilState(){
        System.out.println("주유량 = "+transportOilState);
        System.out.println("");
    }
}
