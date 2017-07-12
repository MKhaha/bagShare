package com.ywgroup.iecloud.bagshare.pojo;

public class Category {
    private Integer id;

    private String name;

    private String picture;

    public Category(Integer id, String name, String picture) {
        this.id = id;
        this.name = name;
        this.picture = picture;
    }

    public Category() {
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }
}