package dev_java.weak4;
//직관적이다. 
class CarVO {
    private int speed;
    private String carColor;
    private int wheelNum;

    CarVO() {
        //speed carColor whellNum의 디폴트값은 0 n 0
    }

    CarVO(int speed) {//new carVO(30)으로 호출했다면?
        this.speed = speed;
        //30 n 0
    }

    CarVO(int speed, String carColor) {//new carVO(50,"검정색")
        this.speed = speed;
        this.carColor = carColor;
        //50,검정색,0
    }

    CarVO(int speed, String carColor, int wheelNum) {
        this.speed = speed;
        this.carColor = carColor;
        this.wheelNum = wheelNum;
    }

    @Override
    public String toString(){//주소값 말고 값을 받아온다
        return "내자동차는"+carColor+"이고, 바퀴수는"+wheelNum+"이고, 현재속도는 "+speed+"입니다.";
    }
    public int getSpeed(int speed) {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getCarColor(String carColor) {
        return this.carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public int getWheelNum(int wheelNum) {
        return this.wheelNum;
    }

    public void setWheelNum(int wheelNum) {
        this.wheelNum = wheelNum;
    }

}

public class CarVOMain {
    public static void main(String[] args) {
        CarVO cVo1=new CarVO();
        CarVO cVo2=new CarVO(50);
        CarVO cVo3=new CarVO(50,"검정색");
        CarVO cVo4=new CarVO(50,"검정색",220);

        CarVOMain cVOMain = new CarVOMain( );
        System.out.println(cVOMain);
        System.out.println(cVo1);
        System.out.println(cVo2);
        System.out.println(cVo3);
        System.out.println(cVo4);
    }
}
