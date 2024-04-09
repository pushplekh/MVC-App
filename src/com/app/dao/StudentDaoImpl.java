package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dto.Student;

import oracle.jdbc.pool.OracleDataSource;

//@Component
@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private OracleDataSource dataSource;

	@Override
	public String add(Student student) {
		String status = "";
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from student where sid = ?");
			pst.setString(1, student.getSid());
			ResultSet rs = pst.executeQuery();
			boolean b = rs.next();
			if (b == true) {
				status = "existed";
			} else {
				pst = con.prepareStatement("insert into student values(?,?,?)");
				pst.setString(1, student.getSid());
				pst.setString(2, student.getSname());
				pst.setString(3, student.getSaddr());

				int rowCount = pst.executeUpdate();
				if (rowCount == 1) {
					status = "success";
				} else {
					status = "failure";
				}
			}

		} catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public Student search(String sid) {
		Student student = new Student();
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from student where sid=?");
			ps.setString(1, sid);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				student.setSid(rs.getString("SID"));
				student.setSname(rs.getString("SNAME"));
				student.setSaddr(rs.getString("SADDR"));
			} else {
				student = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return student;
	}

	@Override
	public String update(Student student) {
		String status = "";
		Connection con;
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("update Student set SNAME = ?, SADDR = ? where SID=?");
			ps.setString(1, student.getSname());
			ps.setString(2, student.getSaddr());
			ps.setString(3, student.getSid());

			int rowCount = ps.executeUpdate();
			if (rowCount == 1)
				;
			status = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public String delete(String sid) {
		String status = "";
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from student where SID = ?");
			pst.setString(1, sid);
			ResultSet rs = pst.executeQuery();

			boolean b = rs.next();

			if (b) {
				pst = con.prepareStatement("delete from student where sid = ?");
				pst.setString(1, sid);
				int rowCount = pst.executeUpdate();
				if (rowCount == 1) {
					status = "success";
				} else {
					status = "failure";
				}
			} else {
				status = "notExisted";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
