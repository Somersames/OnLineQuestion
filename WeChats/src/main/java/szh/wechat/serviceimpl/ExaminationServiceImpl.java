package szh.wechat.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import szh.wechat.dao.ExaminationDao;
import szh.wechat.service.ExaminationService;
@Service
public class ExaminationServiceImpl implements ExaminationService{
	@Autowired
	private ExaminationDao examinationDao;

	public List GetAllExam() {
		return examinationDao.GetAllExam();
	}
	
}
