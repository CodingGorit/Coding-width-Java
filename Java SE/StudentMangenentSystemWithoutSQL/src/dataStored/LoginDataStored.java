package dataStored;

import java.util.*;
import Login.Login;
import pojo.SignIn;

public class LoginDataStored {
    public static  SignIn s=new SignIn();
    public static  List<SignIn> list=new ArrayList<SignIn>();
    public static Scanner in=new Scanner(System.in);
    static Login ll=new Login();
    
    public void init() {//��ʼ���˺���Ϣ
    	list.add(new SignIn("aaa","bbb"));
    	list.add(new SignIn("bbb","ccc"));
    }
    
    public static void Register() {
    	info("��ӭ����ע�����");
    	String account="";
    	String password="";
    	System.out.println("����������˺�:");
    	account=in.next();
    	System.out.println("�������������:");
    	password=in.next();
    	s=new SignIn(account,password);
    	list.add(s);
    	//���ص�¼����
    	ll.login();
    	
    }
    
    public static void info(String str) {
    	System.out.println(str);
    }
}
