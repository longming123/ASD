package com.imooc.service;

import com.imooc.pojo.Userinfo;
import com.imooc.pojo.UsersReport;

public interface UserService {

	/**
	 * @Description: 判断用户名是否存在
	 */
	public boolean queryUnameIsExist(String username);

	/**
	 * @Description: 保存用户(用户注册)
	 */
	public void saveUser(Userinfo user);

	/**
	 * @Description: 用户登录，根据用户名和密码查询用户
	 */
	public Userinfo queryUserForLogin(String username, String password);

	/**
	 * @Description: 用户修改信息
	 */
	public void updateUserInfo(Userinfo user);

	/**
	 * @Description: 查询用户信息
	 */
	public Userinfo queryUserInfo(String userId);

	/**
	 * @Description: 举报用户
	 */
	public void reportUser(UsersReport userReport);
}
