/**
 * @Copyright (C) 2018 苏何丽自创有限公司
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 * @文件名称: Role.java
 * @描述:
 * @创建人:苏何丽
 * @创建时间: 2019/1/8 20:00
 * @版本:
 */

package com.shl.entity;

import java.util.List;

/**
 *
 * @类功能说明:
 * @创建人: 苏何丽
 * @创建时间: 2019/1/8 20:00
 */
public class Role {

    private Integer id;
    private String roleName;
    private String roleDesc;
    // 角色与用户，一对多
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", users=" + users +
                '}';
    }
}