package Login;
/**
 * @author Gorit
 * @date 2019��7��12��13:36:00
 * @work �û���¼�����ʵ��
 * 
 * */
import java.util.Scanner;

import dataStored.LoginDataStored;

public class Login {
	static LoginDataStored l=new LoginDataStored();
	public static void login() {
		Scanner in=new Scanner(System.in);
		String account = null;
		String password = null;
		String s;
		//��ʼ���˻���Ϣ
		l.init();
		do {
			System.out.println("��ӭ���� xxx ���� ϵͳ");
			//�˵���ʹ��
			System.out.println("����������˺�:");
			account=in.next();
			System.out.println("�������������:");
			password=in.next();
			
			for(int i=0;i<l.list.size();i++)
			if(account.equals(l.list.get(i).getAccount())) {
				if(password.equals(l.list.get(i).getPassword())) {
					System.out.println("��ϲ���¼�ɹ�������");
					System.out.println("..............");
					s=in.next();// ������ͣ������
					
				}else {
					System.out.println("������������³���");
				}
			}else {
				System.out.println("�˻���������������");
			}
			
		}while(true);//�˺������䲻�ԣ���һֱ����
	}
}
