package com.imooc.Controller;

import com.imooc.pojo.Comments;
import com.imooc.pojo.Oderform;
import com.imooc.service.OrderService;
import com.imooc.service.UserService;
import com.imooc.utils.IMoocJSONResult;
import com.imooc.utils.PagedResult;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value="订单相关业务的接口", tags= {"订单相关业务的controller"})
@RequestMapping("/oderform")
public class OderformController extends BasicController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	/**
	 *
	 * @Description: 分页和搜索查询订单列表
	 * isSaveRecord：1 - 需要保存
	 * 				 0 - 不需要保存 ，或者为空的时候
	 */
	@PostMapping(value="/showAll")
	public IMoocJSONResult showAll(@RequestBody Oderform oderform,
								   Integer isSaveRecord,Integer page,
								   Integer pageSize) throws Exception {

		if (page == null) {
			page = 1;
		}

		if (pageSize == null) {
			pageSize = PAGE_SIZE;
		}

		PagedResult result = orderService.getAllOderform(
				oderform, isSaveRecord,page, pageSize);
		return IMoocJSONResult.ok(result);
	}
	//	热搜词
	@PostMapping(value="/hot")
	public IMoocJSONResult hot() throws Exception {
		return IMoocJSONResult.ok(orderService.getHotwords());
	}
	@PostMapping("/saveComment")
	public IMoocJSONResult saveComment(@RequestBody Comments comment,
                                       String fatherCommentId, String toUserId) throws Exception {
		
		comment.setFatherCommentId(fatherCommentId);
		comment.setToUserId(toUserId);

		orderService.saveComment(comment);
		return IMoocJSONResult.ok();
	}
	
	@PostMapping("/getVideoComments")
	public IMoocJSONResult getVideoComments(String videoId, Integer page, Integer pageSize) throws Exception {
		
		if (StringUtils.isBlank(videoId)) {
			return IMoocJSONResult.ok();
		}
		
		// 分页查询视频列表，时间顺序倒序排序
		if (page == null) {
			page = 1;
		}

		if (pageSize == null) {
			pageSize = 10;
		}
		
		PagedResult list = orderService.getAllComments(videoId, page, pageSize);
		
		return IMoocJSONResult.ok(list);
	}
	
}
