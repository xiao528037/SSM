import dao.RoleMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.TypeAliasRegistry;
import org.apache.ibatis.type.TypeHandler;
import org.junit.Test;
import pojo.Role;
import tool.SqlSessionFactoryUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
    RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);


    @Test
    public void test5(){
        List<Role> three = mapper.findRole("三");
        System.out.println(three);
    }
    //获取全部role
    @Test
    public void test4() {

        List<Role> all = mapper.getAll();
        System.out.println(all);
    }


    //修改角色信息
    @Test
    public void test3() {
        Role role = new Role();
        role.setRoleName("猪猪");
        role.setNote("笨笨");
        role.setId(2L);
        mapper.updateRole(role);
        sqlSession.commit();
    }

    //删除角色
    @Test
    public void test2() {
        int i = mapper.deleteRole(1l);
        sqlSession.commit();
    }

    //添加角色
    @Test
    public void test1() {

        Role role = new Role();
        role.setRoleName("世界");
        role.setNote("精彩");
        int i = mapper.insertRole(role);
        sqlSession.commit();
    }

    //查询单个角色
    @Test
    public void test() throws IOException {
        SqlSessionFactory sqlSessionFactory = null;
        String resource = "mybatis-config.xml";
        InputStream inputStream;
        inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Role role = sqlSession.selectOne("dao.RoleMapper.getRole", 1L);
        System.out.println(role);
    }
}
