package com.ywgroup.iecloud.bagshare.pojo.vo;

/**
 * Created by Administrator on 2017-7-11.
 */
public class Recommend {
    private Integer id;

    private String name;

    private String majorPictureAddress;

    private String bagInformation;

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

    public String getMajorPictureAddress() {
        return majorPictureAddress;
    }

    public void setMajorPictureAddress(String majorPictureAddress) {
        this.majorPictureAddress = majorPictureAddress;
    }

    public String getBagInformation() {
        return bagInformation;
    }

    public void setBagInformation(String bagInformation) {
        this.bagInformation = bagInformation;
    }
}
