package com.ywgroup.iecloud.bagshare.pojo;

public class Favourite {
    private Integer id;

    private String userid;

    private String bagid;

    public Favourite(Integer id, String userid, String bagid) {
        this.id = id;
        this.userid = userid;
        this.bagid = bagid;
    }

    public Favourite() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getBagid() {
        return bagid;
    }

    public void setBagid(String bagid) {
        this.bagid = bagid == null ? null : bagid.trim();
    }
}