package com.bit2016.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2016.guestbook2.dao.guestbookDao;
import com.bit2016.guestbook2.vo.guestbookVo;

/**
 * Servlet implementation class guestbookservelt
 */
@WebServlet("/gb")
public class guestbookservelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String actionName=request.getParameter("a");
		if("add".equals(actionName)){
			String name=request.getParameter("name");
			String passwd=request.getParameter("password");
			String context=request.getParameter("content");
			
			
			guestbookVo vo=new guestbookVo();
			vo.setName(name);
			vo.setPasswd(passwd);
			vo.setContext(context);
			
			guestbookDao dao=new guestbookDao();
			dao.insert(vo);
		
			response.sendRedirect("/guestbook2/gb");
		}
		else if("deleteform".equals(actionName)){
			//no받아주고  리퀘스트 디스패쳐 만들어서 리퀘스트에다가 no담고 포워드
			int no=Integer.parseInt(request.getParameter("no"));
			request.setAttribute("no", no);
			
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
			rd.forward(request, response);
		}else if("delete".equals(actionName))
		{
			int no=Integer.parseInt(request.getParameter("no"));
			guestbookVo vo=new guestbookVo();
			vo.setNo(no);
			guestbookDao dao=new guestbookDao();
			dao.delete(no);
			
			response.sendRedirect("/guestbook2/gb");
		}else{
			//dao넣고 vo담아서 리스트 출력
			guestbookDao dao=new guestbookDao();
			List<guestbookVo> list=dao.getList();
			
			request.setAttribute("list", list);
			
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
