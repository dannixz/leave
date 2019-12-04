package pojo;

import java.util.List;

import pojo.LeaveRecords;

public class Page {
	private int danqianye;
	private int yedaxiao = 5;
	private int pageIndex ;
	private int zongjilu;
	private int zongyeshu;
	private List<LeaveRecords> list;
	public int getDanqianye() {
		return danqianye;
	}
	public void setDanqianye(int danqianye) {
		this.danqianye = danqianye;
	}
	public int getYedaxiao() {
		return yedaxiao;
	}
	public void setYedaxiao(int yedaxiao) {
		this.yedaxiao = yedaxiao;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getZongjilu() {
		return zongjilu;
	}
	public void setZongjilu(int zongjilu) {
		this.zongjilu = zongjilu;
	}
	public int getZongyeshu() {
		return zongyeshu;
	}
	public void setZongyeshu(int zongyeshu) {
		this.zongyeshu = zongyeshu;
	}
	public List<LeaveRecords> getList() {
		return list;
	}
	public void setList(List<LeaveRecords> list) {
		this.list = list;
	}
	public Page(int danqianye, int zongjilu) {
		super();
		this.danqianye = danqianye;
		this.zongjilu = zongjilu;
		zongyeshu = zongjilu%yedaxiao==0 ? zongjilu/yedaxiao : zongjilu/yedaxiao+1;
		pageIndex = (danqianye-1)*yedaxiao;
	}
	
}
	
	
	
