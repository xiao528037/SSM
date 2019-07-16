import dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.SexEnum;
import pojo.User;
import tool.SqlSessionFactoryUtils;

/**
 * @ClassName UserTest
 * @Description 类的描述
 * @Author 萌白
 * @Date 2019/7/16 15:48
 * @Version 1.0
 */
public class UserTest {
    SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    @Test
    public void getUser(){
        User user = mapper.getUser(2L);

        System.out.println(user.getSex().getName());
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setUserName("username");
        user.setPassWord("password");
        user.setSex(SexEnum.FEMALE);
        user.setMobile("mobile");
        user.setTel("tel");
        user.setEmail("email");
        user.setNote("note");
        mapper.insertUser(user);
        sqlSession.commit();
    }

    @Test
    public void testEnum() {
        System.out.println(SexEnum.FEMALE.getId());
    }
}
