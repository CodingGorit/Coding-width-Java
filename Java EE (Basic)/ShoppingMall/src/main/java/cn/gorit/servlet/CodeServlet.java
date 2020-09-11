package cn.gorit.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * ����һ�� 6λ������֤�룬����ŵ� session ���� valiCode
 * ��ͨ�� response ����
 * */
@WebServlet("/CodeServlet")
public class CodeServlet extends HttpServlet {
    private Random random = new Random();
    private int width = 80;//���
    private int height = 40;//�߶�
    private int fontsize = 20;//�����С
    private String str = "0123456789abcdefghijklmnxnlopiiqusdakljnalwABCDEFGHIJKLMNOPQRSTUVWXYZ";

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

    //-------------  ��������ַ�������ɫ
    private Color randColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r,g,b);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. ���� servlet ����ʾ����
        response.setContentType("image/png");
        // 2. ��������һ���������֤��
        //1. ��������
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //2.��������
        Graphics2D pen = (Graphics2D)img.getGraphics();
        //3.�����������
        String code = randCode1(4); //���� 4λ����֤��
        System.out.println(code);
        request.getSession().setAttribute("valiCode", code); //���� code�� session,�ͺ�������ݶ�Ӧ

        //4.��������
        //	4.1 ���û�������
        pen.fillRect(0, 0, width, height);
        //	4.2��������
        pen.setFont(new Font("΢���ź�",Font.BOLD,fontsize));
        //	4.3 ��˳����������ַ�
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
