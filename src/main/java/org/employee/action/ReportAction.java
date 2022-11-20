package org.employee.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.employee.bean.EmployeeBean;
import org.employee.dao.Admin;

public class ReportAction {
	
	private static final long serialVersionUID = 6329394260276112660L;
	ResultSet rs = null;
	EmployeeBean bean = null;
	List<EmployeeBean> beanList = null;
	Admin admin = new Admin();
	private boolean noData = false;


	public String execute() throws Exception {
		try {
			beanList = new ArrayList<EmployeeBean>();
			rs = admin.report();
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					bean = new EmployeeBean();
					bean.setSrNo(i);
					bean.setUname(rs.getString("emp_name"));
					bean.setUemail(rs.getString("email"));
					bean.setUpass(rs.getString("passwords").replaceAll("(?s).", "*"));
					bean.setSal(rs.getInt("salary"));
					bean.setUdeg(rs.getString("designation"));
					beanList.add(bean);
				}
			}
			if (i == 0) {
				noData = false;
			} else {
				noData = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "REPORT";
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public List<EmployeeBean> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<EmployeeBean> beanList) {
		this.beanList = beanList;
	}

}
