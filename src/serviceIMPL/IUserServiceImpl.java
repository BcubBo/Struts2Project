package serviceIMPL;

import java.util.Map;

import dao.IBaseDao;
import daoIMPL.UserDaoImpl;
import entity.HouseUser;
import service.IUserService;

public class IUserServiceImpl implements IUserService{

	//属性部分
	private IBaseDao userDao = new UserDaoImpl();
	
	
	
	
	
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

	@Override
	public boolean validate(String name) {
		
		return false;
	}

	@Override
	public HouseUser getUserById(Integer id) {
		
		return null;
	}

}
