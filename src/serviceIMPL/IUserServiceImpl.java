package serviceIMPL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import dao.IBaseDao;
import daoIMPL.UserDaoImpl;
import entity.HouseUser;
import service.IUserService;


public class IUserServiceImpl implements IUserService{

	//属性部分
	private IBaseDao userDao = new UserDaoImpl();
	
	Logger logger = (Logger)LogManager.getLogger();
	
	/**
	 * 返回结果map成功的结果
	 * @author BcubBo
	 *@return Map<String,Object>
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> login(HouseUser user) {
		logger.debug("开始执行登陆Service");
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		boolean loginResult = false;
		List<HouseUser> userResultList =null;
		if(user!=null) {
			userResultList = userDao.findByHql("from HouseUser h where h.username='"+
							user.getUsername()+
							"' and h.password='"+user.getPassword()+"'");
			logger.debug("用户返回列表的长度为:"+userResultList.size());
			//
			if(userResultList.size()!=0) {
				loginResult = true;
				resultMap.put("loginResult",loginResult);//添加登陆结果
				resultMap.put("user", userResultList.get(0));//添加登陆用户信息
				logger.debug("已添加完毕信息到返回集合中");
				//
			}else {
				logger.debug("user对象不为空的前提下，返回结果为0的部分");
				resultMap.put("loginResult", loginResult);
			}
		}else {
			logger.debug("进入将loginResult放入map的操作");
			resultMap.put("loginResult", loginResult);
		}
		
		return resultMap;
	}

	@Override
	public boolean doRegister(HouseUser user) {
		try {
			userDao.save(user);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	/**
	 * 校验器
	 * @return boolean查询的结果
	 * @author BcubBo
	 * 
	 * */
	@Override
	public boolean validate(String name) {
		logger.debug(name);
		if(userDao.findByHql("from HouseUser u where u.username ='"+name+"'").size()>0) {
			return true;
		}else {
			
			//始终要使用括号的形式
			return false;
			
			
		}
	}

	@Override
	public HouseUser getUserById(Integer id) {
		
		return null;
	}

}
