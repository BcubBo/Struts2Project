package action;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import util.Page;

public class BaseAction extends ActionSupport implements RequestAware, SessionAware{
	private static final long serialVersionUID = 6735419554782593786L;
	public Map<String, Object> session;
	public Map<String, Object> request;
	protected Logger logger  = (Logger)LogManager.getLogger();
	//logger对象
	public Page page;		//分页对象
	
	/////////////////////////////////////////////////////////////////////

	@Override
	public void setSession(Map<String, Object> session) {

		this.session = session;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
		
	}
}
