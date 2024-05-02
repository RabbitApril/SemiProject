package kh.project.jdbc.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTemplate {
private static String resources = "mybatis-config.xml";
	
	public static SqlSession getSqlSession() {  
		SqlSession session = null; 
		try {
			InputStream inputStream = Resources.getResourceAsStream(resources);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession(true);    // 매개인자 없으면 true 기본
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}
	/* 매개인자 boolean autocommit 에 따라 연결 */
	public static SqlSession getSqlSession(boolean autoCommit) {
		SqlSession session = null;  
		try {
			InputStream inputStream = Resources.getResourceAsStream(resources);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession(autoCommit);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}
}
