package com.owner.springcloud.provider.demo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.owner.springcloud.provider.commom.enums.GenderEnum;
import com.owner.springcloud.provider.demo.domain.User;
import com.owner.springcloud.provider.demo.dto.UserDto;
import com.owner.springcloud.provider.demo.service.IUserService;

/**
 * description:用户服务
 * Author	Date	Changes
 * zhuangjianfa  2018年3月26日 Created
 */
@Service
public class UserService implements IUserService{

    /* (non-Javadoc)
     * @see com.owner.springcloud.provider.demo.service.IUserService#getUserById(java.lang.Integer)
     */
    @Override
    public User getUserById(Integer id) {
        User user = new User();
        user.setAge(18);
        user.setCreated(new Date());
        user.setGender(GenderEnum.FEMALE);
        user.setName("小白");
        user.setPassword("123456");
        return user;
    }

    /* (non-Javadoc)
     * @see com.owner.springcloud.provider.demo.service.IUserService#getAll()
     */
    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setAge(18);
        user.setCreated(new Date());
        user.setGender(GenderEnum.FEMALE);
        user.setName("小白");
        user.setPassword("123456");
        list.add(user);
        User user2 = new User();
        user2.setAge(28);
        user2.setCreated(new Date());
        user2.setGender(GenderEnum.MALE);
        user2.setName("小明");
        user2.setPassword("888888");
        list.add(user2);
        return list;
    }

    /* (non-Javadoc)
     * @see com.owner.springcloud.provider.demo.service.IUserService#updateUser(com.owner.springcloud.provider.demo.domain.User)
     */
    @Override
    public void updateUser(UserDto user) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see com.owner.springcloud.provider.demo.service.IUserService#saveUser(com.owner.springcloud.provider.demo.domain.User)
     */
    @Override
    public void saveUser(UserDto user) {
        // TODO Auto-generated method stub
        
    }
    
}
