package cn.gorit.menu;

import cn.gorit.dao.AccountInfo;
import cn.gorit.pojo.Account;

import java.util.List;
import java.util.Scanner;

/**
 * @Author Gorit
 * @Date 2021/12/2
 * @Website https://www.gorit.cn
 **/
public class ShowMenus {
    static Scanner in = new Scanner(System.in);
    AccountInfo accountInfo = new AccountInfo();
    // չʾ��ҳ��
    public void showMainMenu() {
        int t = -1;
        do {
            info("��ӭ���� �û���̨����ϵͳ");
            info("1��ע��");
            info("2����¼");
            info("3���˳�");
            info("���������ѡ��:");
            t = in.nextInt();
            switch (t) {
                case 1:
                    //����ע�����
                    register();
                    break;
                case 2:
                    //�����¼����
                    login();
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

    // չʾע��ҳ��
    public void register() {
        info("========== ��ӭ����ע����� ============");
        String username = "";
        String password = "";
        info("����������˺�:");
        username = in.next();
        info("�������������:");
        password = in.next();
        Account account = new Account(username,password);
        Integer res =  accountInfo.addAccount(account);
        if (res > 0) {
            info("ע��ɹ�");
        } else {
            info("ע��ʧ��");
            // �㻹�����Լ���չ��ע��ʧ�ܣ�����ע��
        }
        //���ص�¼����
        login();
    }
    // չʾ��¼ҳ��
    public void login() {
        String username = "";
        String password = "null";
        String s = "";
        do {
            info("��ӭ���� �û�����ϵͳ");
            //�˵���ʹ��
            info("����������˺�:");
            username=in.next();
            info("�������������:");
            password=in.next();
            if(accountInfo.checkAccountIsExist(username)) {
                if(accountInfo.checkPassIsExist(password)) {
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

    public static void info(String str) {
        System.out.println(str);
    }
}
