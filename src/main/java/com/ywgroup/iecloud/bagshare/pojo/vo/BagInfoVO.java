package com.ywgroup.iecloud.bagshare.pojo.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017-7-10.
 */
public class BagInfoVO {
    private Integer id;

    private String name;

    private String brand;

    private BigDecimal pricezu;

    private BigDecimal priceya;

    private BigDecimal price;

    private String majorPictureAddress;

    private String[] minorPictureAddress;

    private String bagInformation;

    private String produce;

    private String color;

    private String material;

    private String size;

    private String content;

    private Integer status;

    private Integer bid;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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
        this.majorPictureAddress = majorPictureAddress;
    }

    public String[] getMinorPictureAddress() {
        return minorPictureAddress;
    }

    public void setMinorPictureAddress(String[] minorPictureAddress) {
        this.minorPictureAddress = minorPictureAddress;
    }

    public String getBagInformation() {
        return bagInformation;
    }

    public void setBagInformation(String bagInformation) {
        this.bagInformation = bagInformation;
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
