package action;

import java.util.Map;

import entity.HouseUser;
import service.IUserService;
import serviceIMPL.IUserServiceImpl;
import util.Constant;

public class UserAction extends BaseAction {

	private static final long serialVersionUID = 1311557143195473990L;
	
	
	private IUserService userService = new IUserServiceImpl();
	private HouseUser user;
	private boolean checkResult;//检查结果setter和getter然后直接返回了这个对象所以可以从中取得对象，且对象是以json格式返回
	private String checkMsg;//检查失败后怎样
	private String testString ;
	private String msg;

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
		testString = "testSting测试JSON格式返回的条件";
		return SUCCESS;
		
	}
	//////////
	
	/**
	 * 用户登陆
	 * @author BcubBo
	 * @return String ---SUCCESS/INPUT/ERROR
	 * 
	 * 
	 * */
	public String login() {
		logger.debug("进入登陆验证模块");
		Map<String,Object> resultMap = userService.login(user);//
		//接收结果映射
		if(resultMap!=null) {
			logger.debug("结果映射不为空进入获取登陆结果区域");
			if(resultMap.get("loginResult")!=null) {
				
				logger.debug("loginResult存在");
				if((boolean)resultMap.get("loginResult")){
					user = (HouseUser)resultMap.get("user");
					logger.debug("从结果映射中取出的user对象为:"+user.getUsername());
					this.session.put(Constant.LOGIN_USER, user);
					//父类的session拿到子类
					msg="可以登录了，获取到了用户";
					logger.debug("已经获取用户信息");
				}else {
					user = null;
					//不存在赋空
					msg="用户名或者密码错误";
					logger.debug("user为空");
					testString="登陆验证失败";
					
				}
			}
		}else {
			
			
		
		}
		return SUCCESS;
}
	////login登陆功能
	
	
	/**
	 * @return
	 */
	public String logout() {
		if(session.get(Constant.LOGIN_USER)!=null) {
			
			logger.debug("清除Constant.LOGIN_USER之前的值为:"+((HouseUser)session.get(Constant.LOGIN_USER)).getUsername());
			this.session.remove(Constant.LOGIN_USER);
			logger.debug("清除Constant.LOGIN_USER之后的值为:"+session.get(Constant.LOGIN_USER));
			//清除session
		}else {
			msg="请重新登陆";
			return INPUT;
			
		}
		//判断是否为空
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * @return
	 */
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTestString() {
		return testString;
	}

	public void setTestString(String testString) {
		this.testString = testString;
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
