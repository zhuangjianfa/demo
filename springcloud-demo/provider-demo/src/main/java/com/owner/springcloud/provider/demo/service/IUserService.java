package com.owner.springcloud.provider.demo.service;

import java.util.List;

import com.owner.springcloud.provider.demo.domain.User;
import com.owner.springcloud.provider.demo.dto.UserDto;

/**
 * description:用户接口
 * Author	Date	Changes
 * zhuangjianfa  2018年3月26日 Created
 */
public interface IUserService {
    
    /**
     * 
     * description: 根据用户查询用户 
     * @param id
     * @return
     * createdBy:zhuangjianfa           
     * created:2018年3月26日
     */
    User getUserById(Integer id);
    
    /**
     * 
     * description: 获取所有用户 
     * @return
     * createdBy:zhuangjianfa           
     * created:2018年3月26日
     */
    List<User> getAll();
    
    /**
     * 
     * description: 更新用户 
     * @param user
     * createdBy:zhuangjianfa           
     * created:2018年3月26日
     */
    void updateUser(UserDto user);
    
    /**
     * 
     * description:新增用户 
     * @param user
     * createdBy:zhuangjianfa           
     * created:2018年3月26日
     */
    void saveUser(UserDto user);
}
