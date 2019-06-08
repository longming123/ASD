package com.imooc.enums;

public enum OderformStateEnum {
    SUCCESS(0),		// 发布成功
    FORBID(1);		// 禁止发布，管理员操作

    public final int value;

    OderformStateEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
