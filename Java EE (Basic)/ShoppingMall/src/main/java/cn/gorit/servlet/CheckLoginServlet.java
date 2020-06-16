package cn.gorit.servlet;

import cn.gorit.entity.User;
import cn.gorit.util.BaseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("�ҽ�����");
        // ��¼��֤
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String verifyCode = request.getParameter("inCode");//��ȡ�û��������֤��
        String code = (String) session.getAttribute("valiCode"); // ��ȡ��֤��

        if (code.equalsIgnoreCase(verifyCode) == false) {
            request.setAttribute("err","��֤�����");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
//        System.out.println(username + " " +password);
        // �û���֤
        BaseDao db=new BaseDao();
        ResultSet rs = null;
        try {
            PreparedStatement ps = db.getConnect("select * from user where username=? and password=?");
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if(rs.next()){
                User u=new User(rs.getInt(1), rs.getString(2), rs.getString(3));
                session.setAttribute("loginUser", u);
                response.sendRedirect("GetAllServlet"); //��ʾ����
            }else{
                session.setAttribute("msg", "��������û����������������������룡");
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
