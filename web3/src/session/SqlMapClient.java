package session;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class SqlMapClient {
	
	public static SqlSession getSession() {
		try {
			String resource = "mybatisconfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			
			return sqlMapper.openSession();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
