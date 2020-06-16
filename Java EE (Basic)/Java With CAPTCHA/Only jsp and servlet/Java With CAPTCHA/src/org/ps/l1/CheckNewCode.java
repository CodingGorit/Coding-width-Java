package org.ps.l1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.awt.RepaintArea;

/**
 * @author: Gorit
 * @see readme.nd
 * @version 1.0.0
 * @date 2019��12��19��21:00:53
 */
@WebServlet("/CheckNewCode")
public class CheckNewCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckNewCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.�õ�����
		String inCode = request.getParameter("inCode").toString().toLowerCase();//��ȡǰ�˽�����������Ƿ����,����ַ����Լ�Сд�ַ���
		String valiCode = request.getSession().getAttribute("valiCode").toString().toLowerCase();//��ȡǰ�� session �б��������
		//2.��֤�Ƿ����
		if (inCode.equals(valiCode)) {
			request.setAttribute("msg", "Hello World");
			response.sendRedirect("loginSuccess.jsp");//�ض���
		} else {
			request.getSession().setAttribute("err", "��֤�������������������");
			//������һҳ
			String url = request.getHeader("Referer");
			response.sendRedirect(url);
		}
	}

}
