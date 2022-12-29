package dev_java.weak4;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Setter
//@Getter
@Data// getter setter를 컴파일 할 떄 자동으로 해줌
@Builder//생성자 파라미터를 마음대로 조립
public class DeptVO {//접근제한자가 public 패키지가 달라도 접근 가능
    int deptno;
    String dname;
    String loc;
    
}
