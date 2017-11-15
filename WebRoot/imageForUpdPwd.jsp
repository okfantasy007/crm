<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page contentType="image/jpeg" import="java.awt.*,java.awt.image.*,java.util.*,javax.imageio.*" %>
<%!
Color getRandColor(int fc,int bc){//������Χ��������ɫ
        Random random = new Random();
        if(fc>255) fc=255;
        if(bc>255) bc=255;
        int r=fc+random.nextInt(bc-fc);
        int g=fc+random.nextInt(bc-fc);
        int b=fc+random.nextInt(bc-fc);
        return new Color(r,g,b);
        }
%>
<%
//����ҳ�治����
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);

// ���ڴ��д���ͼ��
int width=70, height=20;
BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

// ��ȡͼ��������
Graphics g = image.getGraphics();

//���������
Random random = new Random();

// �趨����ɫ
g.setColor(getRandColor(200,250));
g.fillRect(0, 0, width, height);

//�趨����
g.setFont(new Font("����",Font.PLAIN,18));

//���߿�
g.setColor(Color.black);
g.drawRect(0,0,width-1,height-1);

// �������155�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽
g.setColor(getRandColor(160,200));
for (int i=0;i<155;i++)
{
 int x = random.nextInt(width);
 int y = random.nextInt(height);
        int xl = random.nextInt(12);
        int yl = random.nextInt(12);
 g.drawLine(x,y,x+xl,y+yl);
}

char[] cs = new char[]{'1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','A','B','M'};  

// ȡ�����������֤��(4λ����)
String sRand="";
for (int i=0;i<4;i++){
	char c = cs[random.nextInt(cs.length)];//[0,4)
    String rand=new Character(c).toString();
    sRand+=rand;
    // ����֤����ʾ��ͼ����
    g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
//���ú�����������ɫ��ͬ����������Ϊ����̫�ӽ�������ֻ��ֱ������
    g.drawString(rand,13*i+6,16);
}

// ����֤�����session
session.setAttribute("sRand",sRand);   //���д��������ǹ�ע���ص�
// ͼ����Ч
g.dispose();

// ���ͼ��ҳ��
try{
	ImageIO.write(image, "JPEG", response.getOutputStream());
}catch(Exception e){
	e.getMessage();
}finally{

	//����Ե��ô���
	out.clear();
	out = pageContext.pushBody();
}
%>