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

@WebServlet("/AddProIntoShopcartServlet")
public class AddProIntoShopcartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");

        // ����¼״̬
        HttpSession session = request.getSession();
        if (session.getAttribute("loginUser") != null) {
            System.out.println("������");
            // ��¼���ˣ�����Ʒ���뵽���ﳵ
            int pid = Integer.valueOf(request.getParameter("pid")); // �õ������ id��Ȼ��������ݿ�
            User u = (User) session.getAttribute("loginUser");
            int uid = u.getId();
            BaseDao db=new BaseDao();
             try {
                // �������жϣ����� id �Ƿ��ظ�������ظ����͸���
                PreparedStatement ps1 = db.getConnect("select num from shopcart where pid = ?");
                ps1.setInt(1,pid);
                ResultSet rs = ps1.executeQuery();
                if (!rs.next()) { //˵����������¼
                    // û�м�¼�������һ������
                    System.out.println("�ҽ����˲�������");
                    PreparedStatement ps=db.getConnect("insert into shopcart (pid,uid,num) values (?,?,?)");
                    ps.setInt(1, pid);
                    ps.setInt(2, uid);
                    ps.setInt(3, 1);
                    ps.executeUpdate();
                } else {
                    System.out.println("�м�¼���ۼ�����");
                    int num = rs.getInt(1);
                    PreparedStatement ps2 = db.getConnect("update shopcart set num = num+1 where uid = ? and pid = ?");
                    ps2.setInt(1,uid);
                    ps2.setInt(2,pid);
                    ps2.executeUpdate();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
           // ��ʾ���ﳵҳ��
           response.sendRedirect("ShowAllServlet");
        } else {
            session.setAttribute("msg","���ȵ�¼���ټ��빺�ﳵ");
            response.sendRedirect("login.jsp");
        }

    }
}
