package serviceIMPL;

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
	
	
	
	@Override
	public Map<String, Object> login(HouseUser user) {
		
		return null;
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
