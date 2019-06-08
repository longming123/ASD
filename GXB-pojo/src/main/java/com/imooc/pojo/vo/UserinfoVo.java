package com.imooc.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class UserinfoVo {
    private String id;

    private String userToken;

    private boolean isFollow;

    private String uid;
    private String uname;
    private String nickname;
    @JsonIgnore
    private String upassword;


    private String faceimage;
    private String uschool;
    private String udepart;
    private String utele;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public boolean isFollow() {
        return isFollow;
    }

    public void setFollow(boolean follow) {
        isFollow = follow;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword == null ? null : upassword.trim();
    }

    public String getFaceimage() {
        return faceimage;
    }

    public void setFaceimage(String faceimage) {
        this.faceimage = faceimage == null ? null : faceimage.trim();
    }

    public String getUschool() {
        return uschool;
    }

    public void setUschool(String uschool) {
        this.uschool = uschool == null ? null : uschool.trim();
    }

    public String getUdepart() {
        return udepart;
    }

    public void setUdepart(String udepart) {
        this.udepart = udepart == null ? null : udepart.trim();
    }

    public String getUtele() {
        return utele;
    }


    public void setUtele(String utele) {
        this.utele = utele == null ? null : utele.trim();
    }
}
