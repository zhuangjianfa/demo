/**
 * Copyright © 2014 GZJF Corp. All rights reserved. This software is proprietary
 * to and embodies the confidential technology of 深圳市大头兄弟文化传播有限公司 Corp.
 * Possession, use, or copying of this software and media is authorized only
 * pursuant to a valid written license from 深圳市大头兄弟文化传播有限公司 Corp or an
 * authorized sublicensor.
 */
package com.owner.springcloud.provider.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.owner.common.Result;
import com.owner.common.exception.ParamsValidateException;
import com.owner.springcloud.provider.client.IUserClient;
import com.owner.springcloud.provider.commom.ResultCode;
import com.owner.springcloud.provider.demo.domain.User;
import com.owner.springcloud.provider.demo.dto.UserDto;
import com.owner.springcloud.provider.demo.service.impl.UserService;
import com.owner.springcloud.provider.req.SaveUserReq;
import com.owner.springcloud.provider.req.UpdateUserReq;
import com.owner.springcloud.provider.resp.UserListResp;
import com.owner.springcloud.provider.resp.UserResp;

/**
 * description:用户服务提供
 * Author	Date	Changes
 * zhuangjianfa  2018年3月26日 Created
 */
@RestController
public class ProviderController implements IUserClient {

    @Autowired
    private UserService userService;

    /*
     * (non-Javadoc)
     * @see com.owner.springcloud.provider.client.UserClient#updateUser(com.owner.
     * springcloud.provider.req.UserReq)
     */
    @Override
    public Result<?> updateUser(@RequestBody UpdateUserReq userReq) {
        Result<?> result = new Result<>();
        UserDto userDto = new UserDto();
        try {
            BeanUtils.copyProperties(userReq, userDto);
            userService.updateUser(userDto);
        } catch (ParamsValidateException e) {
            result.setMessage(e.getMessage());
            result.setCode(e.getCode());
        } catch (Exception e) {
            result.setMessage(ResultCode.SERVICE_EXCEPTION.getMessage());
            result.setCode(ResultCode.SERVICE_EXCEPTION.getCode());
        }
        return result;
    }

   
    /*
     * (non-Javadoc)
     * @see com.owner.springcloud.provider.client.UserClient#getUserList()
     */
    @Override
    public Result<UserListResp> getUserList() {
        Result<UserListResp> result = new Result<>();
        UserListResp userListResp = new UserListResp();
        List<UserResp> userList = new ArrayList<>();
        List<User> list = userService.getAll();
        list.forEach(user ->{
            UserResp userResp = new UserResp();
            BeanUtils.copyProperties(user, userResp);
            userList.add(userResp);
        });
        userListResp.setUserList(userList);
        result.setData(userListResp);
        return result;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.owner.springcloud.provider.client.UserClient#getUserById(java.lang.
     * Integer)
     */
    @Override
    public Result<UserResp> getUserById(@PathVariable("id")  Integer id) {
        Result<UserResp> result = new Result<>();
        UserResp userResp = new UserResp();
        try{
            User user = userService.getUserById(id);
            //查询到有用户才做转换
            if(null!=user){
                BeanUtils.copyProperties(user, userResp);
                result.setData(userResp);
            }
        }catch(Exception e){
            result.setMessage(ResultCode.SERVICE_EXCEPTION.getMessage());
            result.setCode(ResultCode.SERVICE_EXCEPTION.getCode());
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.owner.springcloud.provider.client.UserClient#save(com.owner.springcloud.provider.req.UpdateUseReq)
     */
    @Override
    public Result<?> save(@RequestBody SaveUserReq userReq) {
        Result<?> result = new Result<>();
        UserDto userDto = new UserDto();
        try {
            BeanUtils.copyProperties(userReq, userDto);
            userService.saveUser(userDto);
        } catch (ParamsValidateException e) {
            result.setMessage(e.getMessage());
            result.setCode(e.getCode());
        } catch (Exception e) {
            result.setMessage(ResultCode.SERVICE_EXCEPTION.getMessage());
            result.setCode(ResultCode.SERVICE_EXCEPTION.getCode());
        }
        return result;
    }

}
