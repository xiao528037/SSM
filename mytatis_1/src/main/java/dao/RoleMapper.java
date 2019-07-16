package dao;

import pojo.Role;

import java.util.List;

public interface RoleMapper {
    //获取单个角色信息
    public Role getRole(Long id);

    //添加角色信息
    public int insertRole(Role role);

    //删除角色信息
    public int deleteRole(Long id);

    //修改角色信息
    public int updateRole(Role role);

    //获取全部角色信息
    public List<Role> getAll();

    //模糊查询
    public List<Role> findRole(String str);

}

