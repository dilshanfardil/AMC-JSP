package com.amc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amc.dao.LoginDao;
import com.amc.dao.UserDao;
import com.amc.model.User;


public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		
		switch (action) {

		case "login":
			login(request, response);
			break;
			
		case "update_profile" :
			updateProfile(request, response);
			break;
			
			
		}

	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		switch (action) {

		
			
		case "load_profile" :
			loadProfile(request, response);
			break;
			
		case "logout":
			logout(request,response);
			break;
                    
                case "error":
                        logout(request,response);
                        break;
			
			
		}
	}

	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//System.out.println(username+" "+password+" at serv");

		LoginDao ld = new LoginDao();
		User currentUser = ld.validateUser(username, password);
		String path = "";
		if (currentUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("currentUserId", currentUser.getUserId());
			
			
			//System.out.print(currentUser.getRole());
			switch (currentUser.getRole()) {
			case "Manager":
				path = "/manager-dashboard.jsp";
				break;

			case "Counter Staff":
				path = "/staff-dashboard.jsp";
				break;

			case "Doctor":
				path = "/doctor-dashboard.jsp";
				break;

			case "Customer":
				path = "/customer-dashboard.jsp";
				break;

			default:

			}

		}

		dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	
	public void loadProfile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao ud = new UserDao();
		System.out.println(request.getParameter("id"));
		
		HttpSession session = request.getSession();
		
		User user = ud.loadUser(String.valueOf(session.getAttribute("currentUserId")));

		request.setAttribute("editUser", user);
		dispatcher = request.getRequestDispatcher("/user-update.jsp");
		dispatcher.forward(request, response);
		//System.out.println(user.getName());

	}

	public void updateProfile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();
		user.setUserId(request.getParameter("id"));
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));
		user.setName(request.getParameter("name"));
		user.setGender(request.getParameter("gender"));
		user.setPhone(Integer.parseInt(request.getParameter("phone")));
		user.setNic(Integer.parseInt(request.getParameter("nic")));
		user.setEmail(request.getParameter("email"));
		user.setAddress(request.getParameter("address"));
		
		LoginDao ld = new LoginDao();
		String role = ld.getUserRole(user.getUserId());
		
		user.setRole(role);
		

		UserDao ud = new UserDao();
		if (ud.updateUser(user)) {
			request.setAttribute("NOTIFICATION", "Profile update Successfully!");
			
			switch(role) {
				
			case "Doctor" :
				dispatcher = request.getRequestDispatcher("/doctor-dashboard.jsp");
				break;
				
			case "Customer" :
				dispatcher = request.getRequestDispatcher("/customer-dashboard.jsp");
				break;
			}
			
			dispatcher.forward(request, response);
		}

	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);

	}

}
