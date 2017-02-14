package szh.wechat.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import szh.wechat.pojo.Exercise;

public interface ExerciseDao {
	//查询所有的题目
	public List<Exercise> GetAllExercise();
	//查询特定类别的题目
	public List<Exercise> GetSignleExercise(String examination);
	//根据题目id查询题目
	public Exercise GetExerciseById(int exercise_id);
	//分页用的数据库查询
	public List<Exercise> GetLimitExercise(Map<String,Object> map);
	//根据选择的类别来获取下面的所有试题
	public List<Exercise> GetExaminationType(Map<String, Object> map);
	//获取题目总数
	public int GetCountExercise(Map<String, Object> map);
}
