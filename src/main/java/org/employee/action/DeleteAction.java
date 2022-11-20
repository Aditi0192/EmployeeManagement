package org.employee.action;

import org.employee.dao.Admin;

public class DeleteAction {
	
	private static final long serialVersionUID = -146601914103585418L;
	String uemail, msg;
	Admin dao = new Admin();

	
	public String execute() throws Exception {
		try {
			int isDeleted = dao.deleteUserDetails(uemail);
			if (isDeleted > 0) {
				msg = "Record deleted successfully";
			} else {
				msg = "Some error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "DELETE";
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


}
