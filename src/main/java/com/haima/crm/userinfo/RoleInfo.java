package com.haima.crm.userinfo;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by jige0727 on 2017/3/31.
 * ums返回的角色信息
 */
public class RoleInfo {
    private String name; //中文名称
    private String code; //代号

    public RoleInfo() {
    }

    public RoleInfo(JSONObject data) {
        name = "" + data.get("name");
        code = "" + data.get("code");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
