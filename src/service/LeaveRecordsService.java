package service;

import java.util.List;

import pojo.LeaveRecords;
import pojo.Page;

public interface LeaveRecordsService {
		//分页
		public List<LeaveRecords> LimitLeave(int pageIndex,int pageSize);
		//总记录
		public int getSum();
		//添加
		public int AddLeave(LeaveRecords leave);
		//删除
		public int DelLeave(Integer id);
		//分页
		public Page Find(int index);
}
