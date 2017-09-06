package org.lanqiao.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check.do")
public class check extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//生成验证码
		String codes = "QWERTYUIOPLKJHGFDSAZXCVBNMqwertyuioplkjhgfdsazxcvbnm0123456789";
		String code = "";
		Random random = new Random();
		for(int i=0;i<4;i++)
		{
			code += codes.charAt(random.nextInt(61));
		}
		request.getSession().setAttribute("code", code);
		//绘画
		BufferedImage bufferedImage = new BufferedImage(90, 30, BufferedImage.TYPE_INT_BGR);
		//创建画笔
		Graphics g = bufferedImage.createGraphics();
		//填充背景
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 90, 30);
		//画边框
		g.setColor(Color.RED);
		g.drawRect(0, 0, 89, 29);
		//添加验证码
		g.drawString(code, 20, 20);
		response.setContentType("Image/jpeg");
		ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
