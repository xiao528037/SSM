package dao;

import pojo.User;

/**
 * @ClassName UserMapper
 * @Description 类的描述
 * @Author 萌白
 * @Date 2019/7/16 15:17
 * @Version 1.0
 */
public interface UserMapper {
    public void insertUser(User user);

    public User getUser(Long id);
}
