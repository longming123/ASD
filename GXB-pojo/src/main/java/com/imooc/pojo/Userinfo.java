package com.imooc.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;

@ApiModel(value="用户对象", description="这是用户对象")
public class Userinfo {


    @ApiModelProperty(hidden=true)
    @Id
    private String uid;
    /**
     * 用户名
     */
    @ApiModelProperty(value="用户名", name="nickname", example="asdasd", required=true)
    private String uname;
    /**
     * 昵称
     */
    @ApiModelProperty(hidden=true)
    private String nickname;
    /**
     * 昵称
     */
    @ApiModelProperty(value="密码", name="upassword", example="123456", required=true)
    private String upassword;

    /**
     *头像
     */
    @ApiModelProperty(hidden=true)
    @Column(name = "faceImage")
    private String faceimage;
    /**
     * 学校
     */
    @ApiModelProperty(hidden=true)
    @Column(name = "uschool")
    private String uschool;
    /**
     * 学院
     */
    @ApiModelProperty(hidden=true)
    @Column(name = "udepart")
    private String udepart;
    /**
     * 号码
     */
    @ApiModelProperty(hidden=true)
    @Column(name = "utele")
    private String utele;

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