package com.ywgroup.iecloud.bagshare.pojo;

public class Banners {
    private Integer id;

    private String title;

    private String href;

    private String img;

    public Banners(Integer id, String title, String href, String img) {
        this.id = id;
        this.title = title;
        this.href = href;
        this.img = img;
    }

    public Banners() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}