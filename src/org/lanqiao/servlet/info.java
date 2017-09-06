package org.lanqiao.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.lanqiao.entity.Category;
import org.lanqiao.entity.Goods;
import org.lanqiao.entity.Publisher;
import org.lanqiao.mapper.PublisherMapper;
import org.lanqiao.service.CategoryService;
import org.lanqiao.service.CategoryServiceImpl;
import org.lanqiao.service.GoodsService;
import org.lanqiao.service.GoodsServiceImpl;

@WebServlet("/info.do")
public class info extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static SqlSessionFactory sqlSessionFactory = null;
	static{
		String resource = "mybaties-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gid = request.getParameter("gid");
		if(gid==null){
			gid="1";
		}
		String pid = request.getParameter("pid");
		if(pid==null){
			pid="1";
		}
		String cid = request.getParameter("cid");
		if(cid==null){
			cid="1";
		}
		request.setAttribute("cid", cid);
		GoodsService gs = new GoodsServiceImpl();
		
		SqlSession session = sqlSessionFactory.openSession();
		PublisherMapper mapper = session.getMapper(PublisherMapper.class);
		Publisher publisher = mapper.getPublisher(pid);
		List<Goods> goodlist = gs.goodslist(gid);
		CategoryService cs = new CategoryServiceImpl();
		List<Category> categorylist = cs.list();
		request.setAttribute("goodlist", goodlist);
		request.setAttribute("categorylist", categorylist);
		request.setAttribute("publisher", publisher);
		session.close();
		request.getRequestDispatcher("WEB-INF/info.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
