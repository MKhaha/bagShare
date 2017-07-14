package com.ywgroup.iecloud.bagshare.pojo;

public class Adress {
    private Integer id;

    private Integer uid;

    private String adress;

    private Integer type;

    public Adress(Integer id, Integer uid, String adress, Integer type) {
        this.id = id;
        this.uid = uid;
        this.adress = adress;
        this.type = type;
    }

    public Adress() {
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}