package unit;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MyBatisUtil {
	private static SqlSessionFactory factory;
	static {
		try {
			String config = "mybatis-config.xml";
			InputStream is = Resources.getResourceAsStream(config);
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//开启
	public static SqlSession createSqlSession() {
		return factory.openSession(false);
		
	}
	
	//关闭
	public static void closeSqlSession(SqlSession session) {
		if (session!= null) {
			session.close();
		}
	}
}
