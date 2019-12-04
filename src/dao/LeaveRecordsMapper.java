package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.LeaveRecords;

public interface LeaveRecordsMapper {
	//分页
	public List<LeaveRecords> LimitLeave(@Param("from")Integer pageIndex,@Param("pageSize")Integer pageSize);
	//总记录
	public int getSum();
	//添加
	public int AddLeave(LeaveRecords leave);
	//删除
	public int DelLeave(Integer id);
}
