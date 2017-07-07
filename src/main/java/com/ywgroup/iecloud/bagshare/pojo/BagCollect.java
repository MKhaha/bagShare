package com.ywgroup.iecloud.bagshare.pojo;

import java.util.Date;

public class BagCollect {
    private Integer id;

    private String name;

    private String price;

    private String title;

    private String address;

    private Date createTime;

    private Date updateTime;

    public BagCollect(Integer id, String name, String price, String title, String address, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.title = title;
        this.address = address;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public BagCollect() {
        super();
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
        this.name = name == null ? null : name.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}