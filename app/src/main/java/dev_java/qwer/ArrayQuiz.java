package dev_java.qwer;

import java.util.Scanner;

public class ArrayQuiz {
    String[] subject={"JAVA","ORACLE","SPRING"};
    String[][] data = {
        {"이순신", "80", "75", "70"}
       ,{"강감찬", "90", "85", "95"}
       ,{"김춘추","65", "60", "60"}};

    public void TotalScore() {
        int scoreLee=0;
        for(int i =1;i<data.length;i++){   
            scoreLee+=Integer.parseInt(data[0][i]);
        }
            //for(int j =1;j<data[j].length;j++)
            int scoreKang=0;
            for(int i =1;i<data.length;i++){   
                scoreKang+=Integer.parseInt(data[1][i]);
            }
            int scoreKim=0;
            for(int i =1;i<data.length;i++){   
                scoreKim+=Integer.parseInt(data[2][i]);
            }
        
            
    }


public void name(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
for(int i=0;i<=data.length;i++){
    System.out.print("이름을 입력 : ");
    ArrayQuiz score= new ArrayQuiz();
    score.TotalScore();
    if ("이순신".equals(str)) {
        
    } else if("강감찬".equals(str)) {
         System.out.print("이름을 입력 : ");
    }else if("김춘추".equals(str)) {
        System.out.print("이름을 입력 : ");

    }
}
}
       
    

    public void average() {
   
    }

    public void rank() {

      
    }
    public static void main(String[] args) {
        ArrayQuiz score= new ArrayQuiz();
        score.TotalScore();
        
    }
}

