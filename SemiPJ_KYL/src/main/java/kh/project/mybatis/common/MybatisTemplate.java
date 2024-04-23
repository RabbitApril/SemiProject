package kh.project.mybatis.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTemplate {
	public static SqlSession getSqlSesisSession() {
		String resource = "mybatis-config.xml";
		SqlSession sqlSession = null;
		try {
			// InputStream으로 Mybatis 설정 정보 읽어오기 
			// 읽어온 설정정보를 바탕으로 SqlSessionFactoryBuilder를 생성한다.
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSession;
	}
}
