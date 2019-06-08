package com.imooc.service.Impl;

import com.imooc.mapper.UserinfoMapper;
import com.imooc.mapper.UsersReportMapper;
import com.imooc.pojo.Userinfo;
import com.imooc.pojo.UsersReport;
import com.imooc.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserinfoMapper userinfoMapper;
	@Autowired
	private UsersReportMapper usersReportMapper;
	@Autowired
	private Sid sid;
	@Transactional(propagation = Propagation.SUPPORTS)
	public boolean queryUnameIsExist(String uname) {

		Userinfo user = new Userinfo();
		user.setNickname(uname);

		Userinfo result = userinfoMapper.selectOne(user);

		return result == null ? false : true;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveUser(Userinfo user) {

		String userId = sid.nextShort();
		user.setUid(userId);
		userinfoMapper.insert(user);
	}
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public Userinfo queryUserForLogin(String uname, String upassword) {

		Example userExample = new Example(Userinfo.class);
		Example.Criteria criteria = userExample.createCriteria();
		criteria.andEqualTo("uname", uname);
		criteria.andEqualTo("upassword", upassword);
		Userinfo result = userinfoMapper.selectOneByExample(userExample);

		return result;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public  void updateUserInfo(Userinfo user){
		Example userExample = new Example(Userinfo.class);
		Example.Criteria criteria = userExample.createCriteria();
		criteria.andEqualTo("uid",user.getUid());
		userinfoMapper.updateByExampleSelective(user ,userExample);
	}
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public Userinfo queryUserInfo(String useruid){
		Example userExample = new Example(Userinfo.class);
		Example.Criteria criteria = userExample.createCriteria();
		criteria.andEqualTo("uid",useruid);
		Userinfo user=userinfoMapper.selectOneByExample(userExample);
		return user;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void reportUser(UsersReport userReport) {

		String urId = sid.nextShort();
		userReport.setId(urId);
		userReport.setCreateDate(new Date());

		usersReportMapper.insert(userReport);
	}
}

