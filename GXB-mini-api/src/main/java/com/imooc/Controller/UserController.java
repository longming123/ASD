package com.imooc.Controller;

import com.imooc.enums.OderformStateEnum;
import com.imooc.pojo.Oderform;
import com.imooc.pojo.Userinfo;
import com.imooc.pojo.UsersReport;
import com.imooc.pojo.vo.UserinfoVo;
import com.imooc.service.OrderService;
import com.imooc.service.UserService;
import com.imooc.utils.IMoocJSONResult;
import com.imooc.utils.PagedResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;

@RestController
@Api(value="用户相关业务的接口", tags= {"用户相关业务的controller"})
@RequestMapping("/user")
public class UserController extends BasicController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private OrderService orderService;
	
	@ApiOperation(value="用户上传头像", notes="用户上传头像的接口")
	@ApiImplicitParam(name="userId", value="用户id", required=true, 
						dataType="String", paramType="query")
	@PostMapping("/uploadFace")
	public IMoocJSONResult uploadFace(String userId,
									  @RequestParam("file") MultipartFile[] files) throws Exception {
		if(StringUtils.isBlank(userId)){
			return IMoocJSONResult.errorMsg("用户id不能为空");
		}
		// 文件保存的命名空间
		String fileSpace = "C:/imooc_videos_dev";
		// 保存到数据库中的相对路径
		String uploadPathDB = "/" + userId + "/face";

		FileOutputStream fileOutputStream = null;
		InputStream inputStream = null;
		try {
			if (files != null && files.length > 0) {

				String fileName = files[0].getOriginalFilename();
				if (StringUtils.isNotBlank(fileName)) {
					// 文件上传的最终保存路径
					String finalFacePath = fileSpace + uploadPathDB + "/" + fileName;
					// 设置数据库保存的路径
					uploadPathDB += ("/" + fileName);

					File outFile = new File(finalFacePath);
					if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
						// 创建父文件夹
						outFile.getParentFile().mkdirs();
					}

					fileOutputStream = new FileOutputStream(outFile);
					inputStream = files[0].getInputStream();
					IOUtils.copy(inputStream, fileOutputStream);
				}

			} else {
				return IMoocJSONResult.errorMsg("上传出错...");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return IMoocJSONResult.errorMsg("上传出错...");
		} finally {
			if (fileOutputStream != null) {
				fileOutputStream.flush();
				fileOutputStream.close();
			}
		}

		Userinfo user = new Userinfo();
		user.setUid(userId);
		user.setFaceimage(uploadPathDB);
		userService.updateUserInfo(user);
		return IMoocJSONResult.ok(uploadPathDB);
//		return IMoocJSONResult.ok();
	}
	@ApiOperation(value="用户修改信息", notes="用户修改信息")
	@PostMapping("/update")
	public IMoocJSONResult update(@RequestBody Userinfo userInfo)throws Exception{

		userService.updateUserInfo(userInfo);
		return IMoocJSONResult.ok();


	}
	@ApiOperation(value="查询用户信息", notes="查询用户信息的接口")
	@ApiImplicitParam(name="userId", value="用户id", required=true,
			dataType="String", paramType="query")
	@PostMapping("/query")
	public IMoocJSONResult query(String userId)throws Exception{
		if (StringUtils.isBlank(userId)){
			return IMoocJSONResult.errorMsg("用户id不能为空...");
		}
		Userinfo userInfo = userService.queryUserInfo(userId);
		UserinfoVo usersVO = new UserinfoVo();
		BeanUtils.copyProperties(userInfo,usersVO);
		return IMoocJSONResult.ok(usersVO);

	}

	@ApiOperation(value="用户上传订单", notes="用户上传订单的接口")
//	@ApiImplicitParams({
//			@ApiImplicitParam(name="title", value="订单title", required=false,
//					dataType="String", paramType="query"),
//			@ApiImplicitParam(name="description", value="订单详情", required=false,
//					dataType="String", paramType="query"),
//			@ApiImplicitParam(name="reward", value="订单金额", required=true,
//					dataType="Integer", paramType="query"),
//			@ApiImplicitParam(name="posterId", value="订单发布者id", required=false,
//					dataType="String", paramType="query"),
//	})
	@PostMapping("/order")
	public IMoocJSONResult order(@RequestBody Oderform oderform
	) throws Exception {
		try {
			if (StringUtils.isBlank(oderform.getDescription()) || StringUtils.isBlank(oderform.getTitle())) {
				return IMoocJSONResult.errorMsg("标题和描述不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return IMoocJSONResult.errorMsg("发布出错...");
		}
//		保存订单到数据库
//		Oderform oderform=new Oderform();
//		oderform.setPosterId(posterId);
//		oderform.setReward(reward);
//		oderform.setDescription(description);
//		oderform.setTitle(title);
		oderform.setState(OderformStateEnum.SUCCESS.value);
		oderform.setOtime(new Date());
		orderService.saveOderform(oderform);
		return IMoocJSONResult.ok();
	}
	@ApiOperation(value="用户接受订单", notes="用户接受订单的接口")
	@ApiImplicitParams({
			@ApiImplicitParam(name="getterId", value="订单接受者id", required=false,
					dataType="String", paramType="query"),
			@ApiImplicitParam(name="oid", value="订单id", required=false,
					dataType="String", paramType="query")
	})
	//  查询订单发布者的信息
	@PostMapping("/queryPublisher")
	public IMoocJSONResult queryPublisher(String publishUserId) throws Exception {

		if (StringUtils.isBlank(publishUserId)) {
			return IMoocJSONResult.errorMsg("");
		}

		// 1. 查询视频发布者的信息
		Userinfo user = userService.queryUserInfo(publishUserId);
		UserinfoVo publisher = new UserinfoVo();
		BeanUtils.copyProperties(user, publisher);
		return IMoocJSONResult.ok(publisher);
	}
	@PostMapping("/order/update")
	public IMoocJSONResult update(String oid,
								  String getterId
	) throws Exception {
		try {//		保存订单到数据库
			Oderform oderform = new Oderform();
			oderform.setOId(oid);
			oderform.setGetterId(getterId);
			orderService.updateOderform(oderform);

//			if (oderform.getPosterId() == getterId) {
//				return IMoocJSONResult.errorMsg("接单出错：自己不能接自己的订单");
//			}
			return IMoocJSONResult.ok();
		}catch (Exception e) {

			e.printStackTrace();
			return IMoocJSONResult.errorMsg("系统出错...");
		}
	}
	@PostMapping("/reportUser")
	public IMoocJSONResult reportUser(
			@RequestBody UsersReport usersReport) throws Exception {

		// 保存举报信息
		userService.reportUser(usersReport);

		return IMoocJSONResult.errorMsg("举报成功...有你平台变得更美好...");
	}
}
