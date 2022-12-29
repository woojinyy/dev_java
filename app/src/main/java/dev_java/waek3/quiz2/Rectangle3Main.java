package dev_java.waek3.quiz2;

//배열로 처리해 보기
//소스리뷰 1,2,3 비교
//관점포인트 
//어느쪽이 직관적인가? 어느쪽이 더 양이 많은가? 
//복잡도는 어떤가?재사용성은 어떤가?(with 결합도)
//결합도가 높은 코드인가? -이식성과 관계
class Rectangle3{
    void area(int params[]){//행 렬 어디가 가로인지 세로인지 알 수 없다.
        //결괏값은 어느방에 들어가는지 직관적이지 않음
params[2]=params[0]*params[1];
System.out.println("면적"+params[2]);
    }

}
public class Rectangle3Main {


    public static void main(String[] args) {
Rectangle3 r3=new Rectangle3();
int params[]={2,3,0};
r3.area(null);
    }
}
