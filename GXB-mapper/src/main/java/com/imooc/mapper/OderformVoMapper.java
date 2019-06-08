package com.imooc.mapper;

import com.imooc.pojo.Oderform;
import com.imooc.pojo.vo.OderformVo;
import com.imooc.utils.MyMapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OderformVoMapper extends MyMapper<Oderform> {
    public List<OderformVo> queryAllOderform(@Param("description")String description,
                                             @Param("getterid") String getterId);
}
