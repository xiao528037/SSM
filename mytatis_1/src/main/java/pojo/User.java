package pojo;

import lombok.Data;

/**
 * @ClassName User
 * @Description 类的描述
 * @Author 萌白
 * @Date 2019/7/16 15:10
 * @Version 1.0
 */
@Data
public class User {
    private Long id;
    private String userName;
    private String passWord;
    private SexEnum sex;
    private String mobile;
    private String tel;
    private String email;
    private String note;
}
