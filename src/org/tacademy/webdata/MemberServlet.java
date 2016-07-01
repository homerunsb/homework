package org.tacademy.webdata;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tacademy.webdata.dao.AnMemberDAO;
import org.tacademy.webdata.vo.AnMemberVO;


/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");

		switch (action) {
		case "login":
			doLogin(request, response); 
			break;
		case "insert":
			doJoin(request, response);
			break;
		case "check":
			doCheck(request, response);
			break;
		}
	}
	
	public void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String result = null;
		String name = null;
		
		AnMemberDAO dao = new AnMemberDAO();
		AnMemberVO vo = new AnMemberVO();
		
		vo.setId(request.getParameter("id"));
		vo.setPw(request.getParameter("pw"));
		
		dao.doLogin(vo);
		System.out.println(vo);
		
		name = vo.getName();
		result = (name == null) ? "fail" : name;
		request.setAttribute("result", result);

		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}
	
	public void doJoin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		AnMemberDAO dao = new AnMemberDAO();
		AnMemberVO vo = new AnMemberVO();

		vo.setId(request.getParameter("id"));
		vo.setPw(request.getParameter("pw"));
		vo.setName(request.getParameter("name"));
		vo.setTel(request.getParameter("tel"));
		vo.setAddress(request.getParameter("address"));
		vo.setComment(request.getParameter("comment"));

		System.out.println(vo);
			
		dao.doJoin(vo);
	}
	
	public void doCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String result = null;
		
		AnMemberDAO dao = new AnMemberDAO();
		AnMemberVO vo = new AnMemberVO();
		
		vo.setId(request.getParameter("id"));
		
		result = (dao.doCheck(vo)) ? "fail" : vo.getId();

		System.out.println("ID 체크 : " + result);
		request.setAttribute("result", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}
	
	
}
