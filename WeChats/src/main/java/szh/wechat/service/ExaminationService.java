package szh.wechat.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import szh.wechat.dao.ExaminationDao;
import szh.wechat.pojo.Examination;

public interface ExaminationService {
	   public List GetAllExam();
	//点击连接后浏览次数加一
		void updateExanhit(Map<String, Object> map);
}
