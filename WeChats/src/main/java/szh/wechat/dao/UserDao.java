package szh.wechat.dao;

import java.util.Map;

import szh.wechat.pojo.Users;

public interface UserDao {
	 Users getUser(String user_name);
	 Users getUserQuestion(String user_name);
	 Users checkUser(Map<String, Object> map);
}
