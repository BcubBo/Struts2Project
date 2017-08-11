package service;
import java.util.Map;

import entity.HouseUser;

public interface IUserService {

	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public Map<String,Object> login(HouseUser user);
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	public boolean doRegister(HouseUser user);
	
	/**
	 * 验证
	 * @param name
	 * @return
	 */
	public boolean validate(String name);
	
	/**
	 * 根据Id获取user对象
	 * @param id
	 * @return
	 */
	public HouseUser getUserById(Integer id);
}
