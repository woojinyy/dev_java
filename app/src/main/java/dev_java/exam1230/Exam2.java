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
                fw.close();//잊지말고 close해줘야 작성이 완료된다.
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }catch(IOException e) {
                e.printStackTrace();
            }
            
        
        
    }
}
