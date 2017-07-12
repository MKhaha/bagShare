package com.ywgroup.iecloud.bagshare.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class BagInfo {
    private Integer id;

    private String name;

    private Integer bid;

    private String brand;

    private BigDecimal pricezu;

    private BigDecimal priceya;

    private BigDecimal price;

    private String majorPictureAddress;

    private String minorPictureAddress;

    private String bagInformation;

    private String produce;

    private String color;

    private String material;

    private String category;

    private String size;

    private String content;

    private String status;

    private Date createTime;

    private Date updateTime;

    public BagInfo(Integer id, String name, Integer bid, String brand, BigDecimal pricezu, BigDecimal priceya, BigDecimal price, String majorPictureAddress, String minorPictureAddress, String bagInformation, String produce, String color, String material, String category, String size, String content, String status, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.bid = bid;
        this.brand = brand;
        this.pricezu = pricezu;
        this.priceya = priceya;
        this.price = price;
        this.majorPictureAddress = majorPictureAddress;
        this.minorPictureAddress = minorPictureAddress;
        this.bagInformation = bagInformation;
        this.produce = produce;
        this.color = color;
        this.material = material;
        this.category = category;
        this.size = size;
        this.content = content;
        this.status = status;
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

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public BigDecimal getPricezu() {
        return pricezu;
    }

    public void setPricezu(BigDecimal pricezu) {
        this.pricezu = pricezu;
    }

    public BigDecimal getPriceya() {
        return priceya;
    }

    public void setPriceya(BigDecimal priceya) {
        this.priceya = priceya;
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

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce == null ? null : produce.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material == null ? null : material.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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