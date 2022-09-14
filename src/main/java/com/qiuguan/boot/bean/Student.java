package com.qiuguan.boot.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author qiuguan
 * @date 2022/09/14 23:31:21  星期三
 */
@Setter
@Getter
@ToString(callSuper = true)
public class Student extends BaseBean {

    private Integer studentNo;

    private String name;

    private String address;

    private int gender;

}
