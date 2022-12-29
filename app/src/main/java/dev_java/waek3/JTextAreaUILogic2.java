package dev_java.waek3;

public class JTextAreaUILogic2 {
    JTextAreaUI2 jtaUI2=null;
    public JTextAreaUILogic2(JTextAreaUI2 jTextAreaUI2){
        this.jtaUI2=jTextAreaUI2;
    }
    
    public void account(String input) {
        jtaUI2.jta.append("UILogic "+ input+"\n");
    }

}
