package cn.gorit.main;

import cn.gorit.entity.User;
import cn.gorit.util.BaseDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import static cn.gorit.main.StudentManagement.studentManagement;

public class App {
    public static Scanner in = new Scanner(System.in);
    public static BaseDao db = new BaseDao();
    static boolean flag = true;
    public static void main(String[] args) throws SQLException {

        System.out.println("��ӭ���� ѧ������ϵͳ");
        do {
            System.out.println("����ѡ��\n1����¼\n2��ע��\n3���˳�");
            int choose = in.nextInt();
            if (choose == 1) {
                System.out.println("�����¼����");
                login(); // �����¼��֤ģ��
                studentManagement();
            } else if(choose == 2) {
                System.out.println("����ע�����");
                register();
            } else if(choose == 3) {
                System.out.println("�˳�ϵͳ");
                flag = false;
            }
        } while(flag);
        System.out.println("��ӭ�´ι���");
    }

    // ��¼�����д
    /**
     * �õ��û��� �˻�
     * */
    public static void login() {
        System.out.println("����������˻���");
        String username = in.next();
        System.out.println("������������룺");
        String password = in.next();
        try {
            PreparedStatement ps=db.getConnect("select * from Users where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            User u = null;
            System.out.println("=================");
            if (rs.next()) {
                u = new User(rs.getInt(1),rs.getString(2),rs.getString(3));
            }
            db.closed(ps,rs);

            if (u!=null) {
                System.out.println("��¼�ɹ�������");
            } else {
                // ��¼ʧ��
                System.out.println("����˺Ż������������Ƿ����µ�¼�������� 1��");
                int choice = in.nextInt();
                if (choice == 1) {
                    login();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // ע������д
    public static void register() {
        System.out.println("��������Ҫע���˺ţ�");
        String username = in.next();
        System.out.println("��������Ҫע������룺");
        String password = in.next();
        String sql = "insert into users(username,password) values(?,?)";
        try {
            PreparedStatement ps = db.getConnect(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            int res = ps.executeUpdate();
            if (res > 0) {
                System.out.println("============  ע��ɹ�  ============");
                System.out.println("�Ƿ��¼��(���� 1��¼��)");
                int choice = in.nextInt();
                if (choice == 1) {
                    login();
                }
            } else {
                System.out.println("ע��ʧ��");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
