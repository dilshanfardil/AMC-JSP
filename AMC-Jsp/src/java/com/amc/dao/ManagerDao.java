package com.amc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amc.model.Report;
import com.amc.util.DbUtil;

public class ManagerDao {
	
	public List<Report> getReportList() {
		List<Report> list = new ArrayList<>();
		Connection connection = null;
		
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connection = DbUtil.getConnection();
			stmt = connection.createStatement();
			String sql = "SELECT year, month, COUNT(charge) AS app_total, SUM(charge) AS charge_total "+ 
							"FROM "+
							"( "+
							"SELECT app_id, EXTRACT (YEAR FROM app_date) AS YEAR, "+
								"EXTRACT (MONTH FROM app_date) AS MONTH, charge "+
								"FROM appointments WHERE is_paid=TRUE "+
								") "+
							"AS x GROUP BY year, month";
		
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Report report = new Report();
				report.setYear((int)rs.getDouble(1));
				report.setMonth((int)rs.getDouble(2));
				report.setTotalAppointments(rs.getInt(3));
				report.setTotalSells((int)rs.getDouble(4));
				
				list.add(report);
			}
			
		
		} catch (Exception e) {
			System.out.println("Error: Manager " + e);
		} finally {
			try {
				rs.close();
				stmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return list;

	}

}
