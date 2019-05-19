package com.amc.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amc.dao.AppointmentDao;
import com.amc.dao.CustomerDao;
import com.amc.dao.DoctorDao;
import com.amc.dao.UserDao;
import com.amc.model.Appointment;
import com.amc.model.User;

public class StaffServlet extends HttpServlet {
	
	
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

		case "customer_register":
			registerUser(request, response);
			break;

		case "update_customer":
			updateUser(request, response);
			break;
			
		case "add_appointment":
			try {
				addAppointment(request, response);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
			
		case "update_appointment":
			try {
				updateAppointment(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case "delete_appointment":
			deleteAppointment(request,response);
			break;
			
		

		
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {

		case "view_customers":
			viewUsers(request, response);
			break;

		case "load_customer":
			loadUser(request, response);
			break;

		case "delete_customer":
			deleteUser(request, response);
			break;
			
		case "load_appointment_details":
			loadAppointmentDetails(request, response);
			break;
			
		case "view_appointments":
			viewAppointments(request, response);
			break;
			
		case "load_appointment":
			loadAppointment(request, response);
			break;
			
		case "delete_appointment":
			deleteAppointment(request,response);
			break;
		}
	}

	public void registerUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();
		user.setUserId(request.getParameter("userId"));
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));
		user.setName(request.getParameter("name"));
		user.setGender(request.getParameter("gender"));
		user.setPhone(Integer.parseInt(request.getParameter("phone")));
		user.setNic(Integer.parseInt(request.getParameter("nic")));
		user.setEmail(request.getParameter("email"));
		user.setAddress(request.getParameter("address"));
		user.setRole("Customer");

		UserDao ud = new UserDao();
		if (ud.addUser(user)) {
			request.setAttribute("NOTIFICATION", "Customer added Successfully!");
			dispatcher = request.getRequestDispatcher("/staff-dashboard.jsp");
			dispatcher.forward(request, response);
		}
	}

	public void viewUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> list = new ArrayList<>();

		CustomerDao cd = new CustomerDao();
		list = cd.getAllCustomers();
		
		request.setAttribute("list", list);
		dispatcher = request.getRequestDispatcher("/staff-customer-view.jsp");
		dispatcher.forward(request, response);

	}

	public void loadUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao ud = new UserDao();
		//System.out.println(request.getParameter("id"));
		User user = ud.loadUser(request.getParameter("id"));

		request.setAttribute("editUser", user);
		dispatcher = request.getRequestDispatcher("/staff-customer-update.jsp");
		dispatcher.forward(request, response);
		//System.out.println(user.getName());

	}

	public void updateUser(HttpServletRequest request, HttpServletResponse response)
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
		user.setRole("Customer");

		UserDao ud = new UserDao();
		if (ud.updateUser(user)) {
			request.setAttribute("NOTIFICATION", "User update Successfully!");
			dispatcher = request.getRequestDispatcher("/staff-dashboard.jsp");
			dispatcher.forward(request, response);
		}

	}

	public void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao ud = new UserDao();
		if (ud.deleteUser(request.getParameter("id"))) {

			request.setAttribute("NOTIFICATION", "User delete Successfully!");
			dispatcher = request.getRequestDispatcher("/staff-dashboard.jsp");
			dispatcher.forward(request, response);
		}

	}
	
	public void loadAppointmentDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DoctorDao dd = new DoctorDao();
		//System.out.println(request.getParameter("id"));
		List<String> docList = dd.getDoctorIdList();
		
		CustomerDao cd = new CustomerDao();
		List<String> cusList = cd.getCustomerIdList();

		request.setAttribute("docList", docList);
		request.setAttribute("cusList", cusList);
		dispatcher = request.getRequestDispatcher("/staff-appointment-add.jsp");
		dispatcher.forward(request, response);
		//System.out.println(user.getName());

	}
	
	
	public void addAppointment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {

		Appointment appointment = new Appointment();
		appointment.setAppointmentId(request.getParameter("appointmentId"));
		appointment.setCustomerId(request.getParameter("customerId"));
		appointment.setDoctorId(request.getParameter("doctorId"));
		appointment.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date")));
		
		AppointmentDao ad = new AppointmentDao();
		
		if (ad.addAppointment(appointment)) {
			request.setAttribute("NOTIFICATION", "Appointment added Successfully!");
			dispatcher = request.getRequestDispatcher("/staff-dashboard.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	public void viewAppointments(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Appointment> list = new ArrayList<>();

		AppointmentDao ad = new AppointmentDao();
		list = ad.getAllAppointments();
		
		request.setAttribute("list", list);
		dispatcher = request.getRequestDispatcher("/staff-appointment-view.jsp");
		dispatcher.forward(request, response);

	}
	
	public void loadAppointment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DoctorDao dd = new DoctorDao();
		//System.out.println(request.getParameter("id"));
		List<String> docList = dd.getDoctorIdList();
		
		CustomerDao cd = new CustomerDao();
		List<String> cusList = cd.getCustomerIdList();

		request.setAttribute("docList", docList);
		request.setAttribute("cusList", cusList);
		
		AppointmentDao ad = new AppointmentDao();
		//System.out.println(request.getParameter("id"));
		Appointment appointment = ad.loadAppointment(request.getParameter("id"));

		request.setAttribute("editAppointment", appointment);
		dispatcher = request.getRequestDispatcher("/staff-appointment-update.jsp");
		dispatcher.forward(request, response);
		//System.out.println(user.getName());

	}
	
	public void updateAppointment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {

		Appointment appointment = new Appointment();
		
		appointment.setAppointmentId(request.getParameter("id"));
		appointment.setCustomerId(request.getParameter("customerId"));
		appointment.setDoctorId(request.getParameter("doctorId"));
		appointment.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date")));
		
		System.out.println(appointment.getComment()+" "+appointment.getDurationLeft()+" "+appointment.getMedicine());
		
		AppointmentDao ad = new AppointmentDao();
		
		if (ad.updateAppointment(appointment)) {
			request.setAttribute("NOTIFICATION", "Appointment update Successfully!");
			dispatcher = request.getRequestDispatcher("/staff-dashboard.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	public void deleteAppointment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AppointmentDao ad = new AppointmentDao();
		if (ad.deleteAppointment(request.getParameter("id"))) {

			request.setAttribute("NOTIFICATION", "Appointment delete Successfully!");
			dispatcher = request.getRequestDispatcher("/staff-dashboard.jsp");
			dispatcher.forward(request, response);
		}

	}
	
	

}
