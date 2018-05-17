package com.owner.springcloud.provider.req;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.owner.springcloud.provider.commom.enums.GenderEnum;

/**
 * description:保存用户请求参数
 * Author	Date	Changes
 * zhuangjianfa  2018年3月26日 Created
 */
public class SaveUserReq implements Serializable{

    /**
     * description:TODO
     * remark:
     */
    private static final long serialVersionUID = 1L;
    
    
    /**
     * description:姓名
     * remark:
     */
    private String name;
    
    /**
     * description:年龄
     * remark:
     */
    private Integer age;
    
    /**
     * description:注册时间
     * remark:
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date created;
    
    /**
     * description:密码
     * remark:
     */
    private String password;

    /**
     * description:性别
     * remark:
     */
    private GenderEnum gender;
    
    /**
     * Returns this name object.
     * @return this name
     */
    public String getName() {
        return name;
    }

    
    /**
     * Sets this name.
     * @param name this name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /**
     * Returns this age object.
     * @return this age
     */
    public Integer getAge() {
        return age;
    }

    
    /**
     * Sets this age.
     * @param age this age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    
    /**
     * Returns this created object.
     * @return this created
     */
    public Date getCreated() {
        return created;
    }

    
    /**
     * Sets this created.
     * @param created this created to set
     */
    public void setCreated(Date created) {
        this.created = created;
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


    
    /**
     * Returns this gender object.
     * @return this gender
     */
    public GenderEnum getGender() {
        return gender;
    }


    
    /**
     * Sets this gender.
     * @param gender this gender to set
     */
    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

}
