package org.ps.l1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * @author: Gorit
 * @see readme.nd
 * @version 1.0.0
 * @date 2019��12��19��21:00:53
 */
//@WebServlet("/NewCode")
public class NewCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Random random = new Random();
    private int width = 80;//���
    private int height = 30;//�߶�
    private int fontsize = 12;//�����С
    private String str = "0123456789abcdefghijklmnxnlopiiqusdakljnalw";
    
    //----------- �򵥰汾 -------------
    private String randCode() { //���� 4���ַ� ����ַ�������
    	String code = "";
    	for (int i=0; i<4; i++) {
    		code +=str.charAt(random.nextInt(str.length()));
    	}
    	return code;
    }
    
    //------------ ���������ĸ��ַ�������ַ��� --
    private String randCode1(int len) {
    	if (len < 4) {
    		len = 4;
    	}
    	//���Ŀ��
    	width = 5 + fontsize*len ;
       	String code = "";
    	for (int i=0; i<len; i++) {
    		code +=str.charAt(random.nextInt(str.length()));
    	}
    	return code;
    }
    
    //��������ַ�������ɫ
    private Color randColor() {
    	int r = random.nextInt(256);
    	int g = random.nextInt(256);
    	int b = random.nextInt(256);
    	return new Color(r,g,b);
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewCode() {
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
		//1. ��������
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//2.��������
		Graphics2D pen = (Graphics2D)img.getGraphics();
		//3.�����������
		String code = randCode(); //��Թ̶����ݵĲ��������Ѷ�
		request.getSession().setAttribute("valiCode", code); //���� code,�ͺ�������ݶ�Ӧ
		//4.��������
		//	4.1 ���û�������
		pen.fillRect(0, 0, width, height);
		//	4.2��������
		pen.setFont(new Font("΢���ź�",Font.BOLD,fontsize));
		//	4.3��˳����������ַ�
		for (int i = 0;i<code.length();i++) {
			pen.setColor(randColor());//ÿ���ַ�ʹ�ò�ͬ����ɫ
			//�����ַ�
			//code.charAt(i) ��õ��ǵ����ַ�����˼�һ�� "" ʹ�����ַ���
			pen.drawString(code.charAt(i)+"", 5+i*fontsize,(fontsize + height)/2);
		}
		
		//	4.4 ����������  ------------------ ������֤���Ѷ�
		for (int i = 0;i < 2; i++) {
			pen.setColor(randColor());//���û�����ɫ
			pen.setStroke(new BasicStroke(3));//��������Ϊ 3������
			//���ߵ����꣺x1,y1 x2,y2
			pen.drawLine(random.nextInt(width/2), random.nextInt(height), random.nextInt(width), random.nextInt(width));
		}
		//5.��ΪͼƬ������
		ServletOutputStream out = response.getOutputStream();//����ͨ�� response ����
		ImageIO.write(img, "png", out);
		out.flush();//����ˢ��
		out.close();//����ر�
	}

}
