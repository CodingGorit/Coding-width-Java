package cn.gorit.servlet;

import cn.gorit.dao.StudentDao;
import cn.gorit.dao.impl.StudentDaoImpl;
import cn.gorit.entity.Student;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");
        String addStuId = request.getParameter("addStuId");
        String addStuName = request.getParameter("addStuName");
        int addStuAge = Integer.parseInt(request.getParameter("addStuAge"));
        String addStuClazz = request.getParameter("addStuClazz"); // �������ϵ�����
        Student u = new Student(addStuId,addStuName,addStuAge,addStuClazz);

        String Grade = request.getParameter("Grade"); // ��ȡѧ�������꼶
        String studentClazz = request.getParameter("studentClazz"); // ��ȡѧ�����ڰ༶
        System.out.println(u.toString());

        // �õ�ѧ����Ϣ���������ݿ�
        StudentDao dao = new StudentDaoImpl();
        int res = dao.addStudent(u,addStuClazz,Grade,studentClazz);
        // �����֮�����²�ѯ����
        PrintWriter out = response.getWriter();
        if (res > 0) {
            System.out.println("��ӳɹ�");
            ArrayList<Student> list = new StudentDaoImpl().queryStudents();
            ServletContext application = request.getServletContext();
            application.setAttribute("list",list);
            response.sendRedirect("show.jsp");
        } else {
            System.out.println("���ʧ��");
            out.println("false");
            out.flush();
            out.close();
            response.sendRedirect("show.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
