package cn.gorit.dao;

import cn.gorit.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentDao {
    public int Login(String name, String password);

    // ���ѧ��
    public int addStudent(Student student, String addStuClazz, String Grade, String studentClazz);

    // �޸İ༶��
    public void updateClasz(String grade, String clasz, String id);

    // ͨ�� ������ѯѧ��
    public void queryStudentByName(String stuName);

    // ͨ���༶��ѯѧ����Ϣ
    public void queryStudentByClassz(String classz);

//    OK
    // ͨ������β�ѯ
    public void queryStudentByAge(int beginAge, int endAge);

    // ͨ����ʸ��ѯ (ģ����ѯ)
    public void queryStudentByFirstName(String firstName);

    //����ѧ�� stuId �鵽ѧ��
    public Student queryStudentById(String stuId);

    // �޸�ѧ��
   public int updateStudent(Student stu, String addStuClazz, String Grade, String studentClazz);

    // ɾ��ѧ��
    public int deleteStudent(String id) throws SQLException;

    public ArrayList<Student> queryStudents();
}
