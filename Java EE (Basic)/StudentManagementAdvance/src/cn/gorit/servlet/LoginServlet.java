package cn.gorit.servlet;

import cn.gorit.dao.impl.StudentDaoImpl;
import cn.gorit.entity.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");
        // �õ��˻�����
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        ServletContext application = request.getServletContext();
        HttpSession session = request.getSession();

        // �û���֤
        int res = new StudentDaoImpl().Login(username,password);

        ArrayList<Student> list = new StudentDaoImpl().queryStudents();
        if (res > 0) {

            // ����ͳ��
            User logineduser = new User(username,password);
            session.setAttribute("LOGINED_USER",logineduser);

            List loginerdUsers = new ArrayList(); // �������б�
            if (application.getAttribute("LOGINED_USER") != null) {
                loginerdUsers = (List) application.getAttribute("LOGINED_USER");
            }
            loginerdUsers.add(logineduser); // ���µ�¼���û���Ϣ����������б���
            application.setAttribute("LOGINED_USER", loginerdUsers);

            // �ѿ��Դ����¼����Ϣ
            Cookie c = new Cookie("accessMsg",username);
            c.setMaxAge(300);
            //���͵��ͻ��˽��б���
            response.addCookie(c);
//            session.setAttribute("username",username);
            application.setAttribute("list",list);
        } else {
            request.setAttribute("msg","�˺Ż����벻��ȷ");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        response.sendRedirect("show.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
