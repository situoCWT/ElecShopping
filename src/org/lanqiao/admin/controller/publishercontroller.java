package org.lanqiao.admin.controller;

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
import org.lanqiao.entity.Publisher;
import org.lanqiao.mapper.PublisherMapper;
import org.lanqiao.service.PublisherService;
import org.lanqiao.service.PublisherServiceImpl;

import com.google.gson.Gson;

@WebServlet("/publishercontroller.do")
public class publishercontroller extends HttpServlet {
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
		String type = request.getParameter("type");
		if(type!=null&&type.equals("search"))
		{
			SqlSession session = sqlSessionFactory.openSession();
			PublisherMapper mapper = session.getMapper(PublisherMapper.class);
			List<Publisher> list = mapper.getAllPublisher();
			Gson gson = new Gson();
			session.close();
			response.getWriter().write(gson.toJson(list));
		}
		else if(type!=null&&type.equals("del")){
			String pid = request.getParameter("pid");
			SqlSession session = sqlSessionFactory.openSession();
			PublisherMapper mapper = session.getMapper(PublisherMapper.class);
			mapper.deletePublisher(pid);
			session.commit();
			session.close();
			response.getWriter().write("1");
		}
		else if(type!=null&&type.equals("add")){
			String pid = request.getParameter("addpid");
			String pname = request.getParameter("addpname");
			Publisher chkpublisher = null;
			SqlSession session = sqlSessionFactory.openSession();
			PublisherMapper mapper = session.getMapper(PublisherMapper.class);
			chkpublisher = mapper.getPublisher(pid);
			if(chkpublisher == null)
			{
				Publisher publisher = new Publisher();
				publisher.setPid(pid);
				publisher.setPname(pname);
				mapper.insertPublisher(publisher);
				session.commit();
				session.close();
				response.getWriter().write("1");
			}
			if(chkpublisher != null)
			{
				session.close();
				response.getWriter().write("0");
			}
		}
		else if(type!=null&&type.equals("edit")){
			String pid = request.getParameter("editpid");
			String pname = request.getParameter("editpname");
			SqlSession session = sqlSessionFactory.openSession();
			PublisherMapper mapper = session.getMapper(PublisherMapper.class);
			Publisher publisher = new Publisher();
			publisher.setPid(pid);
			publisher.setPname(pname);
			mapper.updatePublisher(publisher);
			session.commit();
			session.close();
			response.getWriter().write("1");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
