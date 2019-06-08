package com.imooc.pojo;


import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Oderform {
    @Id
    private String oid;
    /**
     * 发布者id
     */
    @Column(name = "posterId")
    private String posterId;

    /**
     * 接受者id
     */
    @Column(name = "getterId")
    private String getterId;
    /**
     * 订单金额
     */
    @Column(name = "reward")
    private Integer reward;
    /**
     * 订单状态：
     1、发布成功
     2、禁止发布，管理员操作
     */
    @Column(name = "state")
    private Integer state;

    /**
     * 订单主题  title
     */
    @Column(name = "title")
    private String title;
    /**
     * 订单描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 创建时间
     */
    @Column(name = "otime")
    private Date otime;

    /**
     * @return 订单id
     */
    public String getOId() {
        return oid;
    }

    /**
     * @param id
     */
    public void setOId(String id) {
        this.oid = id;
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
