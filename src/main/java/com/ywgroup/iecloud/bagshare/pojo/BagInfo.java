package com.ywgroup.iecloud.bagshare.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class BagInfo {
    private Integer id;

    private String name;

    private String brand;

    private BigDecimal price;

    private String majorPictureAddress;

    private String minorPictureAddress;

    private String bagInformation;

    private Date createTime;

    private Date updateTime;

    public BagInfo(Integer id, String name, String brand, BigDecimal price, String majorPictureAddress, String minorPictureAddress, String bagInformation, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.majorPictureAddress = majorPictureAddress;
        this.minorPictureAddress = minorPictureAddress;
        this.bagInformation = bagInformation;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public BagInfo() {
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getMajorPictureAddress() {
        return majorPictureAddress;
    }

    public void setMajorPictureAddress(String majorPictureAddress) {
        this.majorPictureAddress = majorPictureAddress == null ? null : majorPictureAddress.trim();
    }

    public String getMinorPictureAddress() {
        return minorPictureAddress;
    }

    public void setMinorPictureAddress(String minorPictureAddress) {
        this.minorPictureAddress = minorPictureAddress == null ? null : minorPictureAddress.trim();
    }

    public String getBagInformation() {
        return bagInformation;
    }

    public void setBagInformation(String bagInformation) {
        this.bagInformation = bagInformation == null ? null : bagInformation.trim();
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