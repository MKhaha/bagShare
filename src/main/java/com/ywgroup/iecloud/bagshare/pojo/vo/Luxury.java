package com.ywgroup.iecloud.bagshare.pojo.vo;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017-7-11.
 */
public class Luxury {
    private Integer id;
    private String name;
    private String brands;

    public String getBrands() {
        return brands;
    }

    public void setBrands(String brands) {
        this.brands = brands;
    }

    private String img;
    private BigDecimal pricezu;
    private BigDecimal priceya;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


}
