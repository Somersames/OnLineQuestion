package szh.wechat.dao;

import szh.wechat.pojo.Users;

public interface UserDao {
	 Users getUser(String user_name);
	 Users getUserQuestion(String user_name);
}
