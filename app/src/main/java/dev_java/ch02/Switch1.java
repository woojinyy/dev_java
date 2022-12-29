package dev_java.ch02;

public class Switch1 {
    public static void main(String[] args) {
        String bread="도넛";//스트링 타입도 가능하다
        switch("bread"){//이게 된다
            case "소보로":{//중괄호가 된다
                int protocol =100;
            
            System.out.println("소보로빵입니다"+protocol);
            break;
            }
            case "도넛":{
                int protocol =200; //위에 case문과 같은 protocol 변수 선언 가능
                //지역변수라서 가능하다
                System.out.printf("%s빵입니다.%d%n"+bread,protocol);
                break;
            }
            default:
            System.out.println("원하는 빵이 없습니다");
            break;
        }
    }//end of switch
}
