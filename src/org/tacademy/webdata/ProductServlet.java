package org.tacademy.webdata;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tacademy.webdata.dao.ProductDAO;
import org.tacademy.webdata.vo.ProductVO;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String key = request.getParameter("key");
		String category = request.getParameter("category");
		//System.out.println("key : " + key + " category : " + category);
		
		switch (key) {
		case "empty":
			doSelectAll(request, response); 
			break;
		default :
			doSelectKeyword(request, response); 
			break;
		}
	}
	
	
	public void doSelectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		ArrayList<ProductVO> list = dao.selectAllList();
		
		request.setAttribute("result", list);;
		
		System.out.println(list);
		
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
		
	}

	public void doSelectKeyword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	
}
