package serviceIMPL;

import java.util.List;
import java.util.Map;

import dao.IBaseDao;
import daoIMPL.HouseDaoImpl;
import entity.District;
import entity.House;
import entity.HousePicture;
import entity.HouseType;
import entity.Street;
import service.IHouseService;
import util.UpLoadFile;

/**
 * @author fatal
 *
 */
public class IHouseServiceImpl implements IHouseService {

	
	private IBaseDao<House> houseDao = new HouseDaoImpl();//数据访问层
	
	
	//service业务逻辑层
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public boolean save(House house, UpLoadFile file) {
		//保存对象到数据库中
		try {
			houseDao.save(house);//
			return true;
			//处理上传文件的逻辑
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
		
	}

	@Override
	public void delete(House house) {
		

	}

	@Override
	public boolean update(House house, UpLoadFile file) {
		
		return false;
	}

	@Override
	public House findById(Integer id) {
		
		return null;
	}

	@Override
	public HousePicture getPictureById(Integer id) {
		
		return null;
	}

	@Override
	public Object[] findAll(Map<String, Object> params) {
		
		return null;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	/**
	 *@author BcubBo
	 * 
	 */
	public List<HouseType> findTypeList() {
		return  this.houseDao.findByHql("from HouseType ");
		//获取类型列表
		

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<District> findDistrictList() {
		
		return this.houseDao.findByHql("form District");
		//获取地区列表
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Street> findStreetListByDisId(int disId) {
		
		return this.houseDao.findByHql("from Street s where s.district.id="+disId);
		//通过区域id获取街道列表
	}

}
