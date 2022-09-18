package com.qiuguan.boot.resolver;

/**
 * @author qiuguan
 * @date 2022/09/18 17:41:49  星期日
 */
public enum EventEnum {

    INIT(0),

    START(1),

    PROCESSING(2),

    FAIL(-1),

    SUCCESS(3);

    private final int code;

    EventEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static EventEnum getEventByCode(int code) {
        for (EventEnum value : EventEnum.values()) {
            if (value.code == code) {
                return value;
            }
        }

        return null;
    }
}
