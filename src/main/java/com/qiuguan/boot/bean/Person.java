package com.qiuguan.boot.bean;

/**
 * @author qiuguan
 * @date 2022/09/08 18:54:15  星期四
 */
public class Person {

    private Integer id;

    private String name;

    private String gender;

    private String idCard;

    private String phone;

    public Person() {
    }

    public Person(Integer id, String name, String gender, String idCard, String phone) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
    }

    public static Person getDefaultBean(){
        return new Person(1, "秋官", "男", "150422199112095117", "18368116334");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
