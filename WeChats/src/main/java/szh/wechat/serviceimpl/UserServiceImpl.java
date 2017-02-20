package szh.wechat.serviceimpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import szh.wechat.dao.UserDao;
import szh.wechat.pojo.Users;
import szh.wechat.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	public Users getUser(String user_name) {
		return userDao.getUser(user_name);
	}

	public Users getUserQuestion(String user_name) {
		return userDao.getUserQuestion(user_name);
	}

	public Users checkUser(Map<String, Object> map) {
		return userDao.checkUser(map);
		
	}

}
