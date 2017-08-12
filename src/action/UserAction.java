package action;

import entity.HouseUser;
import service.IUserService;
import serviceIMPL.IUserServiceImpl;

public class UserAction extends BaseAction {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1311557143195473990L;
	
	
	private IUserService userService = new IUserServiceImpl();
	private HouseUser user;
	private boolean checkResult;//检查结果
	private String checkMsg;//检查失败后怎样
	
	
	public String execute() {
		logger.debug(user);
		if(userService.doRegister(user)) {
			logger.debug("注册成功");
			return SUCCESS;			
			
			
			
		}else{
			
			logger.debug("注册失败");			
			return INPUT;
			
		}
		
		
		
		//return SUCCESS;
	}
	
	///////////
	/**
	 * 用户注册
	 * @reurn
	 * @author BcubBo
	 * 
	 */
	public String register() {
		
		if(userService.doRegister(user)) {
			logger.debug("注册成功");
			return SUCCESS;			
			
			
			
		}else{
			
			logger.debug("注册失败");			
			return INPUT;
			
		}
		//调用注册方法
		//

		
		
	}
	//////
	/**
	 * 验证用户名
	 * @author BcubBo
	 * @return String--checkResult --checkMsg
	 * 
	 * 
	 * */
	public String check() {
		
		checkResult = userService.validate(user.getUsername());
		if(!checkResult) {
			
			
			this.checkMsg = "用户不存在";
			
			
			
		}
		
		return SUCCESS;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	public boolean isCheckResult() {
		return checkResult;
	}

	public void setCheckResult(boolean checkResult) {
		this.checkResult = checkResult;
	}

	public String getCheckMsg() {
		return checkMsg;
	}

	public void setCheckMsg(String checkMsg) {
		this.checkMsg = checkMsg;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public HouseUser getUser() {
		return user;
	}

	public void setUser(HouseUser user) {
		this.user = user;
	}
	
	
	
}
