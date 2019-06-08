package com.imooc.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.mapper.*;
import com.imooc.pojo.Comments;
import com.imooc.pojo.Oderform;
import com.imooc.pojo.SearchRecords;
import com.imooc.pojo.vo.CommentsVO;
import com.imooc.pojo.vo.OderformVo;
import com.imooc.service.OrderService;
import com.imooc.utils.PagedResult;
import com.imooc.utils.TimeAgoUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OderformMapper oderformMapper;

    @Autowired
    private OderformVoMapper oderformVoMapper;

    @Autowired
    private SearchRecordsMapper searchRecordsMapper;

    @Autowired
    private CommentsMapper commentMapper;

    @Autowired
    private CommentsMapperCustom commentMapperCustom;

    @Autowired
    private Sid sid;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveOderform(Oderform oderform) {
        String id = sid.nextShort();
        oderform.setOId(id);
        oderformMapper.insert(oderform);
//        return id;
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void updateOderform(Oderform oderform) {
        Example oderformExample = new Example(Oderform.class);
        Example.Criteria criteria = oderformExample.createCriteria();
        criteria.andEqualTo("oid", oderform.getOId());
        oderformMapper.updateByExampleSelective(oderform, oderformExample);
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PagedResult getAllOderform(Oderform oderform, Integer isSaveRecord,
                                      Integer page, Integer pageSize) {
        // 保存热搜词
        String description = oderform.getDescription();
        String getterId = oderform.getGetterId();
        if (isSaveRecord != null && isSaveRecord == 1) {
            SearchRecords record = new SearchRecords();
            String recordId = sid.nextShort();
            record.setId(recordId);
            record.setContent(description);
            searchRecordsMapper.insert(record);
        }
        PageHelper.startPage(page, pageSize);
        List<OderformVo> list = oderformVoMapper.queryAllOderform(description,getterId);
        PageInfo<OderformVo> pageList = new PageInfo<>(list);
        PagedResult pagedResult = new PagedResult();
        pagedResult.setPage(page);
        pagedResult.setTotal(pageList.getPages());
        pagedResult.setRows(list);
        pagedResult.setRecords(pageList.getTotal());

        return pagedResult;
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<String> getHotwords() {

        return searchRecordsMapper.getHotwords();
    }
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveComment(Comments comment) {
        String id = sid.nextShort();
        comment.setId(id);
        comment.setCreateTime(new Date());
        commentMapper.insert(comment);
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PagedResult getAllComments(String videoId, Integer page, Integer pageSize) {

        PageHelper.startPage(page, pageSize);

        List<CommentsVO> list = commentMapperCustom.queryComments(videoId);

        for (CommentsVO c : list) {
            String timeAgo = TimeAgoUtils.format(c.getCreateTime());
            c.setTimeAgoStr(timeAgo);
        }

        PageInfo<CommentsVO> pageList = new PageInfo<>(list);

        PagedResult grid = new PagedResult();
        grid.setTotal(pageList.getPages());
        grid.setRows(list);
        grid.setPage(page);
        grid.setRecords(pageList.getTotal());

        return grid;
    }

}
