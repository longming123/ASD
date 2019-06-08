package com.imooc.service;

import com.imooc.pojo.Comments;
import com.imooc.pojo.Oderform;
import com.imooc.utils.PagedResult;

import java.util.List;

public interface OrderService {
    /**
     * 保存订单
     *
     * @param oderform
     */
    public void saveOderform(Oderform oderform);
    /**
     * 更新订单
     *
     * @param
     */
    public void updateOderform(Oderform oderform);



    /**
     * 查询订单
     *
     * @param
     */
    public PagedResult getAllOderform(Oderform oderform, Integer isSaveRecord,
                                      Integer page, Integer pageSize);

    /**
     * @Description: 获取热搜词列表
     */
    public List<String> getHotwords();

    /**
     * @Description: 用户留言
     */
    public void saveComment(Comments comment);

    /**
     * @Description: 留言分页
     */
    public PagedResult getAllComments(String videoId, Integer page, Integer pageSize);

}
