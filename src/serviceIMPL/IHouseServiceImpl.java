package serviceIMPL;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.struts2.ServletActionContext;

import dao.IBaseDao;
import util.Page;
import daoIMPL.HouseDaoImpl;
import entity.District;
import entity.House;
import entity.HousePicture;
import entity.HouseType;
import entity.Street;
import service.IHouseService;
import util.Constant;
import util.UpLoadFile;

/**
 * @author fatal
 *
 */
public class IHouseServiceImpl implements IHouseService {

	private Logger logger = (Logger)LogManager.getLogger();
	private IBaseDao<House> houseDao = new HouseDaoImpl();//数据访问层
	
	
	//service业务逻辑层
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public boolean save(House house, UpLoadFile file) {
		//保存对象到数据库中
		try {
			logger.debug("进入保存块");
			String root = ServletActionContext.getServletContext().getRealPath(Constant.UPLOAD_PATH);
			//获取项目的文件路径的绝对路径并把上传的文件放到此文件夹
			String newFileName = root+"\\"+String.valueOf(System.currentTimeMillis()+file.getFileName());
			//创建文件
			//获取文件路径并设置文件名到项目文件夹
			File destDir = new File(newFileName );
			//目标文件
			File parent = destDir.getParentFile();
			if(!parent.exists()) {
				
				parent.mkdir();
				logger.debug("目录不存在创建目录");
				
			}
			logger.debug("开始上传文件:"+destDir.getAbsolutePath());
			logger.debug("获取文件对象"+file.getImgfile());
/*			FileUtils.copyDirectory(file.getImgfile(),destDir);
			HousePicture picture  = new HousePicture();
			picture.setTitle(file.getTitle());
			picture.setUrl(Constant.UPLOAD_PATH+"/"+newFileName);
			//将上传的文件放置到项目的文件中
			house.setPicture(picture  );*/
			houseDao.save(house);//
			logger.debug("上传完成:");
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
		StringBuilder hql = new StringBuilder();
		hql.append("from House h where 1=1");
		House house = (House)params.get("house");
		String price = (String)params.get("price");
		String floorage = (String)params.get("floorage");
		int streetId = (Integer)params.get("streetId");
		
		Page page = (Page)params.get("page");
		if(house!=null && house.getTitle()!=null) {
			hql.append(" and h.title like '%"+house.getTitle()+"%'");
		}
			
		if(price!=null && price.trim().length()>0) {
			String[] temp = price.split(",");
			if(temp.length>1) {
				
				StringBuilder ss = new StringBuilder();
				for(String s:temp) {
					
					hql.append(" and h.price "+s.toString());
					
				}
				
				
			}else {
				
				
				hql.append(" and h.price "+price);
				//
			}
		}
			///
			
		
		List obj = new ArrayList();
		

		obj.add(page);
//		obj.add(totalCount);
		List result = this.houseDao.findByHql(hql.toString());
		page.setList(result);
		return obj.toArray();
	}

	
	@SuppressWarnings("unchecked")
	@Override

	public List<HouseType> findTypeList() {
		logger.debug("进入findTypeList()方法中");
		return  this.houseDao.findByHql("from HouseType");
		//获取类型列表
		

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<District> findDistrictList() {
		logger.debug("进入findDistrictList()方法中");
		return this.houseDao.findByHql("from District");
		//获取地区列表
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Street> findStreetListByDisId(int disId) {
		logger.debug("进入findByHql()方法中");		
		return this.houseDao.findByHql("from Street s where s.district.id="+disId);
		//通过区域id获取街道列表
	}

}
