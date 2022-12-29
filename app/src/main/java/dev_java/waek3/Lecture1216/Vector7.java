package dev_java.waek3.Lecture1216;

import java.util.Scanner;
import java.util.Vector;

public class Vector7 {
    public static void main(String[] args) {


        Vector<DeptVo> vdepts = new Vector<>();
        DeptVo[] dVOS= new DeptVo[vdepts.size()];
DeptVo dvo=new DeptVo(10,"개발부","서울");
dVOS[0]=dvo;
vdepts.add(dvo);
dvo=new DeptVo(20,"인사부","인천");
dVOS[1]=dvo;
vdepts.add(dvo);
dvo=new DeptVo(30,"총무부","부산");
dVOS[2]=dvo;
vdepts.add(dvo);

Scanner s = new Scanner(System.in);
int users=s.nextInt();
}//enod of main
}//end of Vector7
