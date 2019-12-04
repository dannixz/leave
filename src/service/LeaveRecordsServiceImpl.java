package service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.LeaveRecordsMapper;
import pojo.LeaveRecords;
import pojo.Page;
import unit.MyBatisUtil;

public class LeaveRecordsServiceImpl implements LeaveRecordsService{
	SqlSession session = null;
	@Override
	public List<LeaveRecords> LimitLeave(int pageIndex, int pageSize) {
		List<LeaveRecords> list = new ArrayList<LeaveRecords>();
		try {
			session = MyBatisUtil.createSqlSession();
			list = session.getMapper(LeaveRecordsMapper.class).LimitLeave(pageIndex, pageSize);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSqlSession(session);
		}	
		return list;
	}

	@Override
	public int getSum() {
		int count = 0;
		try {
			session = MyBatisUtil.createSqlSession();
			count = session.getMapper(LeaveRecordsMapper.class).getSum();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSqlSession(session);
		}
		return count;
	}

	@Override
	public int AddLeave(LeaveRecords leave) {
		int count = 0;
		try {
			session = MyBatisUtil.createSqlSession();
			count = session.getMapper(LeaveRecordsMapper.class).AddLeave(leave);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			MyBatisUtil.closeSqlSession(session);
		}
		return count;
	}

	@Override
	public int DelLeave(Integer id) {
		int count = 0;
		try {
			session = MyBatisUtil.createSqlSession();
			count = session.getMapper(LeaveRecordsMapper.class).DelLeave(id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			MyBatisUtil.closeSqlSession(session);
		}
		return count;
	}

	@Override
	public Page Find(int index) {
		int zongjilu = getSum();
		Page page =new Page(index,zongjilu);
		List<LeaveRecords> list =LimitLeave(page.getPageIndex(), page.getYedaxiao());
		page.setList(list);
		return page;
	}
	
}
