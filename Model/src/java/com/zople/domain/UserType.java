package com.zople.domain;

/**
 *
 * @author 王文彦
 */
public enum UserType {
    
    ENTERPRISE("企业"),PERSON("个人"),MARKET("市场");
    private final String name;
    
    UserType(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public static UserType valueOf(int value){
       return UserType.values()[value];
    }
}

