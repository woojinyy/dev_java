package dev_java.exam1230;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class Exam2 {
    public static void main(String[] args) {
        
            FileWriter fw = null;
            try {
                
                fw = new FileWriter("D:\\수업노트\\text.txt",true);
                //파일 경로를 넣어주고 ,true를추가하면  덮어 쓰기가 아닌 이어쓰기 가능하다
                fw.write(97);
                fw.write(65);
                fw.write(98);
                fw.write(66);
                // IO패키지는  스트림 형태로 이동 열려있을 경우 intercept 위변조가 가능하므로 
                //반드시 사용후에는 닫도록 하고있다.
                fw.close();//잊지말고 close해줘야 작성이 완료된다.
            } catch (FileNotFoundException fe) {
                System.out.println("파일이 존재하지 않습니다.");
                fe.printStackTrace();
            }catch(IOException ie) {
                ie.printStackTrace();
            }catch(Exception e){
                System.out.println(e.getMessage());

            }finally{
                //예외가 발생하든 그렇지 않든 무조건 처리할 코드는 여기에 작성할 것
                try {
                    if(fw !=null) fw.close();
                } catch (Exception e) {
                }
            }
            
            
        
        
    }
}
