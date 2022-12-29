package dev_java.waek3.quiz;

import javax.swing.JDialog;

public class AddressDialog {
    JDialog jdg = new JDialog();
    
    public AddressDialog(){//생성자 
        initDisplay();
    }
    
    public void initDisplay(){
        jdg.setSize(400,300);
        jdg.setVisible(false);//상수
    }
    
    //주소번지 XXX.methodA(); 권장하지않는다.
    public void SetDialog(String title, boolean isView){
        //무엇을 호출해야 할까요?
        //setVIsible 호출 지역변수 Boolean 
        
           jdg.setTitle(title);
           jdg.setVisible(isView);//변수    
    

    }
    public static void main(String[] args) {
        new AddressDialog();
    }
}



