package tool;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName SqlSessionFactoryUtils
 * @Description 类的描述
 * @Author 萌白
 * @Date 2019/7/16 9:35
 * @Version 1.0
 */
public class SqlSessionFactoryUtils {
    private static volatile InputStream inputStream = null;
    private static volatile String resources = "mybatis-config.xml";
    private static volatile SqlSessionFactory sqlSessionFactory = null;

    //单例模式，sqlsessionfactory类似于一个连接池，如果频繁创建，非常消耗资源。
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        if (sqlSessionFactory == null) {
            synchronized (SqlSessionFactory.class) {
                if (sqlSessionFactory != null) {
                    return sqlSessionFactory;
                }
                if (sqlSessionFactory == null) {
                    inputStream = Resources.getResourceAsStream(resources);
                    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                }
            }
        }
        return sqlSessionFactory;
    }

    public static SqlSession openSqlSession() {
        if (sqlSessionFactory == null) {
            try {
                return getSqlSessionFactory().openSession();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sqlSessionFactory.openSession();
    }
}

