package szh.wechat.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import szh.wechat.dao.ExerciseDao;
import szh.wechat.pojo.Exercise;
import szh.wechat.service.ExerciseService;

@Service
public class ExerciseServiceImpl implements ExerciseService {
	@Autowired
	ExerciseDao exerciseDao;

	public List<Exercise> GetAllExercise() {
		return exerciseDao.GetAllExercise();
	}

	public List<Exercise> GetSignleExercise(String examination) {
		return exerciseDao.GetSignleExercise(examination);
	}

	public Exercise GetExerciseById(int exercise_id) {
		return exerciseDao.GetExerciseById(exercise_id);
	}

	public List<Exercise> GetLimitExercise(Map<String, Object> map) {
		return exerciseDao.GetLimitExercise(map);
	}

	public List<Exercise> GetExaminationType(Map<String, Object> map) {
		return exerciseDao.GetExaminationType(map);
	}

	public int GetCountExercise(Map<String, Object> map) {
		return exerciseDao.GetCountExercise(map);
	}

	public String getRightAnswere(int exercise_id) {
		return exerciseDao.getRightAnswere(exercise_id);
	}

}
