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

public class IHouseServiceImpl implements IHouseService {

	
	private IBaseDao<House> houseDao = new HouseDaoImpl();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public boolean save(House house, UpLoadFile file) {
		
		return false;
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

	@Override
	public List<HouseType> findTypeList() {
		
		return null;
	}

	@Override
	public List<District> findDistrictList() {
		
		return null;
	}

	@Override
	public List<Street> findStreetListByDisId(int disId) {
		
		return null;
	}

}
