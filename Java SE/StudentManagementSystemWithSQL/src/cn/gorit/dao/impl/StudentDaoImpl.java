package cn.gorit.dao.impl;

import cn.gorit.dao.StudentDao;
import cn.gorit.entity.Classz;
import cn.gorit.entity.Student;
import cn.gorit.main.App;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static cn.gorit.main.App.in;

public class StudentDaoImpl implements StudentDao {

    // ok
    @Override
    public int addStudent() {
        Student stu = new Student();
        System.out.println("������ѧ���� ID");
        stu.setStuId(in.next());
        System.out.println("������ѧ��������");
        stu.setStuName(in.next());
        System.out.println("������ѧ��������");
        stu.setStuAge(in.nextInt());

        System.out.println("������ѧ�����꼶");
        String grade = in.next();
        System.out.println("������ѧ�����ڰ༶");
        String clasz = in.next();
        Classz classz = new Classz(grade,clasz);

        // ѧ�����ڰ༶����
        stu.setClassz(classz.toString());

        // �������ݿ�
        String sql = "insert into student(stuId, stuName, stuAge, classz) values(?,?,?,?)";

        try {
            PreparedStatement ps = App.db.getConnect(sql);
            ps.setString(1, stu.getStuId());
            ps.setString(2,stu.getStuName());
            ps.setInt(3,stu.getStuAge());
            ps.setString(4, stu.getClassz());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            addClasz(grade,clasz,stu);
        }

        return 0;
    }

    private static void addClasz(String grade, String clasz, Student stu) {
        String sql1 = "insert into classz(grade, clasz, stuId) values(?,?,?)";
        try {
            PreparedStatement ps1 = App.db.getConnect(sql1);
            ps1.setString(1,grade);
            ps1.setString(2,clasz);
            ps1.setString(3,stu.getStuId());
            int res = ps1.executeUpdate();
            if (res > 0) {
                ps1.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // OK
    @Override
    public void queryStudents() {
        try {
            PreparedStatement ps = App.db.getConnect("select * from student");
            ResultSet set = ps.executeQuery();
            while (set.next()) {
                System.out.println(set.getString(1) + "\t"+set.getString(2)+"\t"+set.getInt(3)+"\t"+set.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void queryStudentByName(String stuName) {
        String sql = "select * from student where stuName = ?";
        try {
            PreparedStatement ps = App.db.getConnect(sql);
            ps.setString(1,stuName);
            ResultSet set = ps.executeQuery();
            while (set.next()) {
                System.out.println(set.getString(1) + "\t"+set.getString(2)+"\t"+set.getInt(3)+"\t"+set.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void queryStudentByClassz(String classz) {
        String sql = "select * from student where classz = ?";
        try {
            PreparedStatement ps = App.db.getConnect(sql);
            ps.setString(1,classz);
            ResultSet set = ps.executeQuery();
            while (set.next()) {
                System.out.println(set.getString(1) + "\t"+set.getString(2)+"\t"+set.getInt(3)+"\t"+set.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void queryStudentByAge(int beginAge, int endAge) {
        if (beginAge != endAge) {
            String sql = "select * from student where stuAge between ? and ?";
            try {
                PreparedStatement ps = App.db.getConnect(sql);
                ps.setInt(1,beginAge);
                ps.setInt(2,endAge);
                ps.executeQuery();
                ResultSet set = ps.executeQuery();
                while (set.next()) {
                    System.out.println(set.getString(1) + "\t"+set.getString(2)+"\t"+set.getInt(3)+"\t"+set.getString(4));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            String sql = "select * from student where stuAge = ? ";
            try {
                PreparedStatement ps = App.db.getConnect(sql);
                ps.setInt(1,beginAge);
                ps.executeQuery();
                ResultSet set = ps.executeQuery();
                while (set.next()) {
                    System.out.println(set.getString(1) + "\t"+set.getString(2)+"\t"+set.getInt(3)+"\t"+set.getString(4));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    // ģ����ѯ
    @Override
    public void queryStudentByFirstName(String firstName) {
        String sql = "select * from student where stuName like ?";
        try {
            PreparedStatement ps = App.db.getConnect(sql);
            ps.setString(1,"%"+firstName+"%");
            ps.executeQuery();
            ResultSet set = ps.getResultSet();
            while (set.next()) {
                System.out.println(set.getString(1) + "\t"+set.getString(2)+"\t"+set.getInt(3)+"\t"+set.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // OK
    @Override
    public int updateStudent()  {
        System.out.println("��������Ҫ�޸ĵ�ѧ����Ϣ�� ID");
        String id = in.next();
        String sql = "update student set stuName = ?, stuAge = ?, classz = ? where stuId = ?";
        Student stu = new Student();
        System.out.println("������ѧ�������֣�");
        stu.setStuName(in.next());
        System.out.println("������ѧ�������䣺");
        stu.setStuAge(in.nextInt());
        Classz classz = new Classz();
        System.out.println("������ѧ�����꼶��");
        classz.setGrade(in.next());
        System.out.println("������ѧ����רҵ�༶������ �ƿ�3�ࣩ");
        classz.setClasz(in.next());
        stu.setClassz(classz.toString());
        try {
            PreparedStatement ps = App.db.getConnect(sql);
            ps.setString(1,stu.getStuName());
            ps.setInt(2,stu.getStuAge());
            ps.setString(3,stu.getClassz());
            ps.setString(4,id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    // OK
    @Override
    public int deleteStudent(String id) {
        System.out.println("��������Ҫɾ����ѧ���� id��");
        String sql = "delete from student where stuId = ?";
        try {
            PreparedStatement ps = App.db.getConnect(sql);
            ps.setString(1,id);
            int res = ps.executeUpdate();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
