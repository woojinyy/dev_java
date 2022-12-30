package dev_java.weak6;
    class Sup{
        void go(){
            System.out.println("Sup go 호출");
        }
        void stop(){
            System.out.println("Sup stop호출");
    }
}
    class Sub extends Sup{
        Sub(){
            super.stop();//static아래가 아니니까 가능하다//슈퍼니까 아빠거 나온다
            
            //현재 활성화 되어 있는
            this.stop();//아들거 나온다 현재 인스턴스화 되어 있는 (객체가 최초로 로딩 되었을 때 생성되어진) 객체
        }
        @Override
        void stop(){
            System.out.println("Sub stop호출");
        }
    }
    public class SuperMain {
    public static void main(String[] args) {
        Sup sup = new Sup();
        Sub sub = new Sub();
        //sup.go();//내꺼 내가 쓰는데 문제?
       // sub.go();//아빠거 쓸건데 문제라도?????
        //sup.stop();아빠는 아들거 안 써
        sub.stop();
        sup= sub;
        //super.stop(); super,this는 static안에서 못쓴다 컴파일 에러
        //부모가 가진 stop메소드는 은닉메소드라고 한다. shadow method
        sup.stop();


        //Q. sub를 이용해서 go 호출 가능?
        //A. sub안에 없는데 부모가 갖는 메소드 호출 됨? ㅇㅇ 가능 상속 받았잖아 아빠건 내거 내건 내거
        
        //Q. sup은 sub 쓸 수 있음???
        //A. 아빠가 가오가 있찌 아들거 안씀 
        
        //Q.sup= sub; 어케됨???
        //A 주소번지 바뀐다. (얕은복사)

        //Q.21번줄 치환 했는데 sup.stop 외않됌???????????????????????????
        //A. 타입이 다르다 어떤 타입? Sub타입이 아니잖아요 선언부에 온 게

        //Q. 25번 무조건 해줘 어쾀????????????????????????????????????????
       //A. method overriding 
       //Q.이름이 똑같은데 누구거 실행됨????
       //A.타입은 아빠 타입인데 아들거 실행  재정의 됐으니까 재정의된 게 출력
    }
}
