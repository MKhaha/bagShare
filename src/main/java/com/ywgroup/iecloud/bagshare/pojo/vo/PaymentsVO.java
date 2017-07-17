package com.ywgroup.iecloud.bagshare.pojo.vo;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017-7-13.
 */
public class PaymentsVO {

    private Integer id;         //订单id
    private BigDecimal price;   //订单价格
    private String adress;      //收货地址
    private String phone;       //手机号
    private String name;        //包名字
    private String engname;     //品牌名
    private String img;         //包包图片
    private String content;     //成色
    private Integer times;        //   租的月数
    private Integer bid;
    private BigDecimal pricezu; //租金
    private BigDecimal priceya; //押金
    private String status;      //状态
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }
}
