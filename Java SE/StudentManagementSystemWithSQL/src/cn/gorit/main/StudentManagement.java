package cn.gorit.main;

import cn.gorit.dao.StudentDao;
import cn.gorit.dao.impl.StudentDaoImpl;
import cn.gorit.entity.Classz;
import java.sql.SQLException;

import static cn.gorit.main.App.in;

public class StudentManagement {
    static StudentDao studentDao = new StudentDaoImpl();

    public static void studentManagement() throws SQLException {
        boolean flag = true;
        //1.���ѧ����Ϣ
        //2.��ѯѧ����Ϣ

        //3.�޸�ѧ����Ϣ
        //4.ɾ��ѧ����Ϣ
        //5.�˳�ϵͳ
        info("======================");
        System.out.println("��ӭ����ѧ����̨����ϵͳ");
        info("======================");
        do {
            info("1�����ѧ��\n2����ѯѧ��\n3���޸�ѧ����Ϣ\n4��ɾ��ѧ����Ϣ\n5���˳�ϵͳ");
            info("���������ѡ��");
            int choice = in.nextInt();
            if (choice == 1) {
                System.out.println("==========  ���ѧ�� =========");
                addStudent();
            }else if(choice == 2) {
                System.out.println("==========  ��ѯѧ�� =========");
                queryStudents();
            }else if(choice == 3) {
                info("===========  �޸�ѧ��  ===========\n ��ǰ��ѧ����ϢΪ��");
                updateStudent();
            }else if(choice == 4) {
                info("===========  ɾ��ѧ��  ===========");
                deleteStudent();
            }else if(choice == 5) {
                flag = false;
            } else {
                info("����������󣡣��� ����������");
            }

        } while (flag);
        info("�˳��ɹ�");

    }

    public static void queryStudents() {
        boolean flag = true;
        do {
            info("1.ͨ�����Ʋ�ѯ\n2.ͨ���༶���Ʋ�ѯ\n3.ͨ������β�ѯ\n4.ͨ�����ϲ�ѯ\n5.�˳���ѯ");
            int choice = in.nextInt();
            if (choice == 1) {
                info("������ѧ����������");
                String stuName = in.next();
                studentDao.queryStudentByName(stuName);
            } else if (choice == 2) {
                info("������༶�����ƣ��� ���� �ƿ�5�ࣩ");
                // ������ѧ�����꼶
                info("������ѧ�����꼶��");
                String grade = in.next();
                info("������ѧ���İ༶");
                String clasz = in.next();
                Classz classz = new Classz(grade,clasz);
                studentDao.queryStudentByClassz(classz.toString());
            } else if (choice == 3) {
                info("������ѧ���������:");
                info("��ʼ�����");
                int beginAge = in.nextInt();
                info("���������");
                int endAge = in.nextInt();
                if (beginAge > endAge) {
                    studentDao.queryStudentByAge(endAge,beginAge);
                } else if (beginAge < endAge) {
                    studentDao.queryStudentByAge(beginAge,endAge);
                } else {
                    studentDao.queryStudentByAge(beginAge,endAge);
                }
            } else if (choice == 4) {
                info("������ѧ������ʸ��");
                String firstName = in.next();
                studentDao.queryStudentByFirstName(firstName);
            } else if (choice == 5) {
                flag = false;
            } else {
                System.out.println("������������Ƿ��������룿 ��������1��");
                if (in.nextInt() == 1) {
                    queryStudents();
                } else {
                    flag = false;
                }
            }

        } while (flag);
    }

    public static void addStudent() {
        int res = studentDao.addStudent();
        String inf = res > 0 ? "��ӳɹ�" : "���ʧ��";
        info(inf);
    }


    // ִ��ɾ��ѧ���ķ���
    public static void deleteStudent() throws SQLException {
        studentDao.queryStudents(); // �Ȳ�ѯ����ѧ��
        System.out.println("��������Ҫɾ����ѧ���� ID");
        String id = in.next();
        int res = studentDao.deleteStudent(id);
        String inf = res > 0 ? "ɾ���ɹ�" : "ɾ��ʧ��";
        info(inf);
    }

    public static void updateStudent()  {
        studentDao.queryStudents(); // �Ȳ�ѯ����ѧ��
        int res = studentDao.updateStudent();
        String inf = res > 0 ? "�޸ĳɹ�" : "�޸�ʧ��";
        info(inf);
    }

    private static void info(String s) {
        System.out.println(s);
    }

}
