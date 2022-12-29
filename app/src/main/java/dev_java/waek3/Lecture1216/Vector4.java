package dev_java.waek3.Lecture1216;

import java.util.Vector;

public class Vector4 {
    public static void main(String[] args) {
        String fruits[]={"키위","포도","사과"};
        Vector<String> vfruit = new Vector<>();
        for (int i =0;i<fruits.length;i++){
            vfruit.add(i,fruits[i]);
            
        }
        System.out.println(vfruit.size());
        
        vfruit.add(1,"토마토");
        for(int i=0;i<vfruit.size();i++){
            System.out.println(vfruit.get(i));
            if(vfruit.contains("포토")){
                vfruit.remove("포도");
                System.out.println(vfruit.get(i));
            }
            
        }
        
       
    }
    
}
