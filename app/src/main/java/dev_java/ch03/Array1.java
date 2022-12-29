package dev_java.ch03;

public class Array1 extends Object{//상속 aka 확장, 재사용 (오버라이딩경우). 재정의 해서 사용
    public static void main(String[] args) {
        //선언과 생성을 나누어 할 수 있다.
        //Q.이른주입?(이른 인스턴스화) or 게으른 주입? (게으른 인스턴스화) 안정성과 연관
        //게으른 인스턴스화는 선언과 생성을 따로한다ex)int[] arr;
        //                                                                      int arr[] ;                          
        //이른 인스턴스화는 선언과 생성을 같이한다 ex) int i[] = new int[3]

        int i [];

        //int j[3]=new int[3];
        //에러 : 선언부에 정수 쓰지마
        i=new int[3];
        //초기화 안함
        //객체배열 null null null
        System.out.println(i[0]);
        int x=3;
        boolean isOk=false;
        try
        {//예외가 발생할 가능성이 있는 코드를 감싼다.
            System.out.println(i[x]);
        // ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
        }catch (ArrayIndexOutOfBoundsException e) {
        // TODO: handle exception
    }

    }
}


