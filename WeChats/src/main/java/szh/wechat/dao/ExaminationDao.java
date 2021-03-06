package szh.wechat.dao;

import java.util.List;
import java.util.Map;

import szh.wechat.pojo.Examination;

public interface ExaminationDao {
	//获取所有的考试分类标题
	public List<Examination> GetAllExam();
	//获取考试分类下面的所有试题
	public List<Examination> GetDetailExam();
	//点击连接后浏览次数加一
	void updateExanhit(Map<String, Object> map);
}
