package menu;
/**
 * @author Gorit
 * @date 2019��7��12��
 * @work �������չʾ
 * */

import java.util.Scanner;

import Login.Login;
import dataStored.LoginDataStored;

public class MainMenu {
	static Scanner in=new Scanner(System.in);
	static Login l=new Login();//��¼����
	static LoginDataStored lo=new LoginDataStored();
	public static void mainMenu() {
		int t=-1;
		do {
			info("��ӭ���� xxx ϵͳ");
			info("1��ע��");
			info("2����¼");
			info("3���˳�");
			info("���������ѡ��:");
			t=in.nextInt();
			switch (t) {
			case 1:
				//����ע�����
				lo.Register();
				break;
			case 2:
				//�����¼����
				l.login();
				break;
			case 3:
				//�˳�
				return;
			default:
				info("���������������������...");
				t=in.nextInt();
				break;
			}
		}while(t!=1 && t!=2);
	}
	
	public static void info(String str) {
		System.out.println(str);
	}
}
