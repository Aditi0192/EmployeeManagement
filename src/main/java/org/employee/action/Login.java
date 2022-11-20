package org.employee.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.employee.dao.LoginDao;

public class Login implements SessionAware {
	private String uname,upass;  
	SessionMap<String,String> sessionmap;  
	  
	 
	  
	/**
	 * @return the uname
	 */
	public String getUname() {
		return uname;
	}

	/**
	 * @param uname the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}

	/**
	 * @return the upass
	 */
	public String getUpass() {
		return upass;
	}

	/**
	 * @param upass the upass to set
	 */
	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String execute(){  
	    if(LoginDao.validate(uname, upass)){  
	        return "success";  
	    }  
	    else{  
	        return "error";  
	    }  
	}  
	  
	public void setSession(Map map) {  
	    sessionmap=(SessionMap)map;  
	    sessionmap.put("login","true");  
	}  
	  
	public String logout(){  
	    sessionmap.invalidate();  
	    return "success";  
	}  
	  
	

}
