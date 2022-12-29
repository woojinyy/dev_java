package dev_java.waek3;

public class Sub_1 {

    public static void main(String[] args) {
        Main_1 m1=new Main_1();
        for(int i =0; i<m1.isOk.length;i++)
        {System.out.println(m1.isOk[i]);
}
System.out.println("=======================");
for(boolean isOk:m1.isOk){//개선된 for문 전체에 대한 
    System.out.println(isOk);
}
}
}
