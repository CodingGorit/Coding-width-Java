package cn.gorit.dao;

import cn.gorit.entity.Classz;


public interface StudentDao {

    public int addStudent();

    // ͨ�� ������ѯѧ��
    public void queryStudentByName(String stuName);

    // ͨ���༶��ѯѧ����Ϣ
    public void queryStudentByClassz(String classz);

//    OK
    // ͨ������β�ѯ
    public void queryStudentByAge(int beginAge, int endAge);

    // ͨ����ʸ��ѯ (ģ����ѯ)
    public void queryStudentByFirstName(String firstName);

    // �޸�ѧ��
   public int updateStudent();

    // ɾ��ѧ��
    public int deleteStudent(String id);

    public void queryStudents();
}
