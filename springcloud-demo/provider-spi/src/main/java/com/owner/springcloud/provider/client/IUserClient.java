package com.owner.springcloud.provider.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.owner.common.Result;
import com.owner.springcloud.provider.req.SaveUserReq;
import com.owner.springcloud.provider.req.UpdateUserReq;
import com.owner.springcloud.provider.resp.UserListResp;
import com.owner.springcloud.provider.resp.UserResp;

/**
 * description:用户接口声明
 * Author	Date	Changes
 * zhuangjianfa  2018年3月26日 Created
 */
@FeignClient(name ="provider-demo")
public interface IUserClient {
    
    @RequestMapping(value = "/api/v1/user/update",method = RequestMethod.POST)
    Result<?> updateUser(UpdateUserReq userReq);
    
    @RequestMapping(value = "/api/v1/user",method = RequestMethod.POST)
    Result<UserListResp> getUserList();
    
    @RequestMapping(value = "/api/v1/user/{id}",method = RequestMethod.POST)
    Result<UserResp> getUserById(Integer id);
    
    @RequestMapping(value = "/api/v1/user/save",method = RequestMethod.POST)
    Result<?> save(SaveUserReq userReq);
}
