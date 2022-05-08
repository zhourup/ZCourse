package com.zhourup.zcourse.constant;

/**
 * 系统枚举类
 *
 * @author zhourup
 * @date 2022/5/5 9:39
 */
public enum SystemStatusEnum {

    /**
     * 用户正常状态1
     */
    NORMAL(0, "正常"),

    /**
     * 用户已经被禁用0
     */
    DISABLED(1, "禁用");

    private Integer value;

    private String desc;

    SystemStatusEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
