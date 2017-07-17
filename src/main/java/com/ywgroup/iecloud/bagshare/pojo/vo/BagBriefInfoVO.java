package com.ywgroup.iecloud.bagshare.pojo.vo;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017-7-11.
 */
public class BagBriefInfoVO {
    private Integer id;
    private String name;
    private String engname;
    private String img;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String content;
    private BigDecimal pricezu;
    private BigDecimal priceya;
    private String status;
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

    public String getEngname() {
        return engname;
    }

    public void setEngname(String engname) {
        this.engname = engname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
