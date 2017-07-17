package com.ywgroup.iecloud.bagshare.pojo;

import java.math.BigDecimal;

public class Payment {
    private Integer id;

    private Integer uid;

    private Integer bid;

    private BigDecimal price;

    private Integer times;

    private String adress;

    private String phone;

    private Integer type;

    public Payment(Integer id, Integer uid, Integer bid, BigDecimal price, Integer times, String adress, String phone, Integer type) {
        this.id = id;
        this.uid = uid;
        this.bid = bid;
        this.price = price;
        this.times = times;
        this.adress = adress;
        this.phone = phone;
        this.type = type;
    }

    public Payment() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}