package com.imooc.pojo.vo;


import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class OderformVo {
    private String oid;
    private String posterId;
    private String getterId;
    private Integer reward;
    private Integer state;
    private String title;
    private String description;
    private Date otime;
    private String faceimage;
    private String nickname;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getFaceimage() {
        return faceimage;
    }

    public void setFaceimage(String faceimage) {
        this.faceimage = faceimage;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取订单描述
     *
     * @return video_desc - 订单描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置订单描述
     *
     * @param
     */
    public void setDescription(String videoDesc) {
        this.description = videoDesc;
    }



    /**
     * 设置订单标题
     *
     * @param
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getOtime() {
        return otime;
    }

    /**
     * 设置创建时间
     *
     * @param
     */
    public void setOtime(Date otime) {
        this.otime = otime;
    }


    public String getPosterId() {
        return posterId;
    }

    public void setPosterId(String posterId) {
        this.posterId = posterId;
    }

    public String getGetterId() {
        return getterId;
    }

    public void setGetterId(String getterld) {
        this.getterId = getterld;
    }

    public Integer getReward() {
        return reward;
    }

    public void setReward(Integer reward) {
        this.reward = reward;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
