package action;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import action.BaseAction;
import entity.District;
import entity.House;
import entity.HouseType;
import entity.Street;
import service.IHouseService;
import serviceIMPL.IHouseServiceImpl;


public class HouseAction extends BaseAction{

	private static final long serialVersionUID = -1859199269850007425L;
	private House house;
	private List<HouseType> typelist;
	private int distritctId;
	private List<District> disList;

	private int streetId;
	private Map<Integer,List<Street>> streetMap = new HashMap<Integer,List<Street>>(0);
	
	
	
	private File img;
	private String imgContentType;
	private String imgFileName;
	
	
	
	private IHouseService houseService = new IHouseServiceImpl();//房屋服务
	
	
	//默认的格式书写
	/**
	 * 进行房屋信息的创建
	 * @author BcubBo
	 *
	 */
	public String execute() {
		
		
		return SUCCESS;
	}
	//进入
	
	
	/**提交完成后的跳转
	 * @author BcubBo
	 * @return
	 */
	public String doAddHouse() {
		return SUCCESS;
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


	public List<HouseType> getTypelist() {
		return typelist;
	}


	public void setTypelist(List<HouseType> typelist) {
		this.typelist = typelist;
	}


	public int getDistritctId() {
		return distritctId;
	}


	public void setDistritctId(int distritctId) {
		this.distritctId = distritctId;
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
