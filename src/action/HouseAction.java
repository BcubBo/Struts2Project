package action;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import action.BaseAction;
import util.Page;
import entity.District;
import entity.House;
import entity.HouseType;
import entity.Street;
import service.IHouseService;
import serviceIMPL.IHouseServiceImpl;
import util.Constant;
import util.UpLoadFile;


public class HouseAction extends BaseAction{

	private static final long serialVersionUID = -1859199269850007425L;
	private House house;
	private List<HouseType> typeList;
	private int districtId;
	private List<District> disList;

	private int streetId;
	private Map<Integer,List<Street>> streetMap = new HashMap<Integer,List<Street>>(0);
	
	
	
	private File img;
	private String imgContentType;
	private String imgFileName;
	private UpLoadFile uploadFile;
	private Page page;
	
	private IHouseService houseService = new IHouseServiceImpl();//房屋服务
	
	
	//默认的格式书写
	/**
	 * 进行房屋信息的创建
	 * @author BcubBo
	 *
	 */
	public String execute() {
		
		this.init();
		
		return SUCCESS;
	}
	//进入
	/**
	 * 初始化的操作，提供信息展示所需要的各种数据库中的列表
	 * @author BcubBo
	 * @return void 
	 * 
	 */
	private void init() {
		
		typeList = houseService.findTypeList();
		//获取所有类型列表
		disList = houseService.findDistrictList();
		//获取所有区列表
		for(District dis: disList) {
			streetMap.put(dis.getId(),houseService.findStreetListByDisId(dis.getId()));
			//将获得的街道列表和区域代码配对，并放入映射中
			
			
		
		}
		
		
	}
	
	/**提交完成后的跳转
	 * @author BcubBo
	 * @return
	 */
	public String doAddHouse() {
		//完善房屋信息添加成功后的逻辑
		this.init();
		for(HouseType ht:typeList) {
			
			if(ht.getId()==house.getHouseType().getId()) {
				
				house.setHouseType(ht);
				logger.debug(ht.getName());
				break;
				
			}
			
			
		}//遍历HoustType并按逻辑添加房屋类型到新添加的信息中
		for(Street st:houseService.findStreetListByDisId(this.districtId)) {
			
			
			if(st.getId() == streetId) {
				
				
				logger.debug(st.getName());
				house.setStreet(st);
				break;
			}
			
			
		}
		//遍历Street并按逻辑添加街道信息到新添加的房屋信息中
		
		for(District dis:disList) {
			
			if(dis.getId()== districtId) {
				
				logger.debug(dis.getName());
				house.getStreet().setDistrict(dis);
				break;
				
				
			}
			
			
			
		}//遍历District并按逻辑添加区域信息到新添加的信息中
		uploadFile = new UpLoadFile();
		house.getHouseType().getId();
		//上传文件的属性
		logger.debug("IHouseServiceImpl里的上传文件路径:"+uploadFile+"\t"+img.getAbsolutePath());
		uploadFile.setImgfile(img.getAbsoluteFile());
		//设置图片文件
		uploadFile.setFileName(imgFileName);
		uploadFile.setContentType(imgContentType);
		//
		uploadFile.setPath(Constant.UPLOAD_PATH);
		
		houseService.save(house,uploadFile);
		logger.debug("IHouseServiceImpl里的文件:"+img.getAbsolutePath());
		
		return SUCCESS;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public UpLoadFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(UpLoadFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public House getHouse() {
		return house;
	}


	public void setHouse(House house) {
		this.house = house;
	}





	public List<HouseType> getTypeList() {
		return typeList;
	}


	public void setTypeList(List<HouseType> typeList) {
		this.typeList = typeList;
	}


	public int getDistrictId() {
		return districtId;
	}
	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}



	public List<District> getDisList() {
		return disList;
	}


	public void setDisList(List<District> disList) {
		this.disList = disList;
	}


	public int getStreetId() {
		return streetId;
	}


	public void setStreetId(int streetId) {
		this.streetId = streetId;
	}


	public Map<Integer, List<Street>> getStreetMap() {
		return streetMap;
	}


	public void setStreetMap(Map<Integer, List<Street>> streetMap) {
		this.streetMap = streetMap;
	}


	public File getImg() {
		return img;
	}


	public void setImg(File img) {
		this.img = img;
	}


	public String getImgContentType() {
		return imgContentType;
	}


	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}


	public String getImgFileName() {
		return imgFileName;
	}


	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}
	
	
	
	
	
	
	
	
	
	
}
