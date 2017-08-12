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
	
	public String execute() {
		
		
		
		
		return SUCCESS;
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
