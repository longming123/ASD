package com.imooc.Controller;



import com.imooc.pojo.Userinfo;
import com.imooc.pojo.UsersReport;
import com.imooc.pojo.vo.UserinfoVo;
import com.imooc.service.UserService;
import com.imooc.utils.IMoocJSONResult;
import com.imooc.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Api(value="用户注册登录的接口", tags= {"注册和登录的controller"})
public class RegistLoginController extends BasicController{
	@Autowired
	private UserService userService;

	@ApiOperation(value="用户注册", notes="用户注册的接口")
	@PostMapping("/regist")
	public IMoocJSONResult regist(@RequestBody Userinfo user) throws Exception {

		// 1. 判断用户名和密码必须不为空
		if (StringUtils.isBlank(user.getUname()) || StringUtils.isBlank(user.getUpassword())) {
			return IMoocJSONResult.errorMsg("用户名和密码不能为空");
		}
		// 2. 判断用户名是否存在
		boolean unameIsExist = userService.queryUnameIsExist(user.getUname());
		// 3. 保存用户，注册信息
		if (!unameIsExist) {
			user.setNickname(user.getUname());
			user.setUpassword((MD5Utils.getMD5Str(user.getUpassword())));
			user.setUtele("123456");
			user.setUschool("0");
			user.setUdepart("0");
			userService.saveUser(user);
		} else {
			return IMoocJSONResult.errorMsg("用户名已经存在，请换一个再试");
		}
		user.setUpassword("");
//		String uniqueToken = UUID.randomUUID().toString();
//		redis.set(USER_REDIS_SESSION+":"+user.getId(),uniqueToken,1000*60*30);
//		UsersVO usersVO =new UsersVO();
//		BeanUtils.copyProperties(user,usersVO);
//		usersVO.setUserToken(uniqueToken);
		UserinfoVo userVO = setUserRedisSessionToken(user);
		return IMoocJSONResult.ok(userVO);
	}
	public UserinfoVo setUserRedisSessionToken(Userinfo userModel) {
		String uniqueToken = UUID.randomUUID().toString();
		redis.set(USER_REDIS_SESSION + ":" + userModel.getUid(), uniqueToken, 1000 * 60 * 30);

		UserinfoVo userVO = new UserinfoVo();
		BeanUtils.copyProperties(userModel, userVO);
		userVO.setUserToken(uniqueToken);
		return userVO;
	}

	@ApiOperation(value="用户登录", notes="用户登录的接口")
	@PostMapping("/login")
	public IMoocJSONResult login(@RequestBody Userinfo user) throws Exception {
		String uname = user.getUname();
		String upassword = user.getUpassword();
//		Thread.sleep(3000);

		// 1. 判断用户名和密码必须不为空
		if (StringUtils.isBlank(uname) || StringUtils.isBlank(upassword)) {
			return IMoocJSONResult.ok("用户名或密码不能为空...");
		}

		// 2. 判断用户是否存在
		Userinfo userResult = userService.queryUserForLogin(uname,
				MD5Utils.getMD5Str(user.getUpassword()));

		// 3. 返回
		if (userResult != null) {
			userResult.setUpassword("");
			UserinfoVo userVO = setUserRedisSessionToken(userResult);
			return IMoocJSONResult.ok(userVO);
		} else {
			return IMoocJSONResult.errorMsg("用户名或密码不正确, 请重试...");
		}
	}
	@ApiOperation(value="用户注销", notes="用户注销的接口")
	@ApiImplicitParam(name="userId",value = "用户id",required = true,dataType = "String",
			paramType = "query")
	@PostMapping("/logout")
	public IMoocJSONResult logout(String userId) throws Exception {
		redis.del(USER_REDIS_SESSION+":"+userId);
			return IMoocJSONResult.errorMsg("注销成功！！！");
	}

}
