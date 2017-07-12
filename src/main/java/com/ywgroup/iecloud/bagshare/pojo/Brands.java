package com.ywgroup.iecloud.bagshare.pojo;

public class Brands {
    private Integer id;

    private String engname;

    private String name;

    private String picture;

    private String summary;

    public Brands(Integer id, String engname, String name, String picture, String summary) {
        this.id = id;
        this.engname = engname;
        this.name = name;
        this.picture = picture;
        this.summary = summary;
    }

    public Brands() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEngname() {
        return engname;
    }

    public void setEngname(String engname) {
        this.engname = engname == null ? null : engname.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }
}