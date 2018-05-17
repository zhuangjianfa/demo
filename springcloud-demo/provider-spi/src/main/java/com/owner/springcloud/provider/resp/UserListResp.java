package com.owner.springcloud.provider.resp;

import java.io.Serializable;
import java.util.List;

/**
 * description:用户接口返回值
 * Author	Date	Changes
 * zhuangjianfa  2018年3月26日 Created
 */
public class UserListResp implements Serializable{
    /**
     * description:TODO
     * remark:
     */
    private static final long serialVersionUID = 1L;
    
    private List<UserResp> userList;

    
    /**
     * Returns this userList object.
     * @return this userList
     */
    public List<UserResp> getUserList() {
        return userList;
    }

    
    /**
     * Sets this userList.
     * @param userList this userList to set
     */
    public void setUserList(List<UserResp> userList) {
        this.userList = userList;
    }
    
    
}
