package dev_java.qwer;

public class AccountSample {
    ButtonArray2 ba2=null;//원본이 필요해
    public AccountSample(ButtonArray2 ba2){
        this.ba2= ba2;
    }
    public String account(){    
    return"낮춰라";
    }
    public void account2(){
        String msg ="낮춰라";//넘겨서 찍는 게 아니라 여기서 찍을거 
        //jta_display 는 ButtonArray2에 생성된 객체인데
        //굳이 AccountSample에서 사용하고싶다고 한다 어쾀???
        ba2.jta_display.append(msg+"\n");//무엇을 (로직을 )어디에 (view에 )어떻게 (생성자의 파라미터에 넣어)
}
}
