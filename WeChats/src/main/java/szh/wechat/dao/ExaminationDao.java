package szh.wechat.dao;

import java.util.List;

import szh.wechat.pojo.Examination;

public interface ExaminationDao {
	//获取所有的考试分类标题
	public List<Examination> GetAllExam();
	//获取考试分类下面的所有试题
	public List<Examination> GetDetailExam();
}
