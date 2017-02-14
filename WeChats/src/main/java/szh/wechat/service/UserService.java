package szh.wechat.service;

import szh.wechat.pojo.Users;

public interface UserService {
	//根据用户名获取用户信息
	Users getUser(String user_name);
	//用户登录或者找回密码验证
	Users getUserQuestion(String user_name);
}
