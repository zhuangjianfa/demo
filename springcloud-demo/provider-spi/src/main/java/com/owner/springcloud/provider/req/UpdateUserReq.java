package com.owner.springcloud.provider.req;

import java.io.Serializable;


/**
 * description:用户请求参数
 * Author	Date	Changes
 * zhuangjianfa  2018年3月26日 Created
 */
public class UpdateUserReq implements Serializable{
    
    /**
     * description:序列化
     * remark:
     */
    private static final long serialVersionUID = 1L;

    /**
     * description:用户名
     * remark:
     */
    private Integer id;
    
    /**
     * description:密码
     * remark:
     */
    private String password;

    
    
    /**
     * Returns this id object.
     * @return this id
     */
    public Integer getId() {
        return id;
    }


    
    /**
     * Sets this id.
     * @param id this id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }


    /**
     * Returns this password object.
     * @return this password
     */
    public String getPassword() {
        return password;
    }

    
    /**
     * Sets this password.
     * @param password this password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
