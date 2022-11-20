package org.employee.action;

import java.sql.ResultSet;

import org.employee.dao.Admin;

public class UpdateAction {
	
	private static final long serialVersionUID = -1905974197186620917L;
	private String uname = "", uemail = "", upass = "", udeg = "", uemailhidden = "";
	private int sal;
	private String msg = "";
	ResultSet rs = null;
	Admin dao = new Admin();
	String submitType;


	public String execute() throws Exception {
		try {
			if (submitType.equals("updatedata")) {
				rs = dao.fetchUserDetails(uemail.trim());
				if (rs != null) {
					while (rs.next()) {
						uname = rs.getString("emp_name");
						uemail = rs.getString("email");
						upass = rs.getString("passwords");
						sal = rs.getInt("salary");
						udeg = rs.getString("designation");
					}
				}
			} else {
				int i = dao.updateUserDetails(uname, uemail, upass, udeg,sal, uemailhidden);
				if (i > 0) {
					msg = "Record Updated Successfuly";
				} else {
					msg = "error";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "UPDATE";
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	
	/**
	 * @return the sal
	 */
	public int getSal() {
		return sal;
	}

	/**
	 * @param sal the sal to set
	 */
	public void setSal(int sal) {
		this.sal = sal;
	}

	public String getUdeg() {
		return udeg;
	}

	public void setUdeg(String udeg) {
		this.udeg = udeg;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUemailhidden() {
		return uemailhidden;
	}

	public void setUemailhidden(String uemailhidden) {
		this.uemailhidden = uemailhidden;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}


}
